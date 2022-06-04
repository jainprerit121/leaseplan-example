Feature: search for products
  Scenario: Search valid product
    When Search product 'apple' returns with success
    Then Verify search product 'apple' api contains searched product

  Scenario Outline: Search invalid product
    When Search invalid product '<product>' returns with not found error
    Then Verify search product response contains error
    Examples:
      | product      |
      | tomato       |
      | @#$%^&*      |
      | invalidInput |