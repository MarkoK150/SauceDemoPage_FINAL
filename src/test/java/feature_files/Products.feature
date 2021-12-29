Feature: Test Products page on Sauce Demo Page

  Scenario Outline: Add one Product to Cart by Name Product "<nameProduct>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    And Add Product to cart by name "<nameProduct>"
    When Click to button Cart on header
    Then Check Product in cart "<nameProduct>"
    Examples:
      | username      | password     | nameProduct                       |
      | standard_user | secret_sauce | Sauce Labs Backpack               |
      | standard_user | secret_sauce | Sauce Labs Bike Light             |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt           |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket          |
      | standard_user | secret_sauce | Sauce Labs Onesie                 |
      | standard_user | secret_sauce | Test.allTheThings() T-Shirt (Red) |


  Scenario Outline: Add two Product to Cart by Name Product "<nameProduct1>" and "<nameProduct2>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    And Add Product to cart by name "<nameProduct1>"
    And Add Product to cart by name "<nameProduct2>"
    When Click to button Cart on header
    Then Check Product in cart "<nameProduct1>"
    Then Check Product in cart "<nameProduct2>"
    Examples:
      | username      | password     | nameProduct1        | nameProduct2          |
      | standard_user | secret_sauce | Sauce Labs Backpack | Sauce Labs Bike Light |


  Scenario Outline: Add one Product to cart - random
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    And Add Product to cart - random number
    When Click to button Cart on header
    Then Check number Products in Cart "<numProductCart>"
    Examples:
      | username      | password     | numProductCart |
      | standard_user | secret_sauce | 1              |
      | standard_user | secret_sauce | 1              |

  Scenario Outline:  Add two Product to cart - random
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    And Add Product to cart - random number
    And Add Product2 to cart - random number
    When Click to button Cart on header
    Then Check number Products in Cart "<numProductCart>"
    Examples:
      | username      | password     | numProductCart |
      | standard_user | secret_sauce | 2              |


  Scenario Outline: Buy one Product By name "<nameProduct>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    And Add Product to cart by name "<nameProduct>"
    And Click to button Cart on header
    And Click Checkout button
    And I enter First Name "<firstName>"
    And i enter Last Name "<lastName>"
    And I enter ZIP code "<zipCode>"
    And I click Continue button
    When Check product in cart and click Finish button "<nameProduct>"
    Then I bought Product "<buyProdMsg>"
    Examples:
      | username      | password     | nameProduct         | firstName | lastName | zipCode | buyProdMsg               |
      | standard_user | secret_sauce | Sauce Labs Backpack | Marko     | Markovic | 71000   | THANK YOU FOR YOUR ORDER |


  Scenario Outline: I test form for shopping product - negative scenario "<firstName>" "<lastName>" "<zipCode>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    And Add Product to cart - random number
    And Click to button Cart on header
    And Click Checkout button
    And I enter First Name "<firstName>"
    And i enter Last Name "<lastName>"
    And I enter ZIP code "<zipCode>"
    When I click Continue button
    Then Check error message "<errorMsgLoginPage>"
    Examples:
      | username      | password     | firstName | lastName | zipCode | errorMsgLoginPage              |
      | standard_user | secret_sauce |           |          |         | Error: First Name is required  |
      | standard_user | secret_sauce |           | Markovic | 71000   | Error: First Name is required  |
      | standard_user | secret_sauce | Marko     |          | 71000   | Error: Last Name is required   |
      | standard_user | secret_sauce | Marko     | Markovic |         | Error: Postal Code is required |


