package stepdefinitions;



import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;



public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver=DriverFactory.getDriver();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectRegisterOption();
	   
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String,String> datamap=dataTable.asMap(String.class,String.class);
		
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(datamap.get("firstName"));
		registerpage.enterlastName(datamap.get("lastName"));
	    registerpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
	    registerpage.enterTelephoneField(datamap.get("telephone"));
	    registerpage.enterPasswordField(datamap.get("password"));
	    registerpage.PasswordConfirmField(datamap.get("password"));
	 
	}
	
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String,String> datamap=dataTable.asMap(String.class,String.class);
		
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(datamap.get("firstName"));
		registerpage.enterlastName(datamap.get("lastName"));
	    registerpage.enterEmailAddress(datamap.get("email"));
	    registerpage.enterTelephoneField(datamap.get("telephone"));
	    registerpage.enterPasswordField(datamap.get("password"));
	    registerpage.PasswordConfirmField(datamap.get("password"));
	    
		
	
	}
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerpage.privacyPolicyField();
	   
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		registerpage.clicksOnContinueButtonn();
	  	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
	 AccountSuccessPage accountsuccesspage= new AccountSuccessPage(driver);
	 Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeadingOfAccountSuccess());
	}

	@When("User select yes for newsleeter")
	public void user_select_yes_for_newsleeter() {
		registerpage.yesNewsLetterOption();
	 
	}

	@Then("User should proper warning about duplicate email")
	public void user_should_proper_warning_about_duplicate_email() {
		Assert.assertTrue(registerpage.duplicateEmailWarning().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		registerpage = new RegisterPage(driver);
	   
	}

	@Then("User should get proper warning messages for every mandetory fields")
	public void user_should_get_proper_warning_messages_for_every_mandetory_fields() {
		
		
		Assert.assertTrue(registerpage.privacyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerpage.firstNameWarnnig().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerpage.lastNameWarning().contains("Last Name must be between 1 and 32 characters!"));
	    Assert.assertTrue(registerpage.emailAddressWarning().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerpage.telephoneWarningMessage().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerpage.passwordWarningMessage().contains("Password must be between 4 and 20 characters!"));
	}

	 

}
