@regression
Feature: Get All Products List

  @api2
  Scenario: API 2: POST To All Products List

    Given I set the base API URL
    When The api user sends a "POST" request to "/productsList" endpoint
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "405".
    And The api user verifies that the "message" information in the response body is "This request method is not supported.".