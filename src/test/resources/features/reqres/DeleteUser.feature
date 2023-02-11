Feature: Feature Delete User

  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid <id>
    When Send request delete user
    Then Status code should be 204 no Content
    Examples:
      | id |
      | 1  |
      | 2  |

 @Tugas
 Scenario Outline: Delete user with invalid id
   Given Delete user with invalid "<id>"
   When Send request delete user
   Then Status code should be 400 Bad Request
   Examples:
     | id      |
     | aselole |