Feature: TC01 - New User Registration
  As a visitor
  I want to register to the website
  So that I can have my own account

  @test
  Scenario: TC01 - Successful user registration

    Given The user navigate to "url" website
    Then The user should see the home page
    When The user clicks Signup Login button
    Then The user should see "New User Signup!" text
    When The user enter name "John Doe" and  email for registration
    And The user clicks signup button
    Then The user should see "ENTER ACCOUNT INFORMATION" text
    When The user fill account details
      | Field          | Value     |
      | Title          | Mr        |
      | Password       | Test123!  |
      | Day of birth   | 02        |
      | Month of birth | September |
      | Year of birth  | 1996      |
    And I select newsletter subscription and special offers
    And I fill address details
      | Field         | Value           |
      | First name    | John            |
      | Last name     | Doe             |
      | Company       | Test Company    |
      | Address       | 123 Test Street |
      | Address2      | Apt 4           |
      | Country       | United States   |
      | State         | California      |
      | City          | Los Angeles     |
      | Zipcode       | 90001           |
      | Mobile number | +1234567890     |