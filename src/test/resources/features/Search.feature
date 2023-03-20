Feature: Search functionality

Scenario: User searches for the valid product
Given User opens the Application 
When User enters valid product "HP" into Search box field
And User clicks on search button
Then User should get valid product in the search results

Scenario: User searches for invalid product
Given User opens the Application
When User enters invalid product "HONDA" into the search field
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the Application 
When User dont enter any product name into the search box field 
And User clicks on search button
Then User should get a message about no product matching