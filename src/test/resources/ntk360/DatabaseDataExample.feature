Feature: Job Titles feature

  Background: 
    Given User provides environment data
      | project | region | sprint | usNumber |
      | NTK     | Scrum  |     10 | NTK-458  |
      And User is logged in and in NTK Dashboard page

  Scenario: Adding new job to job tables
    When User navigates to Job Titles
     And User clicks on the Add icon
     And User provides db job title data
     And User clicks save button
    Then System displays successfuly message "Successfully Saved"
     And User updates execution result in db
