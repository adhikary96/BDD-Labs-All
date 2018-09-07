package com.cg.project.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSearchFeatureStepDefinition {
	
	WebDriver driver;
	
	@Given("^User is on Amazon home page$")
	public void user_is_on_Amazon_home_page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	    
	}

	@When("^User enters valid product name$")
	public void user_enters_valid_product_name() throws Throwable {
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Redmi Note 5");
		
		search.submit();
	    
	}

	@Then("^Browser must update with available products$")
	public void browser_must_update_with_available_products() throws Throwable {
		
		String actual = driver.findElement(By.xpath("//*[@id=\'bcKwText\']/span")).getText();
		String expected = "\"Redmi Note 5\"";
		
		assertEquals(expected, actual);
		
		driver.close();
	    
	}
	
	@When("^User enters invalid product name$")
	public void user_enters_invalid_product_name() throws Throwable {
	   
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("lkhgdslsbdkjdsb");
		
		search.submit();
		
	}

	@Then("^Browser must display 'Your product not found'$")
	public void browser_must_display_Your_product_not_found() throws Throwable {
	   
		String actual = driver.findElement(By.xpath("//*[@id=\'noResultsTitle\']")).getText();
		String expected = "Your search \"lkhgdslsbdkjdsb\" did not match any products.";
		
		assertEquals(expected, actual);
		
		driver.close();
		
	}
	
}
