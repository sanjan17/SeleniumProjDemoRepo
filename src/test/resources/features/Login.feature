Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigated to login page
When User enters valid email address <username> into email field
And User entered valid password <password> into password field
And User clicks login button
Then User should get successfully logged in
Examples:
|username        			|password     	 |
|sangitha88@gmail.com	|12345678				 |
|sangitha77@gmail.com	|12345678        |
|sangitha99@gmail.com |12345678				 |


Scenario: Login with Invalid credentials
Given User navigated to login page
When User enters invalid email address into email field
And User entered invalid password "12345" into password field
And User clicks login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigated to login page
When User enters valid email address "sangitha88@gmail.com" into email field
And User entered invalid password "12345" into password field
And User clicks login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigated to login page
When User enters invalid email address into email field
And User entered valid password "12345678" into password field
And User clicks login button
Then User should get a proper warning message about credentials mismatch
	
Scenario: Login without providing any credentials
Given User navigated to login page
When User dont enter email into email address field
And user dont enter password into password field
And User clicks login button
Then User should get a proper warning message about credentials mismatch