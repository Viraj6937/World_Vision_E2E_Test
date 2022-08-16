package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing_Page_Object {

	public WebDriver driver;
	
	private By select_gender_drop_down_field = By.cssSelector("div#page > div#page-inner > div#content  > div#primary > main > div > div > div.how-sponsorship-works__tile-box.how-sponsorship-works__tile-box--choose-child > div.select-wrapper > select#gender");
	
	private By select_age_drop_down_field = By.cssSelector("div#page > div#page-inner > div#content  > div#primary > main > div > div > div.how-sponsorship-works__tile-box.how-sponsorship-works__tile-box--choose-child > div.select-wrapper > select#age");
	
	private By choose_a_child_submit_button = By.cssSelector("div#page > div#page-inner > div#content  > div#primary > main > div > div > div.how-sponsorship-works__tile-box.how-sponsorship-works__tile-box--choose-child  > a");
	
	public Landing_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement get_gender_drop_down_field() {
		return driver.findElement(select_gender_drop_down_field);
	}
	
	public WebElement get_age_drop_down_field() {
		return driver.findElement(select_age_drop_down_field);
	}
	
	public WebElement get_choose_a_child_submit() {
		return driver.findElement(choose_a_child_submit_button);
	}
	
}
