Feature: Delete product using PUT API

  Scenario Outline: Validate DELETE product API status code works correctly
    Given I hit the url of DELETE product API endpoint
    When I pass the url of delete products in the request with <ProductNumber>
    Then I receive the response code as 200
    Examples:
      | ProductNumber |
      | 5             |
