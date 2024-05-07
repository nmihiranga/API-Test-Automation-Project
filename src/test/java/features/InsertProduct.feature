Feature: Insert products using POST API

  Scenario Outline: Validate POST product API works correctly
    Given I hit the url of post product API endpoint
    When I pass the url of products in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response code as 200
    Examples:
      | ProductTitle |
      | Shoes        |