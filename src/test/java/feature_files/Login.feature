Feature: Test Sauce Demo Login page

  Scenario Outline: Test Login with valid credentials "<username>" "<password>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    When I click Login button
    Then I should be on Inventory page "<url>"
    Examples:
      | username                | password     | url                                      |
      | standard_user           | secret_sauce | https://www.saucedemo.com/inventory.html |
      | problem_user            | secret_sauce | https://www.saucedemo.com/inventory.html |
      | performance_glitch_user | secret_sauce | https://www.saucedemo.com/inventory.html |


  Scenario Outline: Test Login with invalid credentials "<username>" "<password>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    When I click Login button
    Then Check error message "<errorMsgLoginPage>"
    Examples:
      | username        | password        | errorMsgLoginPage                                                         |
      | locked_out_user | secret_sauce    | Epic sadface: Sorry, this user has been locked out.                       |
      |                 |                 | Epic sadface: Username is required                                        |
      | locked_out_user |                 | Epic sadface: Password is required                                        |
      |                 | secret_sauce    | Epic sadface: Username is required                                        |
      | standard_user12 | secret_sauce    | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | secret_sauce 12 | Epic sadface: Username and password do not match any user in this service |
      | standard_user12 | secret_sauce12  | Epic sadface: Username and password do not match any user in this service |
