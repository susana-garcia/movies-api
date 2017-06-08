package com.susu.movies.search.adapter

import com.susu.movies.MoviesProperties
import com.susu.movies.model.SearchMoviesRequest
import spock.lang.Specification


class SearchMoviesUrlBuilderTest extends Specification {

  MoviesProperties moviesProperties = new MoviesProperties(
    apiKey: 'apiKeyValue',
    apiUri: 'apiUriValue',
    searchMovieUri: '/searchMovieUri'
  )
  SearchMoviesUrlBuilder urlBuilder = new SearchMoviesUrlBuilder(
    moviesProperties: moviesProperties
  )

  def "should build url"() {

    when:
    String uri = urlBuilder.build(request)

    then:
    uri == expectedUri

    where:
    request                                | expectedUri
    createRequest('fight')                 | '/searchMovieUri?api_key=apiKeyValue&query=fight'
    createRequest('fight club')            | '/searchMovieUri?api_key=apiKeyValue&query=fight+club'
    createRequest('fight', 1, true)        | '/searchMovieUri?api_key=apiKeyValue&query=fight&page=1&include_adult=true'
    createRequest('fight', 2, false, 1983) | '/searchMovieUri?api_key=apiKeyValue&query=fight&page=2&include_adult=false&primary_release_year=1983'

  }

  private SearchMoviesRequest createRequest(String query, Integer page = null, Boolean includeAdult = null, Integer primaryReleaseYear = null) {
    new SearchMoviesRequest(
      query: query,
      page: page,
      includeAdult: includeAdult,
      primaryReleaseYear: primaryReleaseYear
    )
  }
}
