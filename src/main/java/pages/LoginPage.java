package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	//WaitUtility wait = new WaitUtility();
	
	@FindBy(xpath = "//input[@name='username']") WebElement usernamefield;
    @FindBy(xpath = "//input[@name='password']") WebElement passwordfield;
    @FindBy(xpath="//button[text()='Sign In']") WebElement signinbutton;
    @FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
    //@FindBy(xpath="//p[text()='dismissible']") WebElement alert;
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]") WebElement alert;
    
    
    public LoginPage(WebDriver driver) {
		this.driver = driver;  
		PageFactory.initElements(driver, this);  //this means current class's instance emthod
	}

	public void enterUsername(String username) {
    	usernamefield.sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	passwordfield.sendKeys(password);
    }
    
    public void clickSigninButton() {
    	//wait.waitForElementToBeClickable(driver, signinbutton);
    	signinbutton.click();
    }
    
    public boolean isDashboardDisplayed() {
    	return dashboard.isDisplayed();
    }
    
    public boolean isAlertDisplayed() {
    	return alert.isDisplayed();
    }
}
