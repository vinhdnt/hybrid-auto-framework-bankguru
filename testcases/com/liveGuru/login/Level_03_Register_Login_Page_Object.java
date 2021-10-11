package com.liveGuru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageUIs.liveGuru.HomePageUI;


public class Level_03_Register_Login_Page_Object extends BaseTest {
	WebDriver driver;
	BasePage basePage;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir"); 
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = getRandomEmail();
		password = "123123123";
		driver.get("http://live.techpanda.org/");
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		homePage = new HomePageObject(driver);
		
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.loginToSystem("", "");
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMsg(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMsg(), "This is a required field.");
		
		
	}
	
	@Test
	public void Login_02_Invalid_Emai() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("123@456.789", "123123123");

		Assert.assertEquals(loginPage.getInvalidEmailErrorMsg(), "Please enter a valid email address. For example johndoe@domain.com.");
		
		
	}
	
	@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("vinh@qa.team", "123");
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMsg(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test(description = "Email no exist in system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem(getRandomEmail(), "123123123");

		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMsg(), "Invalid login or password.");
	}
	
	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("vinh@qa.team", "234234");

		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMsg(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.loginToSystem("vinh@qa.team", "123123123");

		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		return "testing" + rand.nextInt(99999) + "@qa.team";
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	


}
