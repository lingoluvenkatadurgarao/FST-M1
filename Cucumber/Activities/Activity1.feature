@Activity1
  Feature: First Test
    @SmokeTest
    Scenario: Opening a webpage using Selenium
      Given User is on the Google Page
      When  User types in Cheese and hit Enter
      Then  Show how many search results were Shown
      And   Close the Browser