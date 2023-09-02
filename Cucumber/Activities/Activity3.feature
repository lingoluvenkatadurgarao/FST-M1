@Activity3
  Feature: Testing with Tags
    @SimpleAlert @SmokeTest
    Scenario: Testing with Simple Alert
      Given User is on the Home page
      When  User clicks the Simple Alert Button
      Then  Alert Opens
      And   Read the text form it and Print it
      And   Close the Alert
      And   Read the result text
      And   Close Browser

    @ConfirmAlert
     Scenario: Scenario: Test for Confirm Alert
      Given User is on the Home page
      When  User click on Confirm Alert Button
      Then  Alert Opens
      And   Read the text form it and Print it
      And   Close the Alert with Cancel
      And   Read the result text
      And   Close Browser


    @PromptAlert
    Scenario: Testing with Prompt Alert
      Given User is on the Home page
      When  User Clicks Prompt Alert Button
      Then  Alert Opens
      And   Read the text form it and Print it
      And   Write a custom message in it
      And   Close the Alert
      And   Read the result text
      And   Close Browser

