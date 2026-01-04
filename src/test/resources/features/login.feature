Feature: Login Critical Functionality

  @critical
  Scenario: Valid user should login successfully
    Given user is on login page
    When user enters valid username and password
    Then user should be logged in successfully
