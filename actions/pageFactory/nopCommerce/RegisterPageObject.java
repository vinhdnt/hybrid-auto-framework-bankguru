package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	 WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement successMsg;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMsg);
		return isElementDisplayed(driver, successMsg);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
