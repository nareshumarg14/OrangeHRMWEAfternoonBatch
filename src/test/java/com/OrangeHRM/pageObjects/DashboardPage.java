package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	//1
	public WebDriver driver; //Driver2
		
	//2
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Locator for Dashboard Link
	@FindBy(id="menu_dashboard_index")
	WebElement dashboardLnk;
	
	//4
	public boolean dashboardLinkDisplayed() {
		boolean status = dashboardLnk.isDisplayed();
		return status;
	}
}
