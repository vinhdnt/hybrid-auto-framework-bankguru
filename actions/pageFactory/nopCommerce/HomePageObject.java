package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	 WebDriver driver;
	
	public HomePageObject() { //<= ko cần thằng này, viết ra chỉ để nó visible ra :D
		// khi new 1 class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		// Cùng tên với class
		// Không có kiểu trả về
		// 1 class có thể có nhiều hàm khởi tạo -> đa hình
	}
//	public static final String HOME_PAGE_SLIDER = "//div[@id='nivo-slider']";
//	public static final String REGISTER_LINK = "//a[@class='ico-register']";
//	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	
	//UI
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(className = "ico-register")
	WebElement registerList;
	
	@FindBy(className = "ico-login")
	WebElement loginLink;
	
	//Actions
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerList);
		clickToElement(driver, registerList);
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
