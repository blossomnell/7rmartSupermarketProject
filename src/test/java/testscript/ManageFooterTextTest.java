package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {

	@Test(description = "Verify Footer Text Update", retryAnalyzer = retry.Retry.class)
	public void verifyManageFooterText() throws IOException {

        String username = ExcelUtility.getStringData(1, 0, "loginpage");
        String password = ExcelUtility.getStringData(1, 1, "loginpage");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickSigninButton();

        ManageFooterTextPage manageFooterTextPage = new ManageFooterTextPage(driver);

        manageFooterTextPage.clickManageFooterMoreInfoButton();
        manageFooterTextPage.clickActionButton();
        
        String address = ExcelUtility.getStringData(1, 0, "footertext");
        String email = ExcelUtility.getStringData(1, 1, "footertext");
        String phone = ExcelUtility.getIntegerData(1, 2, "footertext");

        manageFooterTextPage.enterAddress(address);
        manageFooterTextPage.enterEmail(email);
        manageFooterTextPage.enterPhone(phone);


        manageFooterTextPage.clickUpdateButton();

        boolean successmessage = manageFooterTextPage.isSuccessMessageDisplayed();
        Assert.assertTrue(successmessage);
    }
}
