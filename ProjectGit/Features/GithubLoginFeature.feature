Feature: Github Login Feature
	Using this feature user can login into github account
	
#	@Execute
	Scenario: User wants to Login into Github using valid set of username, password
	Given User is on the login page of github
	When 	User enters valid username, password
	Then 	Browser must display 'Login Successful' message
	

	Scenario: User wants to Login into Github using invalid set of username, password
	Given User is on the login page of github
	When 	User enters invalid username, password
	Then 	Browser must display 'Login Failed' message
	
	Given User is on homepage
	When user enters ueername
	Then it dispkays "Hello"