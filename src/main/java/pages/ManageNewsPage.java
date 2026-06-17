package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	   @FindBy(xpath = "//a[contains(@href,'list-news')]")
	    WebElement manageNewsMoreInfoButton;
	
	  @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	    WebElement newButton;

	    @FindBy(xpath = "//textarea[@id='news']")
	    WebElement newsTextBox;

	    @FindBy(xpath = "//button[text()='Save']")
	    WebElement saveButton;

	    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
	    WebElement successMessage;

	    public WebDriver driver;

	    public ManageNewsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void clickManageNewsMoreInfoButton() {
	        manageNewsMoreInfoButton.click();
	    }
	    
	    public void clickNewButton() {
	        newButton.click();
	    }

	    public void enterNews(String news) {
	        newsTextBox.sendKeys(news);
	    }

	    public void clickSaveButton() {
	        saveButton.click();
	    }

	    public boolean isSuccessMessageDisplayed() {
	        return successMessage.isDisplayed();
	    }
}
