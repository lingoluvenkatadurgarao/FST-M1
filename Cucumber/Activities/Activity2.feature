@Activity2
  Feature: Login Test
    Scenario: Testing Login
      Given User is on the Login Page
      When  User enter UserName and Password
      Then  Read the Page Title and Confirmation Message
      And   Close the Browser!