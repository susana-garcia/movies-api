package com.susu.movies.acceptance

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import org.apache.http.HttpStatus

import static com.susu.movies.acceptance.common.BaseApiClient.givenApiClient
import static com.susu.movies.acceptance.common.StoryContext.getFromContext
import static com.susu.movies.acceptance.common.StoryContext.Fields.RESPONSE

/**
 * Created by Susana on 13/07/15.
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Given(~'^app has started$') { ->
  assert givenApiClient().get('/status').statusCode == 200
}

Then(~'^status code (\\d+) returned$') { int expectedStatusCode ->
  assert getFromContext(RESPONSE).statusCode == expectedStatusCode
}

Then(~'^access forbidden$') { ->
  assert getFromContext(RESPONSE).statusCode == HttpStatus.SC_FORBIDDEN
}

Then(~'^access unauthorized$') { ->
  assert getFromContext(RESPONSE).statusCode == HttpStatus.SC_UNAUTHORIZED
}