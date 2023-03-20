package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	WebDriver driver;
	private HomePage homepage;
	private SearchPage searchpage;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		
		driver=DriverFactory.getDriver();
	    
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
	 homepage= new HomePage(driver);
	 homepage.searchBoxField(validProductText);	
	
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	 
		homepage.searchButtonField();
			}

	@Then("User should get valid product in the search results")
	public void user_should_get_valid_product_in_the_search_results() {
		
		searchpage =new SearchPage(driver);
		
	   Assert.assertTrue(searchpage.userGetValidProduct()); 
	   Assert.fail();
	}

	@When("User enters invalid product {string} into the search field")
	public void user_enters_invalid_product_into_the_search_field(String invalidProductText) {
		homepage= new HomePage(driver);
		homepage.searchBoxField(invalidProductText);
		
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		searchpage =new SearchPage(driver);
		Assert.assertTrue(searchpage.noProductMatch().contains("There is no product that matches the search criteria."));
	   
	}

	@When("User dont enter any product name into the search box field")
	public void user_dont_enter_any_product_name_into_the_search_box_field() {
		homepage= new HomePage(driver); 
	
	}

}
