package com.susu.movies

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * Created by Susana on 05/07/15.
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
class SearchMoviesResponse {

  @JsonProperty("results")
  private List<Movie> results

  @JsonProperty("page")
  private int page

  @JsonProperty("total_pages")
  private int totalPages

  @JsonProperty("total_results")
  private int totalResults
}
