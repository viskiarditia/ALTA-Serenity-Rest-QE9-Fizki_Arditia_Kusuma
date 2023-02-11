Feature: Feature login user
  @Tugas
  Scenario Outline: Login successfull with valid json
    Given Post login success
    When Send request post login success
    Then Status code should be 200 OK
    And Response body page should contain token "<token>"
    And Post login success json schema validator
    Examples:
      | token             |
      | QpwL5tke4Pnpja7X4 |

  @Tugas
  Scenario Outline: Login with empty password
    Given Post login empty password
    When Send request post login empty password
    Then Status code should be 400 Bad Request
    And Response body should show message "<error>"
    And Post login empty password json schema validator
    Examples:
      |error            |
      |Missing password |

  @Tugas
  Scenario: Login with invalid password
    Given Post login invalid password
    When Send request post login invalid password
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario Outline: Login with invalid email
    Given Post login invalid email
    When Send request post login invalid email
    Then Status code should be 400 Bad Request
    And Response body should show message "<error>"
    And Post login invalid email json schema validator
    Examples:
      |error          |
      |user not found |

  @Tugas
  Scenario Outline: Login with empty email
    Given Post login empty email
    When Send request post login empty email
    Then Status code should be 400 Bad Request
    And Response body should show message "<error>"
    And Post login empty email json schema validator
    Examples:
      |error                      |
      |Missing email or username  |
