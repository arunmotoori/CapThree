package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	
	}
	
	@FindBy(css="a[title='My Account']")
	private WebElement myAccountMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public void clickOnMyAccountMenu() {
		
		myAccountMenu.click();
		
	}
	
	public void selectLoginOption() {
		
		loginOption.click();
		
	}
	
	public void selectRegisterOption() {
		
		registerOption.click();
		
	}

}
