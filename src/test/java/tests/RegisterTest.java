package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import resources.Base;

public class RegisterTest extends Base {
	//Hariprasad
	//First change
	//Done code
	public WebDriver driver = null;
	
	@BeforeMethod
	public void setup() throws FileNotFoundException, IOException {
		
		loadPropertiesFile();
		driver = initializeBrowser(prop.getProperty("browser"),driver);
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void registerAccountWithMandatoryFields() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		homePage.selectRegisterOption();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress("amotooricap1"+generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephoneNumber(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.selectPrivacyPolicyCheckboxField();
		registerPage.clickContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.getHeadingText(),"Your Account Has Been Created!");
		
	}
	
	@Test(priority=2)
	public void registerAccountWithAllFields() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		homePage.selectRegisterOption();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress("amotooricap1"+generateTimeStamp()+"@gmail.com");
		registerPage.enterTelephoneNumber(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.selectYesNewsletterRadioButton();
		registerPage.selectPrivacyPolicyCheckboxField();
		registerPage.clickContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.getHeadingText(),"Your Account Has Been Created!");
		
	}
	
	@Test(priority=3)
	public void registerDuplicateAccount() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		homePage.selectRegisterOption();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstname"));
		registerPage.enterLastName(prop.getProperty("lastname"));
		registerPage.enterEmailAddress(prop.getProperty("existingemail"));
		registerPage.enterTelephoneNumber(prop.getProperty("telephone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.selectYesNewsletterRadioButton();
		registerPage.selectPrivacyPolicyCheckboxField();
		registerPage.clickContinueButton();
		
		Assert.assertTrue(registerPage.getWarningMessage().contains(prop.getProperty("existingemailwarning")));
		
	}
	
}
