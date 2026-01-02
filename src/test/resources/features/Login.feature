Feature: Login functionality

  Scenario Outline: Valid user login to application
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then Validate the Page title in Login page
    When User click on logout page
    Then Validate the Page title Home page
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: Locked out user login to application
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then Validate the error message for locked out user
    Examples:
      | Username        | Password     |
      | locked_out_user | secret_sauce |

  Scenario Outline: Invalid user login to application
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then Validate the error message for invalid user
    Examples:
      | Username     | Password     |
      | standard_use | secret_sauce |

  Scenario: Empty Username/password login to application
    Given User is on the Login page
    When Click on login button
    Then Validate the error message for empty username and password

  Scenario Outline: Login to application with empty password
    Given User is on the Login page
    When User enters Username as "<Username>"
    And Click on login button
    Then Validate the error message for empty password
    Examples:
      | Username      |
      | standard_user |

  Scenario Outline: Login to application with empty username
    Given User is on the Login page
    When User enters Password as "<Password>"
    And Click on login button
    Then Validate the error message for empty password
    Examples:
      | Password     |
      | secret_sauce |
