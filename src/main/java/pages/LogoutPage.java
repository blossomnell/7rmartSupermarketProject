package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LogoutPage {

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']") WebElement adminButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") WebElement logoutButton;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signinbutton;
	
	
//	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
//	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
//	@FindBy(xpath="//button[@type='submit']")WebElement signindisplay;
	
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility(); 
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;  
		PageFactory.initElements(driver, this);
	}

	public void clickAdminButton() {
		adminButton.click();
	}
	
	public void clickLogoutButton() {
		//logoutButton.click(driver,logoutButton);
		logoutButton.click();
		//pageUtility.javaScriptExecutorClick(driver, logoutButton);
	}
	
	public boolean isSigninButtonDisplayed() {
	    return signinbutton.isDisplayed();
	}
	
}

