Feature: Dashboard page Feature
 
  Scenario Outline: Verifying the user acount name Fahim
    Given User is logged in on the dashboard page
     When User navigates to Job Titles
      And User clicks on the Add icon
      And User provides job title data "<JobTitle>", "<JobDescription>", "<Note>"
      And User clicks save button
     Then System displays successfuly message "<SuccessMessage>"

    Examples: 
      | JobTitle     | JobDescription     | Note      | SuccessMessage     |
      | dddDev Denis1232 | database developer | Mid Level | Successfully Saved |
    #  | SDET Denis   | Automation Engineer | Experienced | Successfully Saved |
