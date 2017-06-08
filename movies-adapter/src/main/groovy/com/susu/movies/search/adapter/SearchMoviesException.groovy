package com.susu.movies.search.adapter

/**
 * Created by Susana on 05/07/15.
 */

class SearchMoviesException extends RuntimeException {

  SearchMoviesException(String message) {
    super(message)
  }

  SearchMoviesException(String message, Throwable cause) {
    super(message, cause)
  }
}
