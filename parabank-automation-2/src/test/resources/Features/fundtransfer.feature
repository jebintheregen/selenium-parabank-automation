Feature: Fund Transfer

  Scenario: Transfer Funds Successfully

    Given User is logged into ParaBank
    When User transfers money
    Then Transfer should complete successfully