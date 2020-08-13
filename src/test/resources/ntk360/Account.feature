Feature: Job Titles Page

  Scenario: Verifying the user acount name
    Given User is on NTK login page
     When User enters username "Admin"
      And User enters password "8@OOxa8LJi"
      And User clicks login button
     Then User able to view "Dashboard"
      And User able to view account name "Jacqueline White"
