package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{

	@Test(description = "Verify Dropdown Selection In Admin Users", retryAnalyzer = retry.Retry.class)
	public void verifyAdminUsersDropdown() throws IOException {

        String username = ExcelUtility.getStringData(1, 0, "loginpage");
        String password = ExcelUtility.getStringData(1, 1, "loginpage");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickSigninButton();

        //String adminUsername = ExcelUtility.getStringData(1, 0, "adminuser");
        
        //if we use faker utility
        FakerUtility fakerutility = new FakerUtility();
        String adminUsername = fakerutility.createRandomFirstName();
        
        String adminPassword = ExcelUtility.getStringData(1, 1, "adminuser");
        String value = ExcelUtility.getStringData(1, 2, "adminuser");

        AdminUsersPage adminUsersPage = new AdminUsersPage(driver);

        adminUsersPage.clickAdminUsersMoreInfoButton();
        adminUsersPage.clickNewButton();
        adminUsersPage.enterUsername(adminUsername);
        adminUsersPage.enterPassword(adminPassword);
        adminUsersPage.selectUserType(value);

        String selectedvalue = adminUsersPage.getSelectedUserType();
        Assert.assertEquals(selectedvalue, value, Constant.ADMINUSERMISMATCH);
    }
}
