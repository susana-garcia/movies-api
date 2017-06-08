package com.susu.movies

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Profile
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.retry.annotation.EnableRetry

/**
 * Created by Susana on 05/07/15.
 */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableRetry
class ApplicationConfiguration {

  @Bean
  @Profile('mock')
  static PathMatchingResourcePatternResolver resourceResolver() {
    new PathMatchingResourcePatternResolver()
  }
}