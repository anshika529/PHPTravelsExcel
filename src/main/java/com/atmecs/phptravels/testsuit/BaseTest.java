package com.atmecs.phptravels.testsuit;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.atmecs.phptravels.constants.Constants;
import com.atmecs.phptravels.utils.PropertyReader;

public class BaseTest {
	public static Properties properties;
	String baseUrl;
	public WebDriver driver;

	@BeforeMethod
	@Parameters("browser")

	public void browserSetUp(String browser) {
		 properties = PropertyReader.readProperties(Constants.TestData_file);

		 baseUrl =properties.getProperty("url"); 
		 
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.firefox_file);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		else {
			System.setProperty("webdriver.chrome.driver", Constants.Chrome_file);

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		driver.get(baseUrl);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
