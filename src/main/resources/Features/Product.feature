@test
Feature: Add product

  Scenario: Verify that User Can Sign Up Successfully
    Given user navigate into web
    When user click on Sign up button in the Header
    And user enter Username "Arsany Elkess Begool Fathy12"
    And user enter Password "arsany2000"
    And user click on SignUp button
    Then A success "Sign up successful." should be displayed


  Scenario: Verify that two products are purchased successfully

# 1-Login
# Given I am on the home page
    Given user navigate into web
    When user clicks on the login button in the header
    And user fills in the login form with username "Arsany Elkess Begool Fathy12" and password "arsany2000"
    Then make sure that user logged in
  # 2-Add the first item
    Given Click on Laptops in categories in home page
    When user clicks on 1 laptop
    And Click on Add to cart button
    Then Validate that product is successfully added
    # 3-Add the second item
    Given Click on Product Store button in the Header
    When Click on Laptops in categories in home page
    And user clicks on 2 laptop
    And  Click on Add to cart button
    Then Validate that product is successfully added

    Given Validate that total amount is calculated correctly
    When Click on Place holder button
    And Validate that total amount is calculated correctly in place holder page
    And Filling Name "Arsany", Country "Egypt", City "Cairo", Credit Card "Visa", Month "4" and Year "24"
    And Click on Purchase button in place holder Form
    Then Validate that "Thank you for your purchase!" should be displayed





