Feature: User visits the Products Page

  Background:
    Given I am on the Login Page
    And I log in with standard user credentials
    Then I should be in the products list page

  @AddProduct
  Scenario: User visits the Products Page
    When I add an item to the cart using a button
    When I add an item to the cart by dragging
    Then I should see cart value increased
