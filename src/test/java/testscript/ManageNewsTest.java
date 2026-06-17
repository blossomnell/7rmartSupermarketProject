package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@Test(description = "Verify News Creation", retryAnalyzer = retry.Retry.class)
	public void verifyManageNews() throws IOException {

	    String username = ExcelUtility.getStringData(1, 0, "loginpage");
	    String password = ExcelUtility.getStringData(1, 1, "loginpage");

	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUsername(username);
	    loginpage.enterPassword(password);
	    loginpage.clickSigninButton();

	    ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
	    manageNewsPage.clickManageNewsMoreInfoButton();
	    manageNewsPage.clickNewButton();
	    manageNewsPage.enterNews("New products launched");
	    manageNewsPage.clickSaveButton();

	    boolean successmessage = manageNewsPage.isSuccessMessageDisplayed();
	    Assert.assertTrue(successmessage);
	}
}
