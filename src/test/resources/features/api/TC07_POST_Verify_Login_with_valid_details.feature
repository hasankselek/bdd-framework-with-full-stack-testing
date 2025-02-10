@regression
Feature: Verify Loggin

  @api7
  Scenario: API 7: Verify Login with Valid Credentials

    Given I set the base API URL
    When The api user sends a POST request to "/verifyLogin" endpoint with credentials:
      | email    | hasankucukselek7@gmail.com |
      | password | test123                    |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".
    And The api user verifies that the "message" information in the response body is "User exists!".