package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitUtility;

import utilities.PageUtility;

public class AdminUsersPage {

	WaitUtility waitUtility = new WaitUtility();
	
	//@FindBy(xpath = "//a[contains(@href,'list-admin')]")
	@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(@class,'small-box-footer')]")
    WebElement adminUsersMoreInfoButton;

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
    WebElement newButton;

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//select[@id='user_type']")
    WebElement userTypeDropdown;

    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();

    public AdminUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAdminUsersMoreInfoButton() {
        //adminUsersMoreInfoButton.click();
    	pageUtility.javaScriptExecutorClick(driver, adminUsersMoreInfoButton);
    }

    public void clickNewButton() {
    	waitUtility.waitForElementToBeClickable(driver, newButton); //until new button is clickable
        newButton.click();
        waitUtility.waitForElementToBeClickable(driver, usernameField); //wait until username field is ready to input; was not working in firefox

    }

    public void enterUsername(String username) {
    	//usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void selectUserType(String value) {
        pageUtility.selectByValue(userTypeDropdown, value);
    }

    public String getSelectedUserType() {
        Select select = new Select(userTypeDropdown);
        return select.getFirstSelectedOption().getAttribute("value");
    }
}
