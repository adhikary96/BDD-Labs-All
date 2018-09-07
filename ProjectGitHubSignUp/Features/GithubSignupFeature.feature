Feature: Github Signup Feature
	Using this feature user can create a new account on github
	
	#@Execute
	Scenario: User wants to Signup to Github using valid set of detaild
	Given User is on the Signup page of github
	When 	User enters all valid details 
	Then 	Browser must display 'Welcome To GitHub' message
	
	#@Execute
	Scenario: User wants to Signup to Github using valid set of detaild
	Given User is on the Signup page of github
	When 	User enters invalid username 
	Then 	Browser must display 'Username is already taken' message
	
	#@Execute
	Scenario: User wants to Signup to Github using valid set of detaild
	Given User is on the Signup page of github
	When 	User enters invalid password 
	Then 	Browser must display 'Email is invalid or already taken' message
	
	@Execute
	Scenario: User wants to Signup to Github using valid set of detaild
	Given User is on the Signup page of github
	When 	User enters invalid email id 
	Then 	Browser must display 'Password is too short' message