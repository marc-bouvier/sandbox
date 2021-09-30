$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:hellocucumber/is_it_friday_yet.feature");
formatter.feature({
  "name": "Is it Friday yet?",
  "description": "    Everybody wants to know when it\u0027s Friday",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Today is or is not Friday",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "today is \"\u003cday\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "I ask whether it\u0027s friday yet",
  "keyword": "When "
});
formatter.step({
  "name": "I should be told \"\u003canswer\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "day",
        "answer"
      ]
    },
    {
      "cells": [
        "Friday",
        "TGIF"
      ]
    },
    {
      "cells": [
        "Sunday",
        "Nope"
      ]
    },
    {
      "cells": [
        "anything else",
        "Nope"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Today is or is not Friday",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "today is \"Friday\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.today_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask whether it\u0027s friday yet",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.i_ask_whether_it_s_friday_yet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be told \"TGIF\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.i_should_be_told(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Today is or is not Friday",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "today is \"Sunday\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.today_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask whether it\u0027s friday yet",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.i_ask_whether_it_s_friday_yet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be told \"Nope\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.i_should_be_told(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Today is or is not Friday",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "today is \"anything else\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.today_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask whether it\u0027s friday yet",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefs.i_ask_whether_it_s_friday_yet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be told \"Nope\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefs.i_should_be_told(String)"
});
formatter.result({
  "status": "passed"
});
});