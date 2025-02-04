Feature: Get All Brands List

  @api3
  Scenario: API 3: Get All Brands List

    Given I set the base API URL
    When The api user sends a "GET" request to "/brandsList" endpoint
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".
    And The api user verifies response should contain "brands" array

  @api4
  Scenario: API 4: PUT To All Brands List

    Given I set the base API URL
    When The api user sends a "PUT" request to "/brandsList" endpoint
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "405".
    And The api user verifies that the "message" information in the response body is "This request method is not supported.".