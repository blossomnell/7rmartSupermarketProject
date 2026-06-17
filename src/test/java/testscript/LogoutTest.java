package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;


public class LogoutTest extends Base {

	@Test(description = "Verify Successful Logout", retryAnalyzer = retry.Retry.class)
	public void verifySuccessfullLogout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSigninButton();
		//now logout
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickAdminButton();
		logoutPage.clickLogoutButton();
		
		boolean signinpage = logoutPage.isSigninButtonDisplayed();
		Assert.assertTrue(signinpage);
	}
}
