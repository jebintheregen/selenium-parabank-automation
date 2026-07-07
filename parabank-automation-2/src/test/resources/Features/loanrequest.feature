Feature: Loan Request

  Scenario: Request a Loan Successfully

    Given User has logged into ParaBank
    When User requests a loan
    Then Loan request should be submitted