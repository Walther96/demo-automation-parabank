@OpenAccount
Feature: Transfer Funds

  @OpenNewAccount
  Scenario: Trunsfer funds on the PARABANK website
    Given the user opens PARABANK page
    When enters the username "mlopez" and password "mlopez"
    And selects link "Open New Account"
    And opens an account "SAVINGS" and selects minimum of "12789" to be deposited
    Then should display "Account Opened!"