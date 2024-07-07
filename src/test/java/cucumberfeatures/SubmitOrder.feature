@Tag
  Feature: Purchase the order from Ecommerce Website
    My feature file

    Background:
      Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given username <username> and password <password> is logged
    When A product <productName> is added to the Cart
    And user selects his country <country>
    And Place the order
    Then The page displays the <confirmationOrder>


    Examples:
      |username            |password   |productName|country|confirmationOrder |
      |jared12345@gmail.com|Admin@12345|ZARA COAT 3|Belgium|THANKYOU FOR THE ORDER.|
      |jared12345@gmail.com|Admin@12345|IPHONE 13 PRO|Japan|THANKYOU FOR THE ORDER.|