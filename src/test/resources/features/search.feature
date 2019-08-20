@search_results
Feature: Search Results

  Where one can sort, filter and see details of resulting products

  @001
  Scenario: Search and verify results

    Given there is a non-registered customer

    When I act as the "customer"
    And I navigate to the site
    And I search for an item

    Then I should see a list of matching results
    And I should see that resulting items has price
    And I should see that resulting items has postage price

    When I sort the results by "Highest price"

    Then I should see that resulting items are sorted by price descending

    When I sort the results by "Lowest price"

    Then I should see that resulting items are sorted by price ascending

    When I filter results by "Auction"

    Then I should see that resulting items has no of bids

    When I filter results by "Buy it now"

    Then I should see that resulting items has the 'Buy it now' tag

  @002
  Scenario: Search per category

    Given there is a non-registered customer

    When I act as the "customer"
    And I navigate to the site
    And I select a category to search
    And I search for an item of the category

    Then I should see a list of matching results
    And I should see the item displayed

  @003
  Scenario: Search and navigate through results pages

    Given there is a non-registered customer

    When I act as the "customer"
    And I navigate to the site
    And I search for an item

    Then I should see a list of matching results
    And I should see that results show more than 1 page

    When I go to results page 2

    Then I should see a list of matching results
