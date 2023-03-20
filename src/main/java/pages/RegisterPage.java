package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmfField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement clickOnContinuebutton;
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetter;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningMessage;
	

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyWarningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailaddressWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarningmessage;
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarningmessage;
	
	
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	

	public void enterlastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void PasswordConfirmField(String confirmpasswordText) {
		passwordConfirmfField.sendKeys(confirmpasswordText);
	}
	
	public void privacyPolicyField() {
		privacyPolicyField.click();
	}
	
	public void clicksOnContinueButtonn() {
		clickOnContinuebutton.click();
	}
	
	public void yesNewsLetterOption() {
		yesNewsLetter.click();
	}
	
	public String duplicateEmailWarning() {
		return duplicateEmailWarningMessage.getText();
	}
	
	
	public String privacyWarningMessage() {
		return privacyWarningMessage.getText();
	}
		
		
	public String firstNameWarnnig() {
		return firstNameWarning.getText();
	}
		
		
	public String lastNameWarning() {
		return lastNameWarning.getText();
	}
		
	public String emailAddressWarning() {
		return emailaddressWarning.getText();
	}	
		
	public String telephoneWarningMessage()	{
		return telephoneWarningmessage.getText();
	}
		
	public String passwordWarningMessage()	{
		return passwordWarningmessage.getText();
	}	
	
}
