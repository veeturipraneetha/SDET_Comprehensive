
Feature: search flights

  Scenario: user should be able to search the flights when user entered the details
    Given EdgeDriver must be opened
    When User enter into the MakeMyTrip page
    Then User need to click on flights
    Then User need to select from and to details
    Then User need to select the departure and return date
    Then User need to click search button
    Then User should be able to see the search results