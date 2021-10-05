package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_Base_Page_3 extends BasePage {
	WebDriver driver;
	BasePage basePage;
	String username, password, loginPageUrl;
	String projectLocation = System.getProperty("user.dir"); 
	@BeforeClass
	public void initBrowser() {
//		System.setProperty("webdriver.gecko.driver",projectLocation + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", projectLocation +"\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test
	public void Login_01_Register_To_System() {
		
		loginPageUrl = getPageUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		username = getElementText(driver, "//td[.='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[.='Password :']/following-sibling::td");
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		openPageUrl(driver, loginPageUrl);
		sendkeyToElement(driver, "//input[@name='uid']", username);
		sendkeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		String welcomMsg = getElementText(driver, "//marquee[@class='heading3']");
		Assert.assertEquals(welcomMsg, "Welcome To Manager's Page of Guru99 Bank");
		
	}


	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(99999) + "@qa.team";
	}


}
