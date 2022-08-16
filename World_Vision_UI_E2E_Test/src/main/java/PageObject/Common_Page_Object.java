package PageObject;

import org.openqa.selenium.WebDriver;

public class Common_Page_Object {

	
	public WebDriver driver;
	
	public Common_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void get_window_scroll_down(int y) {
		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+")", "");
	}
}
