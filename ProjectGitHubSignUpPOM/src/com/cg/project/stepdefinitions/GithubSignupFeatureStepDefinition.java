package com.cg.project.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.bean.SignUpPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubSignupFeatureStepDefinition {

	private WebDriver driver;
	private SignUpPage page;

	public void setUpSignUp() {
		System.getProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
	}

	@Given("^User is on the Signup page of github$")
	public void user_is_on_the_Signup_page_of_github() throws Throwable {

		driver = new ChromeDriver();
		driver.get("https://github.com/join?source=header-home");

		page = new SignUpPage();
		PageFactory.initElements(driver, page);

	}

	@When("^User enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {

		page.setUser("SamSmith45965");
		page.setEmail("SamSmith569@gmail.com");
		page.setPassword("SamSmith@123.3.3");

		page.clickCreate();		

	}

	@Then("^Browser must display 'Welcome To GitHub' message$")
	public void browser_must_display_Welcome_To_GitHub_message() throws Throwable {

		String expected = "@SamSmith45965";

		assertEquals(expected, page.getAcutalValid());


	}

	@When("^User enters invalid username$")
	public void user_enters_invalid_username() throws Throwable {

		page.setUser("qwerty");
		page.setEmail("vts22380@lakqs.com");
		page.setPassword("SamSmith@12@@1222");

		page.clickCreate();

	}

	@Then("^Browser must display 'Username is already taken' message$")
	public void browser_must_display_Problem_in_creating_account_message() throws Throwable {
		String expected = "Login is already taken";

		assertEquals(expected, page.getAcutalInvalidUser());

	}

	@When("^User enters invalid password$")
	public void user_enters_invalid_password() throws Throwable {

		page.setUser("qwerty5685samsmith9999");
		page.setEmail("vanlakqs.com");
		page.setPassword("SamSmith");

		page.clickCreate();

	}

	@Then("^Browser must display 'Password is too short' message$")
	public void browser_must_display_Password_is_too_short_message() throws Throwable {

		String expected = "Password needs at least one number and has been compromised in a third party data breach";

		assertEquals(expected, page.getAcutalInvalidPassword());

	}


	@When("^User enters invalid email id$")
	public void user_enters_invalid_email_id() throws Throwable {

		page.setUser("qwerty5685samsmith9999");
		page.setEmail("vanlakqs.com");
		page.setPassword("SamSmith");

		page.clickCreate();

	}

	@Then("^Browser must display 'Email is invalid or already taken' message$")
	public void browser_must_display_Email_is_invalid_or_already_taken_message() throws Throwable {

		String expected = "Email is invalid or already taken";

		assertEquals(expected, page.getAcutalInvalidEmail());
	}


}
