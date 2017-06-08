package com.susu.movies

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonTypeInfo

/**
 * Created by Susana on 04/07/15.
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
class Movie {

  @JsonProperty("title")
  private String title

  @JsonProperty("original_title")
  private String originalTitle

  @JsonProperty("release_date")
  private String releaseDate

  @JsonProperty("overview")
  private String overview

  @JsonProperty("vote_average")
  private float voteAverage
}
