@Activity5
  Feature: Login Test
    Scenario Outline: Testing Login with Example
      Given User is on the Login Page
      When  User enter "<UserNames>" and "<Passwords>"
      Then  Read the Page Title and Confirmation Message
      And Close the Browser!

      Examples:
      |UserNames  |Passwords   |
      |admin      |password    |
      |adminUser  |Password    |