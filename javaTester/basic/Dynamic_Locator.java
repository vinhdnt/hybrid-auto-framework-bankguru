package basic;

public class Dynamic_Locator {
	public static void main(String[] args) {
	 String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[.='Orders']";
	 String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[.='My account']";
	 String SEARCH_PAGE_FOOTER ="//div[@class='footer']//a[.='Search']";
	 
	 String DYNAMIC_PAGE_FOOTER= "//div[@class='footer']//a[.='%s']";
	 String DYNAMIC_PAGE_ELEMENT= "//div[@class='%s']//div[@class='%s']//div[@class='%s']//a[.='%s']";

	 
	 
	 
	 clickToElement(DYNAMIC_PAGE_FOOTER, "Orders");
	 clickToElement(DYNAMIC_PAGE_FOOTER, "My account");
	 clickToElement(DYNAMIC_PAGE_FOOTER, "Search");
	 
	 clickToElement(DYNAMIC_PAGE_ELEMENT, "param 1", "param 2", "param 3", "param 4");
	 
	}
	
	public static void clickToElement(String locator) {
		System.out.println(locator);
	}
	
	public static void clickToElement(String locator, String pageName) {
		System.out.println(String.format(locator, pageName));
	}
	 
	//rest parameter
	public static void clickToElement(String locator, String... params) {
		System.out.println(String.format(locator, (Object[]) params));
	}


}
