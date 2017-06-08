package com.susu.movies.search

import com.susu.movies.SearchMoviesResponse
import com.susu.movies.model.SearchMoviesRequest
import com.susu.movies.search.adapter.SearchMoviesAdapter
import com.susu.movies.search.adapter.SearchMoviesException
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClientException

import javax.validation.Valid

/**
 * Created by Susana on 05/07/15.
 */

@Slf4j
@RestController
@RequestMapping(value = '/search')
@CompileStatic
class SearchMoviesController {

  @Autowired
  private SearchMoviesAdapter defaultMoviesAdapter

  @RequestMapping(method = RequestMethod.POST)
  public SearchMoviesResponse searchMovies(@Valid @RequestBody SearchMoviesRequest movieRequest) {
    defaultMoviesAdapter.searchMovies(movieRequest)
  }

  @ExceptionHandler(RestClientException)
  public ResponseEntity<String> handleSearchMoviesClientException(RestClientException e) {
    log.warn("Error searching movies ", e)
    new ResponseEntity<>(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
  }

  @ExceptionHandler(SearchMoviesException)
  public ResponseEntity<String> handleFlightStatsProviderException(SearchMoviesException e) {
    log.warn("Error searching movies ", e)
    new ResponseEntity<>(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
  }
}
