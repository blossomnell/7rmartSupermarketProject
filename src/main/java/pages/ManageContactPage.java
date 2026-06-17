package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;


public class ManageContactPage {

	@FindBy(xpath = "//a[contains(@href,'list-contact') and contains(@class,'small-box-footer')]")
    WebElement manageContactMoreInfoButton;

    @FindBy(xpath = "//i[@class='fas fa-edit']")
    WebElement actionButton;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//textarea[@name='address']")
    WebElement addressField;

    @FindBy(xpath = "//textarea[@placeholder='Enter Delivery Time']")
    WebElement deliveryTimeField;

    @FindBy(xpath = "//input[@id='del_limit']")
    WebElement deliveryChargeField;

    @FindBy(xpath = "//button[@type='submit' and contains(@class,'btn-info')]")
    WebElement updateButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMessage;

    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();

    public ManageContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickManageContactMoreInfoButton() {
        pageUtility.javaScriptExecutorClick(driver, manageContactMoreInfoButton);
    }

    public void clickActionButton() {
        actionButton.click();
    }

    public void enterPhone(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void enterDeliveryTime(String deliveryTime) {
        deliveryTimeField.clear();
        deliveryTimeField.sendKeys(deliveryTime);
    }

    public void enterDeliveryCharge(String deliveryCharge) {
        deliveryChargeField.clear();
        deliveryChargeField.sendKeys(deliveryCharge);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
