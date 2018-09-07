package com.cg.project.stepdefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubLoginFeatureStepDefinition {
	
	WebDriver driver;
	
	@Given("^User is on the login page of github$")
	public void user_is_on_the_login_page_of_github() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://github.com/login");
	}

	@When("^User enters valid username, password$")
	public void user_enters_valid_username_password() throws Throwable {
		
		WebElement user = driver.findElement(By.id("login_field"));
		
		//List<WebElement> users = driver.
		
		user.sendKeys("adhikary96");
		
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Chemistry@123");
		
		WebElement btn = driver.findElement(By.name("commit"));
		btn.submit();
	}

	@Then("^Browser must display 'Login Successful' message$")
	public void browser_must_display_Login_Successful_message() throws Throwable {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(ExpectedConditions.
				textToBe(By.xpath("//*[@id=\"user-links\"]/li[3]/details/details-menu/ul/li[1]/a/strong"), "adhikary96"));
		
		String actual = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/details-menu/ul/li[1]/a/strong")).getText();
		String expected = "adhikary96";
		
		assertEquals(expected, actual);
		
		driver.close();
		
	}

	@When("^User enters invalid username, password$")
	public void user_enters_invalid_username_password() throws Throwable {
		
		WebElement user = driver.findElement(By.id("login_field"));
		user.sendKeys("hello1265");
		
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Hi1478");
		
		WebElement btn = driver.findElement(By.name("commit"));
		btn.submit();
		
	}

	@Then("^Browser must display 'Login Failed' message$")
	public void browser_must_display_Login_Failed_message() throws Throwable {
		//String actual = driver.getTitle();
		String actual = driver.findElement(By.xpath("//div[@class='container']")).getText();
		//String expected = "Incorrect username or password.";
		String expected="Incorrect username or password.";
		
		assertEquals(actual, expected);
		
		driver.close();
	}

}
