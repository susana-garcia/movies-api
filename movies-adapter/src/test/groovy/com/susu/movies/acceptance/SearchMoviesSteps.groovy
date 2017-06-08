package com.susu.movies.acceptance

import com.susu.movies.model.SearchMoviesRequest
import cucumber.api.DataTable
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

import static com.susu.movies.acceptance.common.BaseApiClient.givenApiClient
import static com.susu.movies.acceptance.common.StoryContext.putInContext
import static com.susu.movies.acceptance.common.StoryContext.Fields.RESPONSE

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

/**
 * Created by Susana on 13/07/15.
 */


When(~'^we received a search movies request$') { DataTable dataTable ->

  def requestSpecification = givenApiClient().content(buildSearchMoviesRequest(dataTable))
  def response = requestSpecification.post('/search')

  putInContext(RESPONSE, response)
}

private SearchMoviesRequest buildSearchMoviesRequest(DataTable dataTable) {
  SearchMoviesRequest searchMoviesRequest = null
  dataTable.asMaps().each {
    searchMoviesRequest = new SearchMoviesRequest(
      query: it.query,
      page: it.page ? it.page as Integer : null,
      includeAdult: it.includeAdult ? it.includeAdult as Boolean : null,
      language: it.language ? it.language : null,
      year: it.year ? it.year as Integer : null,
      primaryReleaseYear: it.primaryReleaseYear ? it.primaryReleaseYear as Integer : null
    )
  }
  searchMoviesRequest
}