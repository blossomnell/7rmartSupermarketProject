package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void dropdownVisibleText(WebElement element, String Text) {
		Select select = new Select(element);
		select.selectByVisibleText(Text);
	}
	
     public void dropdownValue(WebElement element, String Value) {
    	 Select select = new Select(element);
 		 select.selectByVisibleText(Value);
		
	}
	
     public void dropdownIndex(WebElement element, String Index) {
    	 Select select = new Select(element);
 		 select.selectByVisibleText(Index);
 	}
     
     public void rightClick(WebDriver driver, WebElement element) {
    	 Actions actions = new Actions(driver);
    	 actions.contextClick(element).perform();
     }
     
     public void dragDrop(WebDriver driver, WebElement source, WebElement target) {
    	 Actions actions = new Actions(driver);
    	 actions.dragAndDrop(source, target).perform();
     }
     
     public void javaScriptExecutorScrollDown(WebDriver driver ) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("window.scrollBy(0,150)","");
     }
     
     public void javaScriptExecutorClick(WebDriver driver, WebElement element ) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].click();", element);
     }
     
     public void javaScriptExecutorSendKeys(WebDriver driver, WebElement element ) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].value='value';", element);
     }
     
     public void selectByValue(WebElement element, String value)

 	{
 		Select select = new Select(element);
 		select.selectByValue(value);
 	}
}
