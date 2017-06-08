package com.susu.movies.search.adapter

import com.susu.movies.SearchMoviesResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientException
import org.springframework.web.client.RestTemplate

/**
 * Created by Susana on 05/07/15.
 */

@Component
class SearchMoviesClient {

  @Autowired
  private RestTemplate restTemplate

  @Retryable(maxAttempts = 3, include = [SearchMoviesException], backoff = @Backoff(delay = 1000l, multiplier = 2d))
  SearchMoviesResponse searchMovies(String request) {

    SearchMoviesResponse response

    try {
      response = restTemplate.getForObject(request, SearchMoviesResponse)
    } catch (RestClientException e) {
      throw new SearchMoviesException("Error response from Movies API", e)
    }
    response
  }
}
