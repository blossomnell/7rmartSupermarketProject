package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base{

	@Test(description = "Verify Category Creation With Image Upload", retryAnalyzer = retry.Retry.class)
	public void verifyUploadFile() throws IOException {

        String username = ExcelUtility.getStringData(1, 0, "loginpage");
        String password = ExcelUtility.getStringData(1, 1, "loginpage");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
        loginpage.clickSigninButton();

        String category = ExcelUtility.getStringData(1, 0, "category");

        ManageCategoryPage manageCategoryPage = new ManageCategoryPage(driver);

        manageCategoryPage.clickManageCategoryMoreInfoButton();
        manageCategoryPage.clickNewButton();
        manageCategoryPage.enterCategory(category);
        manageCategoryPage.clickDiscountGroup();
        manageCategoryPage.uploadImage(Constant.ORANGEIMAGE);
        manageCategoryPage.clickSaveButton();

        boolean successmessage = manageCategoryPage.isSuccessMessageDisplayed();
        Assert.assertTrue(successmessage);
    }
}
