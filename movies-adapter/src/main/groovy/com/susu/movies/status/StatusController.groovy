package com.susu.movies.status

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Susana on 05/07/15.
 */

@RestController
class StatusController {

  @RequestMapping(value = '/status', method = RequestMethod.GET)
  Status getStatus() {
    new Status(status: 'OK')
  }
}
