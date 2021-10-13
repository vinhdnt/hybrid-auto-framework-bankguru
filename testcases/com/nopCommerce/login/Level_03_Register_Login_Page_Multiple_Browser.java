package com.nopCommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Multiple_Browser extends BaseTest {
	WebDriver driver;
	BasePage basePage;
	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		System.out.println("driver at testcase =" +driver.toString());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		emailAddress = getRandomEmail();
		password = "123123123";
	}

	@Test
	public void Login_01_Register_To_System() {
		// Step 1: open url -> open homepage
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		// Step 2: Click to register Link -> open register page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		// Actions for testcase
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstNameTextbox("vinh");
		registerPage.enterToLastNameTextbox("doan");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		//Actions
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
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
	RegisterPageObject registerPage;


}
