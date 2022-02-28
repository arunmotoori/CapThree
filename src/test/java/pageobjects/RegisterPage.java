package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyCheckboxField;
	
	@FindBy(css="input[value='Continue']")
	private WebElement continueButton;
	
	@FindBy(name="newsletter")
	private WebElement yesToNewsLetterRadioButton;
	
	@FindBy(css="div[class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	public void enterFirstName(String firstName) {
		
		firstNameField.sendKeys(firstName);
		
	}
	
	public void enterLastName(String lastName) {
		
		lastNameField.sendKeys(lastName);
		
	}
	
	public void enterEmailAddress(String emailAddress) {
		
		emailAddressField.sendKeys(emailAddress);
		
	}
	
	public void enterTelephoneNumber(String telephoneNumber) {
		
		telephoneField.sendKeys(telephoneNumber);
		
	}
	
	public void enterPassword(String password) {
		
		passwordField.sendKeys(password);
		
	}
	
	public void enterConfirmPassword(String password) {
		
		passwordConfirmField.sendKeys(password);
		
	}
	
	public void selectPrivacyPolicyCheckboxField() {
		
		privacyPolicyCheckboxField.click();
		
	}
	
	public void clickContinueButton() {
		
		continueButton.click();
		
	}
	
	public void selectYesNewsletterRadioButton() {
		
		yesToNewsLetterRadioButton.click();
		
	}
	
	
	public String getWarningMessage() {
		
		return warningMessage.getText();
		
	}

}
