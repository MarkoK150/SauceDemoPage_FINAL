Feature: Test Header on Sauce Demo Page

  Scenario Outline: Test all Menu Item "<item>"
    Given I am on Sauce Demo Login page
    And I enter username "<username>"
    And I enter password "<password>"
    And I click Login button
    When I click button Menu and Item "<item>"
    Then Compare actual and expected URL "<url>"
    Examples:
      | username      | password     | item   | url                        |
      | standard_user | secret_sauce | About  | https://saucelabs.com/     |
      | standard_user | secret_sauce | Logout | https://www.saucedemo.com/ |