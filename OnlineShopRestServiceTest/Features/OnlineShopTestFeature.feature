Feature: Online Shop REST Service Test Feature

		@REST
		Scenario: User wants to add products into the database
			Given User is on the home page of Postman
			When User calls '/add' and enters valid product details
			Then  Postman must display the product details in json form and product must be stored in database
			
			@REST
		Scenario: User wants to view products in the database
			Given User is on the home page of Postman
			When User calls '/view' 
			Then  Postman must display all the product details stored in database in json form
			
		@REST
		Scenario: User wants to view a single product in the database using its id
			Given User is on the home page of Postman
			When User calls '/find' and enters valid product id
			Then  Postman must display the product details in json form