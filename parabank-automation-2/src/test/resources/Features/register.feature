Feature: Register

  Scenario: Successful User Registration

    Given User opens Register page
    When User enters registration details
    And User clicks Register button
    Then Registration should be successful