package com.susu.movies.search

import com.fasterxml.jackson.databind.ObjectMapper
import com.susu.movies.model.SearchMoviesRequest
import com.susu.movies.search.adapter.DefaultSearchMoviesAdapter
import com.susu.movies.search.adapter.SearchMoviesException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.client.RestClientException
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Created by Susana on 12/07/15.
 */

class SearchMoviesControllerTest extends Specification {

  DefaultSearchMoviesAdapter defaultMoviesAdapter = Mock(DefaultSearchMoviesAdapter)

  SearchMoviesController searchMoviesController = new SearchMoviesController(
    defaultMoviesAdapter: defaultMoviesAdapter
  )

  def "should get movies"() {

    MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter()
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(searchMoviesController).setMessageConverters(jacksonConverter).build()

    when:
    def response = mockMvc.perform(post("/search")
      .contentType(MediaType.APPLICATION_JSON)
      .content(getMapperRequest(searchMoviesRequest))
    )

    then:
    numberOfCalls * defaultMoviesAdapter.searchMovies(_) >> { adapterResponse.call() }
    response.andExpect(status().is(statusCode))

    where:
    searchMoviesRequest                     | numberOfCalls | adapterResponse                              | statusCode
    new SearchMoviesRequest(query: 'query') | 1             | {}                                           | HttpStatus.OK.value()
    new SearchMoviesRequest(query: 'query') | 1             | { throw new SearchMoviesException('error') } | HttpStatus.INTERNAL_SERVER_ERROR.value()
    new SearchMoviesRequest(query: 'query') | 1             | { throw new RestClientException('error') }   | HttpStatus.INTERNAL_SERVER_ERROR.value()
    new SearchMoviesRequest()               | 0             | {}                                           | HttpStatus.BAD_REQUEST.value()
  }

  String getMapperRequest(SearchMoviesRequest request) {
    ObjectMapper mapper = new ObjectMapper()
    ByteArrayOutputStream stream = new ByteArrayOutputStream()
    mapper.writeValue(mapper.getFactory().createGenerator(stream), request)
    stream.toString()
  }
}
