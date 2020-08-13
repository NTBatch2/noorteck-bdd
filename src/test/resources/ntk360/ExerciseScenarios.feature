Feature: Dashboard page Feature

  Background: 
    Given User is logged in and in NTK Dashboard page

  #1
  Scenario Outline: Edit existing job title and description
    When User navigates to Job Titles
     And User clicks on the Edit icon
     And User provides job title data "<JobTitle>", "<JobDescription>", "<Note>"
     And User clicks save button
    Then System displays successfuly message "<SuccessMessage>"

    Examples: 
      | JobTitle | JobDescription     | Note    | SuccessMessage       |
      | Dev33    | database developer | note101 | Successfully Updated |

  #2 
 
  Scenario Outline: Add new salary
    When User navigates to Salary Components
     And User clicks on the Add icon
     And User provides salary component data "<ComponentName>", "<Type>", "<AddTo>", "<ValueType>"
     And User clicks save button
    Then System displays successfuly message "<SuccessMessage>"

    Examples: 
      | ComponentName | Type      | AddTo         | ValueType  | SuccessMessage     |
      | Java101       | Deduction | Total Payable | Percentage | Successfully Saved |
      | Java202       | Deduction | Total Payable | Percentage | Successfully Saved |

  #3
  Scenario: Edit existing salary components
    When User navigates to Salary Components
     And User clicks on the Edit icon
     And User modifies component name to "Future SDET"
     And User clicks save button
    Then System displays successfuly message  "Successfully Updated"
  
  
    #4
