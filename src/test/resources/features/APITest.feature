Feature: API Testing with Reqres

  Scenario: Get single user
    Given I have the API endpoint "/users/2"
    When I send a GET request to the endpoint
    Then the response status code should be 200
    And the response should contain "data.first_name" with value "Janet"
