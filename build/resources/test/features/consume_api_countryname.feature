Feature: Consume api successfully
  me as appgate candidate
  I need to consume the Country Name geonames api
  to validate the country name for colombia successfully

  Scenario: Consume api country name
    Given user call an api
    When the user consumes the api with the lat and lon parameters
      | latitude | length|
      | 4.570868|-74.297333|
    Then he should see the information the Country Name for Colombia