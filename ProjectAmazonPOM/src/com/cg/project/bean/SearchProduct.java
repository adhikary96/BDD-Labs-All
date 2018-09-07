package com.cg.project.bean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchProduct {
	
	@FindBy(how=How.ID, id="twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(how=How.XPATH, xpath="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	private WebElement button;
	
	@FindBy(how=How.XPATH, xpath="//*[@id=\"bcKwText\"]/span")
	private WebElement actualValid;
	
	//@FindBy(how=How.XPATH, xpath="//*[@id=\\'noResultsTitle\\']")
	@FindBy(how=How.ID, id="noResultsTitle")
	private WebElement actualInvalid;

	public void setSearch(String search) {
		this.search.sendKeys(search);
	}
	
	public void clickSearch() {
		button.submit();
	}

	public String getActualValid() {
		return actualValid.getText();
	}
	
	public String getActualInvalid() {
		return actualInvalid.getText();
	}

}
