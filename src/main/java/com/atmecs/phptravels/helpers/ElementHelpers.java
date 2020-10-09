package com.atmecs.phptravels.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementHelpers {

	static WebDriver driver;

	public ElementHelpers(WebDriver driver) {
		ElementHelpers.driver = driver;
	}

	public static void elementClick(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	public static void ElementSendKeys(WebDriver driver, String xpath, String key) {
		driver.findElement(By.xpath(xpath)).sendKeys(key);
	}

	public static void selectElementById(WebDriver driver, String idPath) {
		driver.findElement(By.id(idPath)).click();
	}

	public static void sendKeyById(WebDriver driver, String idPath, String key) {
		driver.findElement(By.id(idPath)).sendKeys(key);
	}

	public static void selectFromDropDown(WebDriver driver, String xpath, String value) {
		Select choose = new Select(driver.findElement(By.xpath(xpath)));
		choose.selectByValue(value);
	}

	public static void jsClick(WebDriver driver, String xpath) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.xpath(xpath));

		js.executeScript("arguments[0].click();", button);

	}
}
