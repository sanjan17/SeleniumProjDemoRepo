package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	
	
	@Given("User navigated to login page")
	public void User_navigated_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
		
		
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	 
		loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(emailText);
	
	}

	@And("^User entered valid password (.+) into password field$")
	public void user_entered_valid_password_into_password_field(String passwordText) {
	  
		
		loginpage.enterPasswordField(passwordText);
	
	}

	@And("User clicks login button")
	public void user_clicks_login_button() {
		
		loginpage.clickOnLoginButton();
	   
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.displatStatusofEditYourAccountInformation());
	  
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
		
		}

	@And("User entered invalid password {string} into password field")
	public void user_entered_invalid_password_into_password_field(String invalidPassword) {
		
		loginpage.enterPasswordField(invalidPassword);
	   
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
		
		Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	   
	}

	@When("User dont enter email into email address field")
	public void user_dont_enter_email_into_email_address_field() {
		
		loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress("");
	  
	}

	@And("user dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		loginpage.enterPasswordField("");
		   
	}

  
}
