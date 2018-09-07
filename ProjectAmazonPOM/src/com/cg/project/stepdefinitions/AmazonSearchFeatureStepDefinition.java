package com.cg.project.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.bean.SearchProduct;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSearchFeatureStepDefinition {
	
	private WebDriver driver;
	private SearchProduct search;
	
	@Before(order=1)
	public void setUpSearchAmazon() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
	}
	
	
	@Given("^User is on Amazon home page$")
	public void user_is_on_Amazon_home_page() throws Throwable {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		search = new SearchProduct();
		PageFactory.initElements(driver, search);
	    
	}

	@When("^User enters valid product name$")
	public void user_enters_valid_product_name() throws Throwable {
		
		search.setSearch("Redmi Note 5");		
		search.clickSearch();
	    
	}

	@Then("^Browser must update with available products$")
	public void browser_must_update_with_available_products() throws Throwable {
		
		String expected = "\"Redmi Note 5\"";
		
		assertEquals(expected, search.getActualValid());
		
		//driver.close();
	    
	}
	
	@When("^User enters invalid product name$")
	public void user_enters_invalid_product_name() throws Throwable {
	   
		search.setSearch("lkhgdslsbdkjdsb");
		search.clickSearch();
		
	}

	@Then("^Browser must display 'Your product not found'$")
	public void browser_must_display_Your_product_not_found() throws Throwable {
	   
		String expected = "Your search \"lkhgdslsbdkjdsb\" did not match any products.";
		
		assertEquals(expected, search.getActualInvalid());
		
		//driver.close();
		
	}
	
}
