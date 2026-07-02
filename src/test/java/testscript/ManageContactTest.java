package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{

	@Test(description = "Verify Manage Contact Update Functionality", retryAnalyzer = retry.Retry.class)
	public void verifyManageContact() throws IOException {

        String username = ExcelUtility.getStringData(1, 0, "loginpage");
        String password = ExcelUtility.getStringData(1, 1, "loginpage");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickSigninButton();

        String phone = ExcelUtility.getIntegerData(1, 0, "contact");
        String email = ExcelUtility.getStringData(1, 1, "contact");
        String address = ExcelUtility.getStringData(1, 2, "contact");
        String deliverytime = ExcelUtility.getIntegerData(1, 3, "contact");
        String deliverycharge = ExcelUtility.getIntegerData(1, 4, "contact");

        ManageContactPage manageContactPage = new ManageContactPage(driver);

        manageContactPage.clickManageContactMoreInfoButton();
        manageContactPage.clickActionButton();

        manageContactPage.enterPhone(phone);
        manageContactPage.enterEmail(email);
        manageContactPage.enterAddress(address);
        manageContactPage.enterDeliveryTime(deliverytime);
        manageContactPage.enterDeliveryCharge(deliverycharge);

        manageContactPage.clickUpdateButton();

        boolean successmessage = manageContactPage.isSuccessMessageDisplayed();
        Assert.assertTrue(successmessage, Constant.SUCCESSMSGNOTDISPLAYED);
    }
}
