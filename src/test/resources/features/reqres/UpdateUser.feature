Feature: Feature Update User
  @Latihan
  Scenario Outline: Put update user with valid json and valid parameter id
    Given Update user with valid json parameter id <id>
    When Send request put updater user
    Then Status code should be 200 OK
    And Response body name should be "Viski Arditia" and job is "QA Engineer batch 9"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Put update user with valid json and empty name
    Given Put update user with empty name on id <id>
    When Send request put update user with empty name
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas
  Scenario Outline: Put update user with valid json and empty job
    Given Put update user with empty job on id <id>
    When Send request put update user with empty job
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas
  Scenario Outline: Put update user valid json without field name
    Given Put update user without field name on id <id>
    When Send request put update user without field name
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas
  Scenario Outline: Put update user valid jsonwithout field job
    Given Put update user without field job on id <id>
    When Send request put update user without field job
    Then Status code should be 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |