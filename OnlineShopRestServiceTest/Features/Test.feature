Feature: Online Shop Test Feature

@Rest
Scenario: User wants to test Service of Online Shop
	
	When User gives call '/sayHello' service
	Then 	User should receive service statur 'OK' And response message 'Hello World from RESTfulWebService'
	
	When User submits product details
	Then  product details successfully added
	
	When User submits product id
	Then 	product details must be displayed
	
	When User calls '/viewAllProducts' service
	Then All the products available in the database must be displayed