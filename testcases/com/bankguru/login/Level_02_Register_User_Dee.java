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

public class Level_02_Register_User_Dee extends BasePage {
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
		driver.get("https://www.deerberg.de/de/user/registration"); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test
	public void Login_01_Register_To_System() {
		sendkeyToElement(driver, "//input[@id='cust_firstName']", "test first name");
		sendkeyToElement(driver, "//input[@id='cust_lastName']", "test last name");
		sendkeyToElement(driver, "//input[@id='cust_email']", getRandomEmail());
		sendkeyToElement(driver, "//input[@id='password']", "123123123");
		//checkToCheckboxByJs(driver, "//input[@id='Agree']");
		sleepInSecond(3);
		uncheckToCheckboxByJs(driver, "//input[@id='Agree']");
		//clickToElement(driver, "//input[@id='registration_submit_btn']");
		
	}
	

	@AfterClass
	public void cleanBrowser() {
		//driver.quit();
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(99999) + "@qa.team";
	}


}
