@registerUser
@regression
Feature: Register User

  @registerSuccess
  Scenario: Successful user registration on the PARABANK website
    Given the user opens PARABANK page
    And goes to the Register option
    When the user enters his personal information
      | First name | Last name | Address | City | State | Zip code | Phone     | SSN    |
      | MARCOS     | LOPEZ     | AV Lima | Lima | Lima  | 01       | 999888777 | 123456 |
    And enters his login info
      | Password   | Repeat password |
      | mlopez1    | mlopez1         |
    Then confirms that his account has been created


  @registerNotSuccess
  Scenario: Not Successful user registration on the PARABANK website
    Given the user opens PARABANK page
    And goes to the Register option
    When the user enters his personal information
      | First name | Last name | Address | City | State | Zip code | Phone     | SSN    |
      | Ulises     | Perez     | AV Lima | Lima | Lima  | 01       | 999888777 | 123456 |
    And enters his login info
      | Password   | Repeat password |
      | uperes001  | uperes010       |
    Then should display a message "Passwords did not match."

