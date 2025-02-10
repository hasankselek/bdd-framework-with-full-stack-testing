@regression
Feature: Verify Loggin

  @api8
  Scenario: API 8: POST To Verify Login without email parameter

    Given I set the base API URL
    When The api user sends a POST request to "/verifyLogin" endpoint without email credentials:
      | password | invalid123 |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "400".
    And The api user verifies that the "message" information in the response body is "Bad request, email or password parameter is missing in POST request.".

