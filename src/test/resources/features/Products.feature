Feature: Product Selection functionality

  Scenario Outline: Successful navigation to Products page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then User is on the Products page
    And  Product sort dropdown is present
    And Cart icon with item count is present
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Total Products on the Page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then User is on the Products page
    And Verify the total products on the Page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Sorting Based on Name (A to Z)
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then User is on the Products page
    When User click on Product Sort dropdown
    And Select "Name (A to Z)" from the dropdown
    Then Verify the products are sorted based on the "Name (A to Z)" on Products Page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Sorting Based on Name (Z to A)
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then User is on the Products page
    When User click on Product Sort dropdown
    And Select "Name (Z to A)" from the dropdown
    Then Verify the products are sorted based on the "Name (Z to A)" on Products Page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |


  Scenario Outline: Sorting Based on Price(low to high)
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then User is on the Products page
    When User click on Product Sort dropdown
    And Select "Price (low to high)" from the dropdown
    Then Verify the products are sorted based on the "Price (low to high)" on Products Page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |


  Scenario Outline: Sorting Based on Price (high to low)
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Then User is on the Products page
    When User click on Product Sort dropdown
    And Select "Price (high to low)" from the dropdown
    Then Verify the products are sorted based on the "Price (high to low)" on Products Page
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Add single product to the cart in specific product page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on the "<Product>"
    Then Selected specific "<Product>" page is displayed
    When User clicks on Add to cart in specific product page
    When  Click on Back to Products Page
    Then Verify the "<Product>" is selected on the Products Page

    Examples:
      | Username      | Password     | Product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  Scenario Outline: Remove single product in specific product page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on the "<Product>"
    Then Selected specific "<Product>" page is displayed
    When User clicks on Add to cart in specific product page
    Then Remove button is displayed
    When User click on Remove in specific product page
    Then Add to cart is displayed
    Examples:
      | Username      | Password     | Product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  Scenario Outline: Add single product to the cart in Products page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of specific "<Product>"
    Then Verify the "<Product>" is selected on the Products Page
    Examples:
      | Username      | Password     | Product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  Scenario Outline: Remove single product in Products page
    Given User is on the Login page
    When User enters Username as "<Username>" and Password as "<Password>"
    And Click on login button
    Given User is on the Products page
    When User clicks on Add to cart of specific "<Product>"
    Then Remove button is displayed for specific "<Product>"
    When User click on Remove of specific "<Product>"
    Then Add to cart is displayed for specific "<Product>"
    Examples:
      | Username      | Password     | Product             |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  Scenario Outline: Add multiple products to the cart in Products page
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
    Then Verify that all the below products are selected on the Products Page
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Remove multiple products in Products page
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
    Then Remove button is displayed for multiple products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    When User click on Remove for multiple products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Then Add to cart is displayed for mutliple products
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    Examples:
      | Username      | Password     |
      | standard_user | secret_sauce |





