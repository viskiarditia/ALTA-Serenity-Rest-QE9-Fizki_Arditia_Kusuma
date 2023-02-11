Feature: feature Register User test

  @Tugas
  Scenario Outline: Post Register user success with valid json
    Given Register user with valid json
    When Send request post register user success
    Then Status code should be 200 OK
    And Response body should contain id <id> and token "<token>"
    And validate json schema success register user
    Examples:
      | id | token             |
      | 4  | QpwL5tke4Pnpja7X4 |

  @Tugas
  Scenario Outline: Post Register user without email invalid json
    Given Register user without email invalid json
    When Send request post register without email
    Then Status code should be 400 Bad Request
    And Response body should show message "<error>"
    And Validate json schema without email register user
    Examples:
      | error                     |
      | Missing email or username |

  @Tugas
  Scenario Outline: Post Register user without password invalid json
    Given Register user without password invalid json
    When Send request post register without password
    Then Status code should be 400 Bad Request
    And Response body should show message "<error>"
    And Validate json schema without password register user
    Examples:
      | error            |
      | Missing password |

