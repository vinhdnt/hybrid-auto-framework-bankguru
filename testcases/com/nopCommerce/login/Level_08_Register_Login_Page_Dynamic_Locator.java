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
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {
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
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstNameTextbox("vinh");
		registerPage.enterToLastNameTextbox("doan");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		homePage = registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_03_Switch_Page_At_Footer() {
		//homepage -> search
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		
		//search -> my account
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByName(driver, "My account");
		
		//my account -> order
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByName(driver, "Orders");
				
		//order -> my account
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByName(driver, "My account");

		//my account -> search
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByName(driver, "Search");	
	}
	
	@Test
	public void Login_04_Switch_Page_At_Footer() {
		
		//search -> my account
		searchPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		//my account -> order
		myAccountPage.getFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
				
		
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
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;


}
