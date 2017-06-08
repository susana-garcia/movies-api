package platform

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by Susana on 05/07/15.
 */

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters << new StringHttpMessageConverter()
    converters << new MappingJackson2HttpMessageConverter(objectMapper: new ObjectMapper())
  }
}