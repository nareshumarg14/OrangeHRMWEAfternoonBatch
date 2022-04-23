package com.OrangeHRM.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//1
	public WebDriver driver; //Driver2
	
	//2
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3 --> Locator for Username field
	@FindBy(id="txtUsername")
	WebElement unameTxtField;
	
	//4 --> Locator for Password field
	@FindBy(name="txtPassword")
	WebElement pwdTxtField;
	
	//5 --> Locator for Login button
	@FindBy(name="Submit")
	WebElement loginBtn;
	
	//6 --> Entering Username
	public void setUsername(String username) {
		unameTxtField.clear();
		unameTxtField.sendKeys(username);
		String unameEntered = unameTxtField.getAttribute("value");
		System.out.println("Value entered in Username field is - " + unameEntered);
	}
	
	//7 --> Entering Password
	public void setPassword(String password) {
		pwdTxtField.clear();
		pwdTxtField.sendKeys(password);
		String passwordEntered = pwdTxtField.getAttribute("value");
		System.out.println("Value entered in Password field is - " + passwordEntered);
	}
	
	//8 --> Clicking on Login button
	public void clickLoginButton() {
		loginBtn.click();
		System.out.println("Clicked on Login button");
	}
	
	
	
	

}
