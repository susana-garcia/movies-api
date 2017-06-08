package com.susu.movies.search.adapter

import com.susu.movies.SearchMoviesResponse
import com.susu.movies.model.SearchMoviesRequest

/**
 * Created by Susana on 13/07/15.
 */
interface SearchMoviesAdapter {
  SearchMoviesResponse searchMovies(SearchMoviesRequest request)
}