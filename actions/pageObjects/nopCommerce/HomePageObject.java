package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject() { //<= ko cần thằng này, viết ra chỉ để nó visible ra :D
		// khi new 1 class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		// Cùng tên với class
		// Không có kiểu trả về
		// 1 class có thể có nhiều hàm khởi tạo -> đa hình
	}
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getLoginPage(driver);

	}

}
