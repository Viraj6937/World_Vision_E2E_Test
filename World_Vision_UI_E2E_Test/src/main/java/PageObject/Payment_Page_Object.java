package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Payment_Page_Object {

	public WebDriver driver;
	
	private By proceed_to_check_out = By.cssSelector("div#content > div#primary > main#main > article > div > div > div.woocommerce > div.container > div > div.wc-proceed-to-checkout > div > a.btn-checkout");
	
	private By pay_as_guest_submit = By.cssSelector("div#root > div > div > div.wvus-login > div > div.guest-panel > div > div > a#checkout-guest-continue");
	
	private By billing_first_name_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_first_name");
	
	private By billing_last_name_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_last_name");
	
	private By billing_address1_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_address_1");
	
	private By billing_address2_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_address_2");
	
	private By billing_city_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_city");
	
	private By billing_state_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > select#billing_state");
	
	private By billing_zip_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_postcode");
	
	private By billing_email_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_email");
	
	private By billing_phone_field = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > div.billing-fields > div > div > input#billing_phone");
	
	private By billing_continue_button = By.cssSelector("div#content > div#primary > main > article > div > div.entry-content > div.woocommerce > form > div#root > div > div.checkout-step-0 > div > div > div > div > button");
	
	private By billing_address_submit = By.cssSelector("div#content > div#primary > main > article > div  > div > div.woocommerce > form > div#root > div > div.checkout-step > div.checkout-step-inner > div > div > div.address-validation-layout > div.address-validation-options > div > button.btn-checkout");
	
	private By card_number_field = By.xpath("//input[@id='data']");
	
	private By card_expiration_field = By.xpath("//input[@id='wvus_new_expiration']");
	
	private By donation_submit_button = By.xpath("//button[@id='wvus_place_order']");
	
	
	public Payment_Page_Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement get_proceed_to_check_out_submit() {
		return driver.findElement(proceed_to_check_out);
	}
	
	public WebElement get_payment_done_as_guest_submit() {
		return driver.findElement(pay_as_guest_submit);
	}
	
	public WebElement get_billing_first_name_field() {
		return driver.findElement(billing_first_name_field);
	}
	
	public WebElement get_billing_last_name_field() {
		return driver.findElement(billing_last_name_field);
	}
	
	public WebElement get_billing_address1_field() {
		return driver.findElement(billing_address1_field);
	}
	
	public WebElement get_billing_address2_field() {
		return driver.findElement(billing_address2_field);
	}
	
	public WebElement get_billing_city_field() {
		return driver.findElement(billing_city_field);
	}
	
	public WebElement get_billing_state_field() {
		return driver.findElement(billing_state_field);
	}
	
	public WebElement get_billing_zip_field() {
		return driver.findElement(billing_zip_field);
	}
	
	public WebElement get_billing_email_field() {
		return driver.findElement(billing_email_field);
	}
	
	public WebElement get_billing_phone_field() {
		return driver.findElement(billing_phone_field);
	}
	
	public WebElement get_billing_continue_button() {
		return driver.findElement(billing_continue_button);
	}
	
	public WebElement get_billing_complete_button() {
		return driver.findElement(billing_address_submit);
	}
	
	public WebElement get_card_number_field() {
		return driver.findElement(card_number_field);
	}
	
	public WebElement get_card_expiration_field() {
		return driver.findElement(card_expiration_field);
	}
	
	public void set_payment_Details(String cardNumber, String cardExpirationDate) {
		driver.switchTo().frame("tx_iframe_wvus_new_cc_iframe");
		this.get_card_number_field().sendKeys(cardNumber);
		
		driver.switchTo().defaultContent();
		this.get_card_expiration_field().sendKeys(cardExpirationDate);
		this.get_donation_payment_complete_submit().click();
	}
	
	
	public WebElement get_donation_payment_complete_submit() {
		return driver.findElement(donation_submit_button);
	}
}
