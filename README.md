#cypress-assignment

#Serenity Testing Assignment

## Introduction
This is a test automation framework for API Testing using Serenity BDD, Cucumber & Java.


## Setup & Execution

1. Install Java 1.8 & maven to operate from commandline or use same versions in any IDE of your choice.
2. Run the tests using the command `mvn clean verify -Denvironment=test`. This will clean the target folder and execute all the tests.
3. You can also run test from the [TestRunner](src/test/java/com/qlick/assignment/TestRunner.java) class

## Brief about the framework:
- DTOs: DTOs are the JSON data models for parsing string data into java object. This is a good way to make sure the JSON fits the given contract. 
Also, this is an easy way to read data from DTO object for verification. We are using lombok for reducing the boilerplate code for DTOs.
- Stepdefs: These are the step definitions which for cucumber scenarios calling to steps.
- Steps: Steps are to maintain the business logic and making API calls.
- Utils: Utils are for all the utilities. [SerenityRestUtil](src/test/java/com/qlick/assignment/utils/SerenityRestUtils.java) is for making the API calls. [SerenityConfiguration](src/test/java/com/qlick/assignment/utils/SerenityConfiguration.java) is to load serenity configurations from [serenity.conf](src/test/resources/serenity.conf).

Maintaining different package for each module like we have currently `search` module. This will make it very clean and maintainable when we have more tests for different modules.

### CI Execution
 GitHub Actions([e2e_ci.yml](.github/workflows/e2e_ci.yml)) for automated test execution in CI. Currently, it's configured to run on push event to main branch and pull request to main branch.


## Changes done in the given project:
- Removed some dependencies which were specific to webdriver & UI test automation.
- Removed maven surefire plugin as we have failsafe plugin which solves the purpose.
- Update group and artifact id as per the current structure & name.
- Restructured the framework make it more clean and maintainable.
- Updated step definitions and moved business logic to steps to add extra layer of abstraction.
- Added utils for reusable API calls using Serenity.
- Added SerenityConfiguration for reading the configurations for different environments from serenity config file.
- Update serenity config file with given URL as the default base URL and test environment URL to run by default on given URL and allow support for different environment configs. 
- Added EndPoints class to maintain all the API endpoints.
- Removed all the gradle related files & cleaned up project for not required directories and files.

[Serenity BDD Guide](SerenityBDD.md)