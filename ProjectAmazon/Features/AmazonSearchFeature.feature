Feature: Amazon Search Feature
	This feature enables the user to search for a product on Amazon
	
	@Execute
	Scenario: User wants to search for product by entering valid product name on Amazon website
	Given 	User is on Amazon home page
	When 		User enters valid product name
	Then 		Browser must update with available products
	
	@Execute
	Scenario: User wants to search for product by entering invalid product name on Amazon website
	Given 	User is on Amazon home page
	When 		User enters invalid product name
	Then 		Browser must display 'Your product not found'