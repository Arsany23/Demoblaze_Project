
Feature: Login

  Scenario: Verify that user can login Successfully
    Given user navigate into web
    When user clicks on the login button in the header
    And user fills in the login form with username "Arsany2000" and password "123456"
    Then make sure that user logged in