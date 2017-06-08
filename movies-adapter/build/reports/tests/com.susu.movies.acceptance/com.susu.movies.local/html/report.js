$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("search-movies.feature");
formatter.feature({
  "line": 1,
  "name": "Search movies",
  "description": "",
  "id": "search-movies",
  "keyword": "Feature"
});
formatter.before({
  "duration": 111163,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Test success movies searching",
  "description": "",
  "id": "search-movies;test-success-movies-searching",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "app has started",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "we received a search movies request",
  "rows": [
    {
      "cells": [
        "query",
        "page",
        "language",
        "includeAdult",
        "year",
        "primaryReleaseYear"
      ],
      "line": 6
    },
    {
      "cells": [
        "club",
        "0",
        "en",
        "",
        "",
        ""
      ],
      "line": 7
    },
    {
      "cells": [
        "fight club",
        "0",
        "en",
        "",
        "",
        ""
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "status code 200 returned",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.groovy:18"
});
formatter.result({
  "duration": 868686478,
  "status": "passed"
});
formatter.match({
  "location": "SearchMoviesSteps.groovy:20"
});
formatter.result({
  "duration": 366984543,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 12
    }
  ],
  "location": "CommonSteps.groovy:22"
});
formatter.result({
  "duration": 2746679,
  "status": "passed"
});
formatter.before({
  "duration": 19183,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Test fails because query parameter is not provided",
  "description": "",
  "id": "search-movies;test-fails-because-query-parameter-is-not-provided",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "app has started",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "we received a search movies request",
  "rows": [
    {
      "cells": [
        "query",
        "page",
        "language",
        "includeAdult",
        "year",
        "primaryReleaseYear"
      ],
      "line": 14
    },
    {
      "cells": [
        "",
        "0",
        "en",
        "",
        "",
        ""
      ],
      "line": 15
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "status code 400 returned",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.groovy:18"
});
formatter.result({
  "duration": 21744837,
  "status": "passed"
});
formatter.match({
  "location": "SearchMoviesSteps.groovy:20"
});
formatter.result({
  "duration": 107482242,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 12
    }
  ],
  "location": "CommonSteps.groovy:22"
});
formatter.result({
  "duration": 124754,
  "status": "passed"
});
formatter.before({
  "duration": 10501,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Test fails because client throws SearchMoviesException",
  "description": "",
  "id": "search-movies;test-fails-because-client-throws-searchmoviesexception",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "app has started",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "we received a search movies request",
  "rows": [
    {
      "cells": [
        "query",
        "page",
        "language",
        "includeAdult",
        "year",
        "primaryReleaseYear"
      ],
      "line": 21
    },
    {
      "cells": [
        "error",
        "0",
        "en",
        "",
        "",
        ""
      ],
      "line": 22
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "status code 500 returned",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.groovy:18"
});
formatter.result({
  "duration": 18395208,
  "status": "passed"
});
formatter.match({
  "location": "SearchMoviesSteps.groovy:20"
});
formatter.result({
  "duration": 50356859,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 12
    }
  ],
  "location": "CommonSteps.groovy:22"
});
formatter.result({
  "duration": 137074,
  "status": "passed"
});
formatter.uri("status.feature");
formatter.feature({
  "line": 1,
  "name": "App status",
  "description": "",
  "id": "app-status",
  "keyword": "Feature"
});
formatter.before({
  "duration": 17271,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Test app is running",
  "description": "",
  "id": "app-status;test-app-is-running",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "app has started",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "app status requested",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "app status is \"OK\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.groovy:18"
});
formatter.result({
  "duration": 35096513,
  "status": "passed"
});
formatter.match({
  "location": "StatusSteps.groovy:27"
});
formatter.result({
  "duration": 85916560,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OK",
      "offset": 15
    }
  ],
  "location": "StatusSteps.groovy:31"
});
formatter.result({
  "duration": 207634,
  "status": "passed"
});
});