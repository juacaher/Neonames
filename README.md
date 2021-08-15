"# Neonames" 
## Introduction

Timezone
Webservice Type : REST
Url : api.geonames.org/timezone?
Parameters : lat,lng, radius (buffer in km for closest timezone in coastal areas),lang (for countryName), date (date for sunrise/sunset);
Result : the timezone at the lat/lng with gmt offset (1. January) and dst offset (1. July)
Example http://api.geonames.org/timezone?lat=47.01&lng=10.2&username=demo

This service is also available in JSON format : http://api.geonames.org/timezoneJSON?lat=47.01&lng=10.2&username=demo


Element:
countryCode: ISO countrycode
countryName: name (language can be set with param lang)
timezoneId: name of the timezone (according to olson), this information is sufficient to work with the timezone and defines DST rules, consult the documentation of your development environment. Many programming environments include functions based on the olson timezoneId (example java TimeZone)
time: the local current time
sunset: sunset local time (date)
sunrise: sunrise local time (date)
rawOffset: the amount of time in hours to add to UTC to get standard time in this time zone. Because this value is not affected by daylight saving time, it is called raw offset.
gmtOffset: offset to GMT at 1. January (deprecated)
dstOffset: offset to GMT at 1. July (deprecated)

## Pre requirements
- Java version 1.8 update 151 or higher and JDK(environment variables configured).
- Eclipse IDE or Intellij IDEA (version 2019.2 or higher).
- Gradle Version 5.2.1 or higher(environment variables configured).
- Cucumber for Java Plugin (update version).
- Gherkin Plugin (update version).


## Installation

- To clone this repository, the following command must be run:
  git clone https://github.com/juacaher/Neonames
- Import the project from Eclipse or Intellij under structure of an existing Gradle project.
- Configure JRE System Library with JavaSE-1.8.
- Configure the encoding to UTF-8 to the project once it is imported.

## Project structure
- src/main/java/co/com/appgate/certification/geonames

-exceptions
Classes that exceptions and throw custom messages when automation fails due to it is not found what was expected.

-integrations
Classes that enable connection to services.

-interactions
Classes that perform low-level actions.

-models
Classes that perform high-level actions

-utils
Classes that contain common functionalities.

-questions
Classes that contain validation information.

- src/test/java/co/com/appgate/certification/geonames

-runners
Classes to run the automations with the scenarios indicated in the equivalents Features.

-stepdefinitions
Classes that allow the translation of the Gherkin language used in the Features into machine language, this
make possible the execution of automation. there is  a general Step Definitions class that contains the configuration and step that are repeated in the other Step Definitions.

- src/test/resources/features/

-features
The project features are found.

##Building
Automation was  developed with:

-BDD - Development strategy.
-Screenplay pattern - Desing pattern that applies  SOLID principles.
-Gradle - Dependency manager.
-SerenityRest - to automate actions in the api.
-Cucumber -framework to automate BDD tests.
-Serenity BDD - Framework, Open source library for report generation.
-Gherkin - Bussiness-readable domain specific language (DSL)

##Version ING
-Git was used for  version control, applying the Trunk Based Development methodology.


##Command for execution
The project can be executed from the console with the following command:
- gradle clean test aggregate

##Author
**JUAN CAMILO HERNANDEZ PULGARIN** -[camilo.bk.2010@gmail.com]
 
