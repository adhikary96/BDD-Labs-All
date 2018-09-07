package com.cg.project.bean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {
	
	@FindBy(how=How.ID, id="user_login")
	private WebElement user;
	
	@FindBy(how=How.ID, id="user_email")
	private WebElement email;
	
	@FindBy(how=How.ID, id="user_password")
	private WebElement password;
	
	@FindBy(how=How.ID, id="signup_button")
	private WebElement button;
	
	@FindBy(how=How.XPATH, xpath="//*[@id='js-pjax-container']/div/div[1]/p/strong")
	private WebElement acutalValid;
	
	@FindBy(how=How.XPATH, xpath="//*[@id=\"signup-form\"]/auto-check[1]/dl/dd[2]")
	private WebElement acutalInvalidUser;
	
	@FindBy(how=How.XPATH, xpath="//*[@id=\"signup-form\"]/auto-check[2]/dl/dd[2]")
	private WebElement acutalInvalidEmail;
	
	@FindBy(how=How.XPATH, xpath="//*[@id=\"signup-form\"]/dl/dd[2]")
	private WebElement acutalInvalidPassword;
	
	public String getAcutalInvalidEmail() {
		return acutalInvalidEmail.getText();
	}

	public String getAcutalInvalidPassword() {
		return acutalInvalidPassword.getText();
	}

	public String getAcutalInvalidUser() {
		return acutalInvalidUser.getText();
	}

	public void setUser(String user) {
		this.user.sendKeys(user);
	}

	public String getAcutalValid() {
		return acutalValid.getText();
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickCreate() {
		button.click();
	}

}
