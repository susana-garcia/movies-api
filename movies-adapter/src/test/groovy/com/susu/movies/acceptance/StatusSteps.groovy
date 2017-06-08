package com.susu.movies.acceptance

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks

import static com.susu.movies.acceptance.common.BaseApiClient.givenApiClient


this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

/**
 * Created by Susana on 13/07/15.
 */

def appStatus
def adapterURL

Before {
  adapterURL = null
}

Given(~'^adapter URL set to "([^"]*)"$') { String newAdapterURL ->
  adapterURL = newAdapterURL
}

When(~'^app status requested$') { ->
  appStatus = givenApiClient().get('/status').body().as(Map)
}

Then(~'^app status is "([^"]*)"$') { String expectedStatus ->
  assert appStatus.status == expectedStatus
}

Then(~'^adapter URL is "([^"]*)"$') { String expectedAdapterUrl ->
  assert appStatus.adapterURL == expectedAdapterUrl
}

Then(~'^adapter status is "([^"]*)"$') { String adapterStatus ->
  assert appStatus.adapterStatus == adapterStatus
}
