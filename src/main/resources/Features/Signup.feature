
Feature: SignUp

  Scenario: Verify that User Can Sign Up Successfully
    Given user navigate into web
    When user click on Sign up button in the Header
    And user enter Username "Ahmedhytytiki"
    And user enter Password "ahmed2000"
    And user click on SignUp button
    Then A success "Sign up successful." should be displayed


  #Invalid Scenario

  Scenario Outline: Verify that user can't sign up with invalid data
    Given user navigate into web
    When user click on Sign up button in the Header
    And The user fills in their Invalid username "<username>" and password "<password>" in the form fields and The user submits the form.
    Then Validate that Wrong message is "<message>"
    Examples:
      | username            | password      | message                                 |
      | )()()(              | 123456        | This user already exist.                |
      | Arsany2000          | 123456        | This user already exist.                |
      | Ahmed2000           | 123456aA@     | This user already exist.                |
      |                     | 123456aA@     | Please fill out Username and Password.  |
      | Arsany150ty@        |               | Please fill out Username and Password.  |
      |                     |               | Please fill out Username and Password.  |
