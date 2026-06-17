package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {

	@Test(description="Validating Login Functionality", retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginwithValidCredentials() throws IOException {
		//String username = "admin";
		//String password = "admin";
	
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		
		boolean homepage=loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage);
		
	}
	
	@Test(description="Validating Login With Invalid Username And Valid Password", retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginwithInvalidUsernameAndCorrectPassword() throws IOException {
		//String username = "admin123";
		//String password = "admin";
	
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
		
	}
	@Test(description = "Validating Login With Valid Username And Invalid Password", retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginwithValidUsernameAndIncorrectPassword() throws IOException {
		//String username = "admin";
		//String password = "wrong admin";
	
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
    @Test(description = "Validating Login With Invalid Credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToLoginwithInvalidCredentials() throws IOException {
		//String username = "admin123";
		//String password = "wrongadmin";
	
    	String username = ExcelUtility.getStringData(4, 0, "loginpage");
    	String password = ExcelUtility.getStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
}
