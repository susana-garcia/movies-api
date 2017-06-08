package com.susu.movies

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by Susana on 11/07/15.
 */

@ConfigurationProperties(prefix = 'movies')
@Component
class MoviesProperties {

  String apiUri

  String searchMovieUri

  String apiKey
}
