#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Login functionality
  I want to use this template for my feature file

 

  @regression @smoke
  Scenario Outline: Positive login attemp
    Given I land on "https://cloud.tarsil.pk/" page
    When I provid username <name> and password <password>
    And Try to login
    Then Verify "Dashboard" pagetitle

    Examples: 
      | name       |     password |
      | 3216292988 |     admin123 |  
 
 @smoke
  Scenario Outline: Incorrect password login attemp
    Given I land on "https://cloud.tarsil.pk/" page
    When I provid username <name> and password <password>
    And Try to login
    Then Verify Error "Username or Password is not correct."

    Examples: 
      | name       |     password |
      | 3216292988 |     admin1234 |  
     
  @e2e
  Scenario Outline: Incorrect User login attemp
    Given I land on "https://cloud.tarsil.pk/" page
    When I provid username <name> and password <password>
    And Try to login
    Then Verify Error "Username or Password is not correct."

    Examples: 
      | name         |     password |
      | a3216292988a |     admin1234 |  
      