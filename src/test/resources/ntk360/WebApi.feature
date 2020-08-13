Feature: webservice api call

  Scenario Outline: sending get request
    Given User wants to make webservice "<apiName>" "<endpoint>" request
     When User sets Query parameters
      | auth-id                              | auth-token           | city   | state | zipcode |
      | 61f926d0-4996-13a8-c0ff-be05d212a694 | Vhz4zNp7uJ7BMq4BTTmm | Reston | VA    |   20191 | 
      And User sends GET request
     Then User recieves status code "<statusCode>"
      And User validates response body

    Examples: 
      | apiName       | endpoint                                        | statusCode |
      | addressLookup | https://us-zipcode.api.smartystreets.com/lookup |        200 |



  Scenario Outline: sending post request
    Given User wants to make webservice "<apiName>" "<endpoint>" request
     When User sets Query parameters
      | auth-id                              | auth-token           |  
      | 61f926d0-4996-13a8-c0ff-be05d212a694 | Vhz4zNp7uJ7BMq4BTTmm | 
      And User sends POST request "<requestBody>"
     Then User recieves status code "<statusCode>"
      And User validates response body

    Examples: 
      | apiName       | endpoint                                        | statusCode | requestBody                           |
      | addressLookup | https://us-zipcode.api.smartystreets.com/lookup |        200 | '[{ "city":"reston", "state":"VA" }]' |

      
      
      
      