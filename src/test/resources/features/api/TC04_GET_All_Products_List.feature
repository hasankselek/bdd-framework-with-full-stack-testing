@regression
Feature: Get All Products List

  @api1
  Scenario: API 1: Get All Products List

    Given I set the base API URL
    When The api user sends a "GET" request to "/productsList" endpoint
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".
    And The api user verifies response should contain "products" array