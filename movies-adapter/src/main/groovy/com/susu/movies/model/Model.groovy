package com.susu.movies.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * Created by Susana on 05/07/15.
 */

@ToString(includePackage = false, includeNames = true)
@EqualsAndHashCode
class SearchMoviesRequest {

  @NotNull
  @NotEmpty
  String query

  Integer page

  Boolean includeAdult

  Integer year

  Integer primaryReleaseYear

  String language
}
