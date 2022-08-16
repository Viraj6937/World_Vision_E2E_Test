package TestFile;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.Child_Detail_Page_Object;
import PageObject.Choose_Child_Page_Object;
import PageObject.Common_Page_Object;
import PageObject.Landing_Page_Object;
import PageObject.Payment_Page_Object;
import Resources.Base;

public class Donate_E2E_Test extends Base{
	
	Landing_Page_Object lpo;
	Choose_Child_Page_Object ccpo;
	Child_Detail_Page_Object cpo;
	Common_Page_Object co;
	Payment_Page_Object ppo;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	/**
	 * On worldvision.org website
        Select Gender (Boy)
        Select Age (7)
        Click on "Choose A Child" button
        Select or Click on one child
        Scroll down and click on "Sponsor Me" button
        Click on "BEGIN CHECKOUT" button
        Click on "CONTINUE AS GUEST" button
        Enter First Name (Test)
        Enter Last Name (Test)
        Enter Address 1 (Test)
        Enter City (New York)
        Enter State (New York)
        Enter Zip (10001)
        Enter Email (san@gee.com)
        Enter Phone (7909123123)
        Filling details and after click on "Continue" button
       Then click on "Use This Address" button
       Enter Credit Card Number (4111 1111 1111 1111)
       Enter Expiration Date (04/25)
       Click on "Submit Donation" Button
	 * 
	 * 
	 */
	
	@BeforeTest
	public void navigateUrl() throws IOException {
		
		driver = initializeDriver();
		log.info("driver is been initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("redirected to site url");
		
		driver.manage().window().maximize();
		log.info("browser window is been maximized");
		
		lpo = new Landing_Page_Object(driver);
		ccpo = new Choose_Child_Page_Object(driver);
		cpo = new Child_Detail_Page_Object(driver);
	    co = new Common_Page_Object(driver);
	    ppo = new Payment_Page_Object(driver);
		
	}
	
	@Test(dataProvider="details")
	public void verify_donation_is_done_successfully(String gender, String age, String name, String firstname, String lastname, String address1, String city, String state, String zipcode, String email, String phone, String cardNumber, String cardExpirationDate) {
		
		//select boy as gender
		lpo.get_gender_drop_down_field().sendKeys(gender);
		log.info("gender option is selected as"+gender);
		
		//select age as 7
		lpo.get_age_drop_down_field().sendKeys(age);
		log.info("age option is selected as:"+age);
		
		//click on choose a child submit button
		lpo.get_choose_a_child_submit().click();
		log.info("choose a child submit button is been clicked");
		
		
		//    Select or Click on one child
		List<WebElement> childrenList = ccpo.get_children_list();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfAllElements(childrenList));
		
		for(int i=0; i<childrenList.size();i++) {
			co.get_window_scroll_down(350);
			childrenList.get(0).click();
			break;
		}
		log.info("child at index 0 is been selected");
		
		
		//Scroll down and click on "Sponsor Me" button
         co.get_window_scroll_down(460);
		 cpo.get_sponsor_submit().click();
		 log.info("sponsor me button is been clicked");
		 
		 
	        //Click on "BEGIN CHECKOUT" button
		    ppo.get_proceed_to_check_out_submit().click();
		    log.info("begin checkout button is been clicked");
		 
	        //Click on "CONTINUE AS GUEST" button
		     ppo.get_payment_done_as_guest_submit().click();
		     log.info("continue as guest button is been clicked");
		    
		  //  Enter First Name (Test)
		      ppo.get_billing_first_name_field().sendKeys(firstname);
		      log.info("first name is entered as"+firstname);
		      
	     //   Enter Last Name (Test)
		      ppo.get_billing_last_name_field().sendKeys(lastname);
		      log.info("last name is entered as:"+lastname);
		      
	     //   Enter Address 1 (Test)
		      ppo.get_billing_address1_field().sendKeys(address1);
		      log.info("address 1 is entered as:"+address1);
		      
	    //    Enter City (New York)
		      ppo.get_billing_city_field().sendKeys(city);
		      log.info("city is entered as:"+city);
		      
	    //   Enter State (New York)
		      ppo.get_billing_state_field().sendKeys(state);
		      log.info("state is selected as:"+state);
		      
	    //    Enter Zip (10001)
		      ppo.get_billing_zip_field().sendKeys(zipcode);
		      log.info("zip is entered as:"+zipcode);
		      
	    //    Enter Email (san@gee.com)
		      ppo.get_billing_email_field().sendKeys(email);
		      log.info("email address is entered as:"+email);
		      
	   //     Enter Phone (7909123123)
		      ppo.get_billing_phone_field().sendKeys(phone);
		      log.info("phone number is entered as:"+phone);
		      
	  //      Filling details and after click on "Continue" button
		      co.get_window_scroll_down(300);
		      ppo.get_billing_continue_button().click();
		      log.info("continue button is clicked");
		 
	    //  Then click on "Use This Address" button
		    ppo.get_billing_complete_button().click(); 
		     log.info("use this address button is clicked"); 
		      
        //   get Payment done
		    ppo.set_payment_Details(cardNumber, cardExpirationDate);
            log.info("payment is done successfully");
		      
	}
	
	@AfterTest
	public void terminate() {
		driver.quit();
	}

	@DataProvider(name="details")
	public Object[][]getData(){
		Object[][] data = new Object[1][13];
		data[0][0] = "Boy";
		data[0][1] = "7";
		data[0][2] = "Alamin";
		data[0][3] = "Test";
		data[0][4] = "Test";
		data[0][5] = "Test";
		data[0][6] = "New York";
		data[0][7] = "New York";
		data[0][8] = "10001";
		data[0][9] = "san@gee.com";
		data[0][10] = "7909123123";
		data[0][11] = "4111 1111 1111 1111";
		data[0][12] = "04/25";
		return data;
	}
}
