package com.cg.project.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubSignupFeatureStepDefinition {
	
	WebDriver driver;
	
	@Given("^User is on the Signup page of github$")
	public void user_is_on_the_Signup_page_of_github() throws Throwable {
	    
		System.getProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://github.com/join?source=header-home");
		
	}

	@When("^User enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {
		
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("SamSmith4585");
		
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("SamSmith@gmail.com");
		
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("SamSmith@12$12");
		
		password.submit();
		
	    
	}

	@Then("^Browser must display 'Welcome To GitHub' message$")
	public void browser_must_display_Welcome_To_GitHub_message() throws Throwable {
		
		String actual = driver.findElement(By.xpath("//*[@id='js-pjax-container']/div/div[1]/p/strong")).getText();
		String expected = "@SamSmith4585";
		
		assertEquals(expected, actual);
		
	    
	}

	@When("^User enters invalid username$")
	public void user_enters_invalid_username() throws Throwable {
		
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("qwerty");
		
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("vts22380@lakqs.com");
		
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("SamSmith@12@@1222");
		
		password.submit();
	   
	}

	@Then("^Browser must display 'Username is already taken' message$")
	public void browser_must_display_Problem_in_creating_account_message() throws Throwable {
		String actual = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/auto-check[1]/dl/dd[2]")).getText();
		String expected = "Login is already taken";
		
		assertEquals(expected, actual);
	    
	}

	@When("^User enters invalid password$")
	public void user_enters_invalid_password() throws Throwable {
	   
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("qwerty5685samsmith9999");
		
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("vanlakqs.com");
		
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("SamSmith");
		
		password.submit();
		
	}
	
	@Then("^Browser must display 'Email is invalid or already taken' message$")
	public void browser_must_display_Email_is_invalid_or_already_taken_message() throws Throwable {
		
		String actual = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/auto-check[2]/dl/dd[2]")).getText();
		String expected = "Email is invalid or already taken";
		
		assertEquals(expected, actual);
	}

	@When("^User enters invalid email id$")
	public void user_enters_invalid_email_id() throws Throwable {
		
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("qwerty5685samsmith9999");
		
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("vanlakqs.com");
		
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("SamSmith");
		
		password.submit();
	    
	}
	
	@Then("^Browser must display 'Password is too short' message$")
	public void browser_must_display_Password_is_too_short_message() throws Throwable {
		
		String actual = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/dl/dd[2]")).getText();
		String expected = "Password needs at least one number and has been compromised in a third party data breach";
		
		assertEquals(expected, actual);
		
	}

}
