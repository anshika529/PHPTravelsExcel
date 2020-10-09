package com.atmecs.phptravels.testscripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.atmecs.phptravels.constants.Constants;
import com.atmecs.phptravels.dataprovider.DataProviderClass;
import com.atmecs.phptravels.helpers.ElementHelpers;
import com.atmecs.phptravels.testsuit.BaseTest;
import com.atmecs.phptravels.utils.PropertyReader;

public class ChatTest extends BaseTest {

	Properties locators;

	@Test(dataProvider = "Data", dataProviderClass = DataProviderClass.class)

	public void Chat(String name, String email, String whatsapp) throws InterruptedException {
		
		locators = PropertyReader.readProperties(Constants.Locator_file);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.switchTo().frame(locators.getProperty("Frame_Id"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("ChatWidget"))));

		ElementHelpers.jsClick(driver, locators.getProperty("ChatWidget"));
		ElementHelpers.sendKeyById(driver, locators.getProperty("NameData"), name);
		ElementHelpers.ElementSendKeys(driver, locators.getProperty("WhatsApp"), whatsapp);
		ElementHelpers.sendKeyById(driver, locators.getProperty("EmailData"), email);

		ElementHelpers.selectFromDropDown(driver, locators.getProperty("Dropdown"), locators.getProperty("value"));
		
		ElementHelpers.jsClick(driver, locators.getProperty("StartChat"));
		// driver.switchTo().defaultContent();

	}

}
