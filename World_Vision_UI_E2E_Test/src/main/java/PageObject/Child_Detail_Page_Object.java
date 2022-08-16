package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Child_Detail_Page_Object {
	
	public WebDriver driver;
	
	private By sponsor_submit_button =  By.cssSelector("div#content > div#primary > main > article > div > div > div > div.vc_column_container > div > div.wpb_wrapper > div#sponsorship-wrapper > div > div > div.child-detail > section:nth-Child(2)  > section:nth-Child(2) > div > a.child-tile-cta");

	public Child_Detail_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement get_sponsor_submit() {
		return driver.findElement(sponsor_submit_button);
	}
	
}
