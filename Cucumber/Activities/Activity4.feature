@Activity4
  Feature: Data driven test without Example
    Scenario: Testing with Data from Scenario
      Given User is on the Login Page
      When  User enter "admin" and "password"
      Then  Read the Page Title and Confirmation Message
      And   Close the Browser!