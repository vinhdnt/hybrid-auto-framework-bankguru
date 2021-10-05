package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public void loginToSystem(String emailAddress, String password) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		clickToLoginButton();
	}

	public String getInvalidEmailErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MSG);
	}

	public String getInvalidPasswordErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MSG);
	}

	public String getIncorrectEmailOrPasswordErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MSG);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MSG);
	}

	public String getEmptyEmailErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MSG);
	}

	public String getEmptyPasswordErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MSG);
	}

	



}
