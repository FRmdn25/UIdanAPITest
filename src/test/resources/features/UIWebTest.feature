@UI
Feature: Sauce Demo Login

  Scenario: Valid login
    Given I open the Sauce Demo website
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the product page
