Feature: Add to cart functionality

  Background:
    Given I open the e-commerce site

  @test
  Scenario: Test
    Then I see landing page for e-commerce site
    When I search for ASUS
    Then I see results page
    When I add first 2 items on the cart
    And click to MY_CART page
    Then I see my selected items
    When I remove 1 items from the list
    Then I see 1 items in my cart
    When I remove 1 items from the list
    Then I see 0 items in my cart
#    When I remove 1 items from the list

