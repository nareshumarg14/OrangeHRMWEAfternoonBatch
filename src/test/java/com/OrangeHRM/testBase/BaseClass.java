package com.OrangeHRM.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//1
	public WebDriver driver; //Driver1
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser is launched successfully");
		} else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser is launched successfully");
		}	else if(br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
			logger.info("Firefox browser is launched successfully");
		} else {
			logger.info("Please pass the browser name as chrome / edge / firefox");
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url") );
		//System.out.println("Orange HRM application is launched successfully");
		logger.info("Orange HRM application is launched successfully");
	}
	
	//4
	@AfterClass
	public void teardown() {
		driver.quit();
		//System.out.println("Browser closed successfully");
		logger.info("Browser closed successfully");
	}
	
	public void capturescreen(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\" + testName + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot captured successfully");
	}
}
