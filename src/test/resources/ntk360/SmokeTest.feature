Feature: User Page Feature

  Background: 
    Given User is logged in and in NTK Dashboard page

  @smoke
  Scenario Outline: Verify employee username
    When User navigates to Users page
    Then User verifies employee data "<EmployeeName>","<Username>"

    Examples: 
      | EmployeeName | Username    |
      | Aaliyah Haq  | Aaliyah.haq |

  #| Alice Duval     | Alice           |
  #| Brody Alan      | Brody           |
  #| Cecil Bonaparte | Cecil.bonaparte |
  #| David Cole      | David.cole      |
  
  @smoke
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
