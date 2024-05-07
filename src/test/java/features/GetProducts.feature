Feature: Get all products from the API

  Scenario: Verify the GET API for the products
    Given I hit the url of get products API endpoint
    When I pass the url of products in the request
    Then I receive the response code as 200

  Scenario Outline: Verify the rate of the first product is correct
    Given I hit the url of get products API endpoint
    When I pass the url of products in the request
    Then I verify that the rate of the first product is <FirstProductRate>
    Examples:
      | FirstProductRate |
      | 3.9              |