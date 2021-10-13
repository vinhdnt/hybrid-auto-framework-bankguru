package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//some example methods for ex TC
public class BasePageFactory {
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}
	
	public void sendkeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}
	
	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs= driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
			
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String pageTitle) {
		Set<String> allWindowIDs= driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.contains(pageTitle)) {
				break;
			}
			
		}
		
	}
	
	public void closeAllWindowsExceptParent(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if(!id.contains(parentID)) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSecond(1);
			}
			if(driver.getWindowHandles().size()==1) {
				driver.switchTo().window(parentID);
				break;
			}
		}
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void clickToElement(WebDriver dirver, WebElement element) {
		element.click();
	}
	public void sendkeyToElement(WebDriver dirver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public String getElementText(WebDriver dirver, WebElement element) {
		return element.getText();
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementsVisible(WebDriver driver, List<WebElement> elements) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	private Alert alert;
	private Select select;
	private Actions action;
	private long timeout = 30;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
