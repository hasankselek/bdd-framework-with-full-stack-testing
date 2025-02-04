Feature: Search Product

  @api5
  Scenario: API 5: Search Product with Valid Query

    Given I set the base API URL
    When The api user sends a POST request to "/searchProduct" endpoint with search query:
      | search_product | tshirt |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".

  @api6
  Scenario: API 6: Search Product with Empty Query

    Given I set the base API URL
    When The api user sends a POST request to "/searchProduct" endpoint with search query:
      | search_product |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "200".

