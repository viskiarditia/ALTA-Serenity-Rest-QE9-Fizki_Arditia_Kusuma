Feature: Feature Get Single User
  @Tugas
  Scenario Outline: Get Single user with parameter id
    Given Get single user with valid parameter id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body page should be email "<email>" and firstName "<firstname>"
    And Get Single user JSON Schema Validator
    Examples:
      | id | email                  | firstname |
      | 1  | george.bluth@reqres.in | George    |
      | 4  | eve.holt@reqres.in     | Eve       |

  @Tugas
  Scenario Outline: Get single user not found
    Given Get single user not found with id <id>
    When Send request get single user not found
    Then Should return status Code 404 Not Found
    Examples:
      | id |
      | 55 |
      | 99 |

  @Tugas
  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get single user with invalid id
    Then Should return status Code 404 Not Found
    Examples:
      | id        |
      | asa       |
      | anj123!@# |