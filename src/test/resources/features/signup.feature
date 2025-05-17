Feature: Sign Up to Demoblaze


  @smoke @positive
  Scenario: Signup with valid data
    Given I am on the home page
    When I click on the signup link
    And I wait for the signup popup to appear
    And I fill in the username field with "randomusername"
    And I fill in the password field with "admin123"
    And I click on the signup button
    Then I should see a message "Sign up successful."

  @negative
  Scenario: Signup with existing username
    Given I am on the home page
    When I click on the signup link
    And I wait for the signup popup to appear
    And I fill in the username field with "alibaba_user"
    And I fill in the password field with "alibaba_user"
    And I click on the signup button
    Then I should see a message "This user already exist."

  @negative
  Scenario: Signup with empty username
    Given I am on the home page
    When I click on the signup link
    And I wait for the signup popup to appear
    And I fill in the username field with ""
    And I fill in the password field with "admin123"
    And I click on the signup button
    Then I should see a message "Please fill out Username and Password."

  @negative
  Scenario: Signup with empty password
    Given I am on the home page
    When I click on the signup link
    And I wait for the signup popup to appear
    And I fill in the username field with "newuser"
    And I fill in the password field with ""
    And I click on the signup button
    Then I should see a message "Please fill out Username and Password."

  @negative
  Scenario: Signup with empty username and password
    Given I am on the home page
    When I click on the signup link
    And I wait for the signup popup to appear
    And I fill in the username field with ""
    And I fill in the password field with ""
    And I click on the signup button
    Then I should see a message "Please fill out Username and Password."