package com.susu.movies.acceptance.common

/**
 * Created by Susana on 13/07/15.
 */
class StoryContext {

  static class Fields {
    public static String RESPONSE = 'response'
  }

  static Map context = [:]

  static def getFromContext(String key) {
    context.get(key)
  }

  static def putInContext(def key, def value) {
    context.put(key, value)
  }
}
