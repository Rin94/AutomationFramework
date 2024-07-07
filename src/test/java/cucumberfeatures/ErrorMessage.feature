Feature: Retrieve the error message in the login form
  Guest user fills invalid password and username the page display an error message.

  Background:
    Given I landed on Ecommerce page
  @Smoke
  Scenario Outline:
    When username <username> and password <password> is logged
    Then the <errorMessage> message is displayed

    Examples:
      | username      | password  | errorMessage |
      |wrong@gmail.com|Admin@12345| Incorrect email or password.|