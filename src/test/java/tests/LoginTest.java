package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	//Arun Motoori
	
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
	public void loginWithValidCredentials() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickOnMyAccountMenu();
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("validpassword"));
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
			
		Assert.assertTrue(accountPage.checkDisplayStatusOfEditYourAccountInformationLink());
		
	}
	
	@Test(priority=2)
	public void loginWithValidUsernameAndInvalidPassword() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validemail"));
		loginPage.enterPassword(prop.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.getWarningMessage().contains(prop.getProperty("wronglogincredentialswarning")));
		
	}
	
	@Test(priority=3)
	public void loginWithInvalidUsernameAndValidPassword() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		homePage.selectLoginOption();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("amotooricap1"+generateTimeStamp()+"@gmail.com");
		loginPage.enterPassword(prop.getProperty("validpassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.getWarningMessage().contains(prop.getProperty("wronglogincredentialswarning")));
		
	}
	

}
