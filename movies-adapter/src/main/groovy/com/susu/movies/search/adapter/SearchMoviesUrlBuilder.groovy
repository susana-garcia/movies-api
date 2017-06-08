package com.susu.movies.search.adapter

import com.susu.movies.MoviesProperties
import com.susu.movies.model.SearchMoviesRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder

/**
 * Created by Susana on 11/07/15.
 */

@Component
class SearchMoviesUrlBuilder {

  private static final String API_KEY_PARAM = "api_key"
  private static final String QUERY_PARAM = "query"
  private static final String PAGE_PARAM = "page"
  private static final String INCLUDE_ADULT_PARAM = "include_adult"
  private static final String YEAR_PARAM = "year"
  private static final String PRIMARY_RELEASE_YEAR_PARAM = "primary_release_year"

  @Autowired
  MoviesProperties moviesProperties

  public String build(SearchMoviesRequest request) {
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(moviesProperties.searchMovieUri)

    addQueryParam(uriComponentsBuilder, "${API_KEY_PARAM}", moviesProperties.apiKey)
    addQueryParam(uriComponentsBuilder, "${QUERY_PARAM}", URLEncoder.encode(request.query, 'UTF-8'))
    addOptionalParamsIfPresent(request, uriComponentsBuilder)

    uriComponentsBuilder.build()
  }

  private void addOptionalParamsIfPresent(SearchMoviesRequest request, UriComponentsBuilder uriComponentsBuilder) {
    if (request.page) addQueryParam(uriComponentsBuilder, "${PAGE_PARAM}", request.page)
    if (request.includeAdult != null) addQueryParam(uriComponentsBuilder, "${INCLUDE_ADULT_PARAM}", request.includeAdult)
    if (request.year) addQueryParam(uriComponentsBuilder, "${YEAR_PARAM}", request.year)
    if (request.primaryReleaseYear) addQueryParam(uriComponentsBuilder, "${PRIMARY_RELEASE_YEAR_PARAM}", request.primaryReleaseYear)
  }

  private UriComponentsBuilder addQueryParam(UriComponentsBuilder uriComponentsBuilder, String paramName, Object paramValue) {
    uriComponentsBuilder.queryParam(paramName, paramValue)
  }
}
