Feature: Feature Create New User
  @Latihan
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name should be "Viski Arditia" and job is "QA Engineer batch 9"
    And Validate post create user json schema

  @Tugas
    Scenario: Post create new user without field name in json file
    Given Post create new user without field name in json
    When Send request post create new user without field name
    Then Status code should be 400 Bad Request

  @Tugas
    Scenario: Post Create new user without field job in json file
    Given Post create new user without field job in json
    When Send request post create new user without field job
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Post create new user with empty name
    Given Pos create new user with empty name
    When Send request post create new user with empty name
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Post create new user with empty job
    Given Post create new user with empty job
    When Send request post create new user with empty job
    Then Status code should be 400 Bad Request