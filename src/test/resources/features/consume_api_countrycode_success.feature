Feature: Consume api successfully
  me as appgate candidate
  I need to consume the Country Code geonames api
  to validate the country code for a country successfully

    Background:
    Given user call an api

    @successChina
    Scenario: Consume api country code success
      When the user consumes the api with the lat and lon parameters country code
        | latitude | length|
        | 35.0000000|105.0000000|
    Then he should see the information the success country code for CN