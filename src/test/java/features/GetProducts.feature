Feature: Get all products from the API

  Scenario: Verify the GET API for the products
    Given I hit the url of get products API endpoint
    When I pass the url of products to the request
    Then I receive the response code as 200