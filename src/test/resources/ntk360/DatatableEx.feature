Feature: Job Titles feature

  Background: 
    Given User is logged in and in NTK Dashboard page

  @smoke
  Scenario: Adding new job to job tables
    When User navigates to Job Titles
     And User clicks on the Add icon
     And User provides job title data
      | JobTitle   | JobDescription     | Note |
      | SDET9dd071 | Business Ansdalyst | BA   |
     And User clicks save button
    Then System displays successfuly message "Successfully Saved"

  Scenario: Correct non-zero number of books found by author
    Given I have the following books in the store
      | title    | author      |
      | The Lion | C.S. Lewis  |
      | TCity    | Erik Larson |
     When I search for books by author Erik Larson
     Then I find 2 books

  Scenario: Correct non-zero number of books found by author
    Given I have the following books in the store
      | title    | author      |
      | TCity    | Erik Larson |
      | The Lion | C.S. Lewis  |
     When I search for books by author Erik Larson
     Then I find 2 books
