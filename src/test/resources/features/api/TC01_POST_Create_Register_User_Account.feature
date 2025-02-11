@regression
Feature: Create and Register User Account

  @api11
  Scenario:API 11 : POST To Create/Register User Account

    Given I set the base API URL
    When The api user sends a POST request to "/createAccount" endpoint with user information:
      | title         | Mr                         |
      | birth_day     | 15                         |
      | birth_month   | 6                          |
      | birth_year    | 1990                       |
      | firstname     | John                       |
      | lastname      | Doe                        |
      | company       | Test Company               |
      | address1      | 123 Test St                |
      | address2      | Apt 4                      |
      | country       | United States              |
      | state         | California                 |
      | city          | Los Angeles                |
      | zipcode       | 90001                      |
      | mobile_number | 312312                     |
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "201".
    And The api user verifies that the "message" information in the response body is "User created!".