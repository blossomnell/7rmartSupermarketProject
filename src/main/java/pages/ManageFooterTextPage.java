package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class ManageFooterTextPage {

	@FindBy(xpath = "//a[contains(@href,'list-footertext') and contains(@class,'small-box-footer')]")
    WebElement manageFooterMoreInfoButton;

    @FindBy(xpath = "//a[contains(@href,'Footertext/edit')]//i[contains(@class,'fa-edit')]")
    WebElement actionButton;

    @FindBy(xpath = "//textarea[@id='content']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//button[@name='Update']")
    WebElement updateButton;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMessage;

    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();

    public ManageFooterTextPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickManageFooterMoreInfoButton() {
        pageUtility.javaScriptExecutorClick(driver, manageFooterMoreInfoButton);
    }

    public void clickActionButton() {
        actionButton.click();
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
