@regression
Feature: Verify Loggin

  @api10
  Scenario: API 10: POST To Verify Login with invalid details

    Given I set the base API URL
    When The api user sends a POST request to "/verifyLogin" endpoint with credentials:
      | email    | asdasdas@gmail.com |
      | password | test123                    |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "404".
    And The api user verifies that the "message" information in the response body is "User not found!".