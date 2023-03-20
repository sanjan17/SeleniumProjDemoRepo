Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|sangeetha										|
|lastName	  |Dunna					      				|
|telephone	|1234567890										|
|password   |12345678											|
And User selects Privacy Policy
And User clicks on continue button
Then User account should get created successfully


Scenario: User creates account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|sangeetha										|
|lastName	  |Dunna					      				|
|telephone	|1234567890										|
|password   |12345678											|
And User select yes for newsleeter
And User selects Privacy Policy
And User clicks on continue button
Then User account should get created successfully


Scenario: User creates Duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName	|sangeetha										|
|lastName	  |Dunna					      				|
|email      |sangitha88@gmail.com 	      |
|telephone	|1234567890										|
|password   |12345678											|
And User select yes for newsleeter
And User selects Privacy Policy
And User clicks on continue button
Then User should proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on continue button
Then User should get proper warning messages for every mandetory fields

