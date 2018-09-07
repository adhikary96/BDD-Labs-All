package com.cg.NaukriRegistrationFresher.stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NaukriRegistrationFresherStepDetails {

	WebDriver driver;

	@Given("^User is on the home page of 'naukri\\.com'$")
	public void user_is_on_the_home_page_of_naukri_com() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
	}

	@When("^User clicks on 'Register With Us' button$")
	public void user_clicks_on_Register_With_Us_button() throws Throwable {
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"p0widget\"]/div/div[1]/div/input"));
		btn.click();
	}

	@Then("^Browser should displays the next page$")
	public void browser_should_displays_the_next_page() throws Throwable {
		String actual = driver.findElement(By.xpath("//*[@id=\"flowBifurcation\"]/div[2]/form/div[1]/div/button")).getText();
		String expected = "I am a Fresher";

		assertEquals(expected, actual);
	}

	@When("^User clicks on 'I am a Fresher' button$")
	public void user_clicks_on_I_am_a_Fresher_button() throws Throwable {
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"flowBifurcation\"]/div[2]/form/div[1]/div/button"));
		btn.click();
	}

	@Then("^Browser must display registration page of account$")
	public void browser_must_display_registration_page_of_account() throws Throwable {
		String actual = driver.getTitle();
		String expected = "Resume Manager - Post Resume Online - Submit your CV - Naukri.com";

		assertEquals(expected, actual);
	}

	@When("^User enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {	
		WebElement fname = driver.findElement(By.id("fname"));
		fname.sendKeys("Arya Sharma");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("zbq85587@dfghy.com");

		WebElement password = driver.findElement(By.xpath("//*[@id='basicDetailForm']/div[3]/div[1]/div/input"));
		password.sendKeys("Hello@121Sharma");

		WebElement phone = driver.findElement(By.xpath("//*[@id='basicDetailForm']/div[4]/div[1]/div/input[2]"));
		phone.sendKeys("9896574521");

		WebElement location = driver.findElement(By.xpath("//*[@id=\"basicDetailForm\"]/resman-location/div/div/div[1]/div/div[1]/ul/li/div/label/input"));
		location.sendKeys("Hyderabad");
		Thread.sleep(2000);
		/*location = driver.findElement(By.xpath("//*[@id=\"basicDetailForm\"]/resman-location/div/div/div[1]/div/div[2]/ul/li[1]/ul/li/div/div/div/span"));
		location.click();*/

		location.submit();	   

	}

	@Then("^Browser must display the next page$")
	public void browser_must_display_the_next_page() throws Throwable {

		String actual = driver.findElement(By.xpath("//*[@id=\"banner\"]/ul/li[2]/div")).getText();
		String expected = "Education";

		assertEquals(expected, actual);
	}


	@When("^User enters all valid educational details$")
	public void user_enters_all_valid_educational_details() throws Throwable {

		WebElement hq = driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/edu-qualification/div/div[1]/div/div/div[1]/ul/li/div/label/input"));
		hq.sendKeys("Graduation");

		WebElement course = driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-course/div/div[1]/div/div/div[1]/ul/li/div/label/input"));
		course.sendKeys("B.Tech/B.E.");

		WebElement spec = driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-spec/div/div[1]/div/div/div[1]/ul/li/div/label/input"));
		spec.sendKeys("Electronics/Telecommunication");

		WebElement univ = driver.findElement(By.id("institute_0"));
		univ.sendKeys("Jawaharlal Nehru Technological University (JNTU)");

		WebElement courseType = driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/div/div/div/div/label[1]"));
		courseType.click();
		
		WebElement year = driver.findElement(By.xpath("//*[@id=\"educationDetailForm\"]/edu-section/section/div/edu-passing/div/div[1]/div/div/div[1]/ul/li/div/label/input"));
		year.sendKeys("2014");
		
		
		WebElement skill = driver.findElement(By.xpath("//*[@id=\"selSkillCont\"]/div/ul/li/suggestor/div/div/input"));
		skill.sendKeys("Software Development");
		
		skill.submit();

	}

	@Then("^Browser should display the next page$")
	public void browser_should_display_the_next_page() throws Throwable {

	}










}
