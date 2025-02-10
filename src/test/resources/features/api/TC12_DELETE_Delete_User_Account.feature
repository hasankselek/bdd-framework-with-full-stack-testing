@regression
Feature: Delete User

  @api12
  Scenario: API 12: DELETE METHOD To Delete User Account

    Given I set the base API URL
    When The api user sends a DELETE request to "/deleteAccount" endpoint with user information:
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".
    And The api user verifies that the "message" information in the response body is "Account deleted!".


