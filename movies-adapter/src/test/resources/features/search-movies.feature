Feature: Search movies

  Scenario: Test success movies searching
    Given app has started
    When we received a search movies request
      | query      | page | language | includeAdult | year | primaryReleaseYear |
      | club       | 0    | en       |              |      |                    |
      | fight club | 0    | en       |              |      |                    |
    Then status code 200 returned

  Scenario: Test fails because query parameter is not provided
    Given app has started
    When we received a search movies request
      | query | page | language | includeAdult | year | primaryReleaseYear |
      |       | 0    | en       |              |      |                    |
    Then status code 400 returned

  Scenario: Test fails because client throws SearchMoviesException
    Given app has started
    When we received a search movies request
      | query | page | language | includeAdult | year | primaryReleaseYear |
      | error | 0    | en       |              |      |                    |
    Then status code 500 returned
