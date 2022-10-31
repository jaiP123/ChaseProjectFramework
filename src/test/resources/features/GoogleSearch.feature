@sanity
Feature:
  As a user
  I want to google search for J. P. Morgan
  So that result website shows logo

  Scenario: Search company name
    Given user navigates to google website
    When the search phrase "J. P. Morgan" is entered
    And user clicks on search button
    Then results for "Morgan" are shown

  Scenario: Search logo image
    Given user search for "J. P. Morgan" on google
    When  user click on first link of results page
    Then logo image of J. P. Morgan is shown