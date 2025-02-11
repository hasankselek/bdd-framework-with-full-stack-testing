@regression
Feature: Search Product

  @api6
  Scenario: API 6: Search Product with Empty Query

    Given I set the base API URL
    When The api user sends a POST request to "/searchProduct" endpoint without search query:
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "400".
    And The api user verifies that the "message" information in the response body is "Bad request, search_product parameter is missing in POST request.".

