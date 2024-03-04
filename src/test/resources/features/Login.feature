@Login
Feature: Check user login app

  Background:
    Given I am on the Login Page

  @StandardUser
  Scenario: User login to app
    When I log in with standard user credentials
    Then I should be in the products list page

  @LockedoutUser
  Scenario: User cant login to app
    When I log in with lockedout user credentials
    Then I should see lockedout error message