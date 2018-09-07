package com.cg.OnlineShopRestServiceTest.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.cg.OnlineShopRESTService.bean.Product;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
	
public class OnlineShopTestStepDefinitions {
	
	private TestRestTemplate restTemplate; 
	private ResponseEntity<String> responseEntity;
	private ResponseEntity<Product> responseEntityProduct;
	private ResponseEntity<List> responseListEntity;
	
	@Before
	public void setupTest() {
		restTemplate = new TestRestTemplate();
	}
	
	@When("^User gives call '/sayHello' service$")
	public void user_gives_call_sayHello_service() throws Throwable {
	   responseEntity = restTemplate.getForEntity("http://localhost:5555/sayHello", String.class);
	}

	@Then("^User should receive service statur 'OK' And response message 'Hello World from RESTfulWebService'$")
	public void user_should_receive_service_statur_OK_And_response_message_Hello_World_from_RESTfulWebService() throws Throwable {
	    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	    assertEquals("Hello World from RESTfulWebService", responseEntity.getBody());
	}
	
	@When("^User submits product details$")
	public void user_submits_product_details() throws Throwable {
		Product product = getProduct();
		
		System.err.println(getProduct());
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("productCode", product.getProductCode());
		map.add("name", product.getName());
		map.add("description", product.getDescription());
		map.add("price", Double.toString(product.getPrice()));
		map.add("manufactureDate", product.getManufactureDate());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(map, headers);
		
		responseEntityProduct = restTemplate.postForEntity("http://localhost:5555/addProduct", httpEntity, Product.class);
		
	}

	@Then("^product details successfully added$")
	public void product_details_successfully_added() throws Throwable {
		
		Product expectedProduct = getProduct();
		Product actualProduct = responseEntityProduct.getBody();
		
		assertEquals(expectedProduct, actualProduct);
	   
	}
	
	@When("^User submits product id$")
	public void user_submits_product_id() throws Throwable {
	     responseEntityProduct = restTemplate.getForEntity("http://localhost:5555/findProduct?id=S25", Product.class);
	}

	@Then("^product details must be displayed$")
	public void product_details_must_be_displayed() throws Throwable {
		Product product= responseEntityProduct.getBody();
		String expectedProduct = "S25";
		String actualProduct =product.getProductCode()																																			;
		
		assertEquals(expectedProduct, actualProduct);
	    
	}
	
	@When("^User calls '/viewAllProducts' service$")
	public void user_calls_viewAllProducts_service() throws Throwable {
		 responseListEntity = restTemplate.getForEntity("http://localhost:5555/viewAllProducts", List.class);
	}

	@Then("^All the products available in the database must be displayed$")
	public void all_the_products_available_in_the_database_must_be_displayed() throws Throwable {
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	private Product getProduct() {
		return new Product("S25", "Samsung", "Good", 65000.00, "21-04-2012");
	}

}
