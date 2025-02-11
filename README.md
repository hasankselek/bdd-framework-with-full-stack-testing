# BDD Full-Stack Test Automation Framework

This project is a comprehensive test automation framework built using Behavior Driven Development (BDD) principles, supporting both API and UI testing.

## 🚀 Features

- BDD approach using Cucumber
- API testing capabilities using REST Assured
- UI testing support
- Parallel test execution
- Detailed reporting
- Hooks for test setup and teardown
- Base test configuration management

## 🛠 Technologies & Tools

- Java 11+
- Cucumber (BDD)
- REST Assured
- Selenium WebDriver
- TestNG/JUnit
- Maven
- Faker
- JSON Object
- Log4j for logging

## 🏗 Project Structure

```
src
├── main/java
│   ├── base
│   │   └── BaseTest.java         # Base test configuration
│   └── hooks
│       └── HooksAPI.java         # API test hooks
└── test/java/automation
    ├── runner
    │   ├── TestRunner.java       # Main test runner
    │   └── API_Runner.java       # API specific test runner
    └── stepdefinitions
        └── api
            └── ApiSteps.java     # API test step definitions
```

## 🔧 Prerequisites

- Java JDK 11 or higher
- Maven
- Your favorite IDE (IntelliJ IDEA recommended)
- Git

## ⚙️ Setup & Installation

1. Clone the repository:
```bash
git clone <repository-url>
```

2. Navigate to the project directory:
```bash
cd bdd-framework-with-full-stack-testing
```

3. Install dependencies:
```bash
mvn clean install
```

## 🏃‍♂️ Running Tests

### Running All Tests
```bash
mvn clean test
```

### Running API Tests Only
```bash
mvn clean test -Dcucumber.filter.tags="@api"
```

### Running UI Tests Only
```bash
mvn clean test -Dcucumber.filter.tags="@ui"
```

## 📝 Writing Tests

### API Test Example
```gherkin
Feature: API Testing Example

  Scenario: Verify user creation
    Given I set the base API URL
    When The api user sends a POST request to "/createAccount" endpoint with user information:
    Then The api user verifies that the status code is 200.
    And The api user verifies that the "responseCode" information in the response body is "201".
    And The api user verifies that the "message" information in the response body is "User created!".
```

### UI Test Example
```gherkin
Feature: UI Testing Example

Scenario: User Login
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
    Then I should be redirected to the dashboard
```

## 📊 Reporting

The framework generates detailed reports after test execution. You can find the reports in:
- Cucumber HTML Report: `target/cucumber-reports/index.html`
- TestNG Report: `target/surefire-reports/index.html`

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details
