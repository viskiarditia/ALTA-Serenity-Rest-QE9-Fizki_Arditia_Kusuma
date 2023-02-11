Feature: Feature Get List User
  @Latihan
  Scenario Outline: Get List user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario Outline: Get List user with invalid parameter page more than exceed
    Given Get list user with exceed parameter page <page>
    When Send request get list users
    Then Should return status Code 404 Not Found
    Examples:
      | page  |
      | 12032 |

  @Tugas
  Scenario Outline: Get List user with invalid parameter page
    Given Get list user with invalid parameter page "<page>"
    When Send request get list users
    Then Should return status Code 404 Not Found
    Examples:
      | page   |
      | kusuma |
      | !@#$%^ |
