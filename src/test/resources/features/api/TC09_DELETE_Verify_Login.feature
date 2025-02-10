@regression
Feature: API 9

  @api9
  Scenario: API 9: Verify Login with Missing Credentials

    Given I set the base API URL
    When The api user sends a DELETE request to "/verifyLogin" endpoint
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "405".
    And The api user verifies that the "message" information in the response body is "This request method is not supported.".