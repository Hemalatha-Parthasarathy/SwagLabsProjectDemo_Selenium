Feature: Cart Page functionality

  Scenario Outline: Successful navigation to cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Cart icon on Products Page
    Then User is on the cart page
    And Continue shopping and Checkout is displayed
    And Quantity and Description is displayed
    And Cart icon with quantity is displayed

    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Validate Empty cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Cart icon on Products Page
    Then User is on the cart page
    And Validate cart products and cart Icon item count
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Validate added single product on Cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of specific "<Product>"
    And User clicks on Cart icon on Products Page
    Then User is on the cart page
    And Verify that the selected "<Product>" is on the Cart Page

    Examples:
      | Username      | Password     | Product                           |
      | standard_user | secret_sauce | Test.allTheThings() T-Shirt (Red) |

  Scenario Outline: Validate added multiple products on the Cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of multiple products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And User clicks on Cart icon on Products Page
    Then User is on the cart page
    And Verify that the Cart page contains the selected products
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Validate Remove for single product on Cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of specific "<Product>"
    And User clicks on Cart icon on Products Page
    Then User is on the cart page
    When User clicks on Remove button of specific "<Product>"
    Then Removed "<Product>" should not be displayed on Cart page
    Examples:
      | Username      | Password     | Product                  |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket |

  Scenario Outline: Validate remove added multiple products on the Cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of multiple products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And User clicks on Cart icon on Products Page
    Then User is on the cart page
    When User clicks on Remove for multiple products on cart page
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Then Removed products should not be displayed on Cart page
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Validate removed single product from added multiple products on the Cart page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of multiple products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And User clicks on Cart icon on Products Page
    Then User is on the cart page
    And Verify that the Cart page contains the selected products
    When User clicks on Remove button of specific "<Product>"
    Then Removed "<Product>" should not be displayed on Cart page
    Examples:
      | Username      | Password     | Product               |
      | standard_user | secret_sauce | Sauce Labs Bike Light |
