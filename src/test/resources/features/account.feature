@parabank-account
@regression
Feature: Transfer Funds

  @openNewAccount
  Scenario Outline: Open Account "<accountType>" on PARABANK website
    Given the user opens PARABANK page
    When enters the username and password
    And selects link "Open New Account"
    And opens an account "<accountType>" and selects account to transfer funds
    Then should display "Account Opened!"

      Examples:
        | accountType |
        | SAVINGS     |
        | CHECKING    |



