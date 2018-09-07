Feature: Naukri.com Registration feature
	This feature helps the user to create an account on Naukri.com

@Test
Scenario: User wants Sign up 'naukri.com' with valid set of details
	Given 	User is on the home page of 'naukri.com'
	When 	User clicks on 'Register With Us' button
	Then 	Browser should displays the next page
	
	When 	User clicks on 'I am a Fresher' button
	Then 	Browser must display registration page of account
	
	When User enters all valid details
	Then  Browser must display the next page
	
	When User enters all valid educational details
	Then  Browser should display the next page
