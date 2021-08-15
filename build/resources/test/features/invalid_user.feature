Feature: Consume api failure
  me as appgate candidate
  I need to consume the geonames api
  to validate the error message for an empty user

  Background:
    Given user call an api

  @failureEmptyUser
  Scenario: Consume api and validate error message
    When the user consumes the api with the lat and lon parameters and user invalid
      | latitude | length|
      | -38.416097|-63.616672|
    Then he should see the information the error message
      |message|
      |invalid user |