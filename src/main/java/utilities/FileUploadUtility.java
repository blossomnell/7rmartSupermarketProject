package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void fileUploadUsingSendKeys(WebElement element, String filepath) {
		 element.sendKeys(filepath);
	 }
	 
    public void fileUploadUsingRobotClass(WebElement element, String filepath) throws AWTException {
   	 StringSelection s = new StringSelection("C:\\Users\\bloss\\OneDrive\\Desktop\\Java Class\\Book1.pdf");
		//string selection stores the file path as text
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		//to copy file path to the system clipboard
		//same as ctrl c
		Robot r = new Robot(); //used to perform keyboard actions
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	 }
}
