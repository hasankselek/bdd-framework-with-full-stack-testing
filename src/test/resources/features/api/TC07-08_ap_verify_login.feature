Feature: Verify Loggin

  @api7
  Scenario: API 7: Verify Login with Valid Credentials

    Given I set the base API URL
    When The api user sends a POST request to "/verifyLogin" endpoint with with credentials:
      | email    | hasankucukselek7@gmail.com |
      | password | test123                    |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".
    And The api user verifies that the "message" information in the response body is "User exists!".

  @api8
  Scenario: API 8: Verify Login with Invalid Credentials

    Given I set the base API URL
    When The api user sends a POST request to "/verifyLogin" endpoint with with credentials:
      | email    | hasankucukselek7@gmail.com |
      | password | invalid123                 |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "404".
    And The api user verifies that the "message" information in the response body is "User not found!".

  @api8
  Scenario: API 9: Verify Login with Missing Credentials

    Given I set the base API URL
    When The api user sends a POST request to "/verifyLogin" endpoint with with credentials:
      | email    |  |
      | password |  |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "404".
    And The api user verifies that the "message" information in the response body is "User not found!".