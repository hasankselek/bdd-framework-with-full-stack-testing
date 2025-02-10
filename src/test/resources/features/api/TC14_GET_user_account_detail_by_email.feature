@regression
Feature: Get account detail

  @api14
  Scenario: GET user account detail by email

    Given I set the base API URL
    When The api user sends a GET request to "/getUserDetailByEmail" endpoint with email
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".
    And The api user validate username