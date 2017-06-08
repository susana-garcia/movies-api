package com.susu.movies

/**
 * Created by Susana on 05/07/15.
 */

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan(['com.susu.movies', 'platform'])
class Application {

  static void main(String[] args) {
    SpringApplication.run(Application, args)
  }
}
