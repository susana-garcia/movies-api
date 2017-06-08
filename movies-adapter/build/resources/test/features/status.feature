Feature: App status

  Scenario: Test app is running
    Given app has started
    When app status requested
    Then app status is "OK"
