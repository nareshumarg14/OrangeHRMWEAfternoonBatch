package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.testBase.BaseClass;

public class TC002_CheckApplicationTitle extends BaseClass {
	
	//3
	@Test
	public void verifyApplicationTitle() throws IOException {
		String appTitle = driver.getTitle();
		Assert.assertEquals(appTitle,"OrangeHRM", "Title is not OrangeHRM");
		//System.out.println("Title of the application is OrangeHRM");
		logger.info("Title of the application is OrangeHRM");
		capturescreen(driver, "TC002_CheckApplicationTitle");
	}

}
