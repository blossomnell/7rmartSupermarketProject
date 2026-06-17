package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;


public class ManageCategoryPage {

	@FindBy(xpath = "//a[contains(@href,'list-category') and contains(@class,'small-box-footer')]")
    WebElement manageCategoryMoreInfoButton;

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
    WebElement newButton;

    @FindBy(xpath = "//input[@id='category']")
    WebElement categoryField;

    @FindBy(xpath = "//div[@class='ms-selectable']//span[text()='discount']")
    WebElement discountGroupOption;

    @FindBy(xpath = "//input[@id='main_img']")
    WebElement chooseFile;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButton;

    //@FindBy(xpath = "//div[contains(@class,'alert-success')]")
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    WebElement successMessage;

    public WebDriver driver;
    PageUtility pageUtility = new PageUtility();

    public ManageCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickManageCategoryMoreInfoButton() {
        pageUtility.javaScriptExecutorClick(driver, manageCategoryMoreInfoButton);
    }

    public void clickNewButton() {
        newButton.click();
    }

    public void enterCategory(String category) {
        categoryField.sendKeys(category);
    }

    public void clickDiscountGroup() {
        discountGroupOption.click();
    }

    public void uploadImage(String filepath) {
        FileUploadUtility upload = new FileUploadUtility();
        upload.fileUploadUsingSendKeys(chooseFile, filepath);
    }

    public void clickSaveButton() {
       // saveButton.click();
    	pageUtility.javaScriptExecutorClick(driver, saveButton);
    	
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
