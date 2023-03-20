package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	

	@FindBy(name="search")
	private WebElement searchBoxField;
	
	
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}

	public void selectLoginOption() {
		loginOption.click();
		
	}
	
	public void selectRegisterOption() {
		registerOption.click();
	}
	
	public void searchBoxField(String ProductText) {
		searchBoxField.sendKeys(ProductText);
	}
	
	public void searchButtonField() {
		searchButton.click();
	}
	
}
