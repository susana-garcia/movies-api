package com.susu.movies.status

import groovy.transform.ToString
import org.hibernate.validator.constraints.NotEmpty

/**
 * Created by Susana on 05/07/15.
 */

@ToString(includeNames = true, includePackage = false, ignoreNulls = true)
class Status {
  @NotEmpty
  String status
}
