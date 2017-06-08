package com.susu.movies.search.adapter

import com.susu.movies.SearchMoviesResponse
import com.susu.movies.model.SearchMoviesRequest
import spock.lang.Specification

/**
 * Created by Susana on 13/07/15.
 */

class DefaultSearchMoviesAdapterTest extends Specification {

  SearchMoviesClient searchMoviesClient = Mock(SearchMoviesClient)
  SearchMoviesUrlBuilder urlBuilder = Mock(SearchMoviesUrlBuilder)
  DefaultSearchMoviesAdapter defaultSearchMoviesAdapter = new DefaultSearchMoviesAdapter(
    searchMoviesClient: searchMoviesClient,
    urlBuilder: urlBuilder
  )
  String uri = new String()

  def "should send request to flight stats client"() {

    SearchMoviesRequest request = new SearchMoviesRequest()

    when:
    defaultSearchMoviesAdapter.searchMovies(request)

    then:
    1 * urlBuilder.build(request) >> uri
    1 * searchMoviesClient.searchMovies(uri) >> new SearchMoviesResponse()
  }

  def "should throw error"() {

    SearchMoviesRequest request = new SearchMoviesRequest()

    when:
    defaultSearchMoviesAdapter.searchMovies(request)

    then:
    1 * urlBuilder.build(request) >> uri
    1 * searchMoviesClient.searchMovies(uri) >> {
      throw new SearchMoviesException('error')
    }
    SearchMoviesException e = thrown()

  }
}
