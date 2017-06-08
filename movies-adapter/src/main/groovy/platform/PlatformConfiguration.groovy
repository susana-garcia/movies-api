package platform

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.http.client.support.HttpRequestWrapper
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.RestTemplate


/**
 * Created by Susana on 05/07/15.
 */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
class PlatformConfiguration {

  @Value('${adapter.pooling.connection.defaultMaxPerRoute}')
  private int defaultMaxPerRoute

  @Value('${adapter.pooling.connection.maxTotal}')
  private int maxTotal

  @Value('${adapter.connection.timeout.millisec}')
  private int connectionTimeout

  @Value('${adapter.read.timeout.millisec}')
  private int readTimeout

  @Value('${movies.apiUri}')
  private String moviesApiUri

  @Bean
  RestTemplate restTemplate(ObjectMapper objectMapper) {
    RestTemplate rs = buildRestTemplate()
    rs.setInterceptors([baseUrlHttpRequestInterceptor(moviesApiUri)])
    rs.setMessageConverters([new Jaxb2RootElementHttpMessageConverter(), messageConverter(objectMapper)])
    rs
  }

  @Bean
  static ObjectMapper objectMapper() {
    new ObjectMapper()
  }

  private ClientHttpRequestInterceptor baseUrlHttpRequestInterceptor(String apiUri) {
    new ClientHttpRequestInterceptor() {
      @Override
      ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper wrapper = new HttpRequestWrapper(request) {
          @Override
          URI getURI() {
            URI uri = super.getURI()
            String fragment = uri.toString()
            String url = apiUri + fragment
            try {
              return new URI(url)
            } catch (URISyntaxException ex) {
              throw new IllegalArgumentException("Could not create HTTP URL from [" + url + "]: " + ex, ex)
            }
          }
        };
        return execution.execute(wrapper, body)
      }
    }
  }

  private HttpClient getHttpClient() {
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager()
    connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute)
    connectionManager.setMaxTotal(maxTotal)

    HttpClientBuilder.create().setConnectionManager(connectionManager).build()
  }

  private RestTemplate buildRestTemplate() {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(getHttpClient())
    factory.setConnectTimeout(connectionTimeout)
    factory.setReadTimeout(readTimeout)

    RestTemplate rs = new RestTemplate(factory)
    rs.setErrorHandler(new DefaultResponseErrorHandler())
    rs
  }

  private MappingJackson2HttpMessageConverter messageConverter(ObjectMapper objectMapper) {
    MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter()
    jsonMessageConverter.setObjectMapper(objectMapper)
    jsonMessageConverter
  }
}
