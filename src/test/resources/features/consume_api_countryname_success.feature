Feature: Consume api successfully
  me as appgate candidate
  I need to consume the Country Name geonames api
  to validate the country name for a country successfully

    Background:
    Given user call an api

    @successArgentina
    Scenario: Consume api country name success
      When the user consumes the api with the lat and lon parameters
        | latitude | length|
        | -38.416097|-63.616672|
    Then he should see the information the success country name for Argentina

  @successJapan
  Scenario: Consume api timezone success
    When the user consumes the api with the lat and lon parameters
      | latitude | length|
      | 35.6895|139.69171|
    Then he should see the information the success country name for Japan

  @successFrance
  Scenario: Consume api timezone success
    When the user consumes the api with the lat and lon parameters
      | latitude | length|
      | 48.85341|2.3488|
    Then he should see the information the success country name for France