package com.cg.project2.stepdefinitions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		/*checkBoxTest();
		radioButtonTest();*/
		selectTest();
		
	}
	
	private static void checkBoxTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\BDD\\Project-2\\checkboxtest.html");
		
		WebElement checkbox = driver.findElement(By.id("mayoCheck"));
		Thread.sleep(1000);
		checkbox.click();
		
		if(checkbox.isSelected())
			System.out.println("Value of Checkbox is : "+checkbox.getAttribute("value"));
		driver.close();
	}
	
	private static void radioButtonTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\BDD\\Project-2\\radiobuttontest.html");
		
		By element = By.name("color");
		
		List<WebElement> radioButtons = driver.findElements(element);
		WebElement radioBtn = radioButtons.get(1);
		
		radioBtn.click();
		
		for (WebElement radioButton : radioButtons) {
			if(radioButton.isSelected())
				System.out.println("Selected radio button: "+radioButton.getAttribute("value"));
		}
		driver.close();
	}
	
	private static void selectTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\BDD\\Project-2\\selectTest.html");
		
		WebElement selectElem = driver.findElement(By.id("select1"));
		
		Select select = new Select(selectElem);
		//select.selectByVisibleText("Maybe");
		select.selectByIndex(2);
		
		//driver.close();
	}
	
}