Feature: NTK Login feature

  Background: 
    Given User is on NTK login page

  Scenario: Successful login with valid credentials
    When User enters valid credentials
     And User clicks login button
    Then User is on dashboard page

  Scenario: Verify pending timesheet icon is displayed
    When User enters valid credentials
     And User clicks login button
    Then User is on dashboard page
     And System displays the pending timesheet icon

  Scenario: Verify pending leave request icon is displayed
    When User enters valid credentials
     And User clicks login button
    Then User is on dashboard page
     And System displays the pending leave request icon

  Scenario: Verify Scheduled Recruitment Event icon is displayed
    When User enters valid credentials
     And User clicks login button
    Then User is on dashboard page
     And System displays the Scheduled Recruitment Event icon
#Scenario: Successful logout
#Given User is on dashboard page
#When User logsout from the application
#Then User is redirected to sign-in page
