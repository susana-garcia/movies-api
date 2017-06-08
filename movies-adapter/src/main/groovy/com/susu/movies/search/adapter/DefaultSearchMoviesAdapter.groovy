package com.susu.movies.search.adapter

import com.susu.movies.SearchMoviesResponse
import com.susu.movies.model.SearchMoviesRequest
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Created by Susana on 13/07/15.
 */

@Slf4j
@Profile('!mock')
@Component(value = 'moviesAdapter')
class DefaultSearchMoviesAdapter implements SearchMoviesAdapter {

  @Autowired
  private SearchMoviesClient searchMoviesClient

  @Autowired
  private SearchMoviesUrlBuilder urlBuilder

  @Override
  SearchMoviesResponse searchMovies(SearchMoviesRequest request) {
    searchMoviesClient.searchMovies(urlBuilder.build(request))
  }
}
