package com.cg.project2.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Def {

	WebDriver driver;
	WebElement button;

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("D:\\BDD\\Project-2\\checkboxtest.html");
	}

	@When("^user clicks on checkbox$")
	public void user_clicks_on_checkbox() throws Throwable {
		button = driver.findElement(By.id("turkeyCheck"));
		Thread.sleep(1000);
		button.click();
	}

	@Then("^it gets clicked$")
	public void it_gets_clicked() throws Throwable {
		
		String expected="turkey";
		String actual=button.getAttribute("value");
		
		assertEquals(expected, actual);
		
		
	}

}
