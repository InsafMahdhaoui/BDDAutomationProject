package utiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommonMethods {

	public static WebDriver driver;
	public static Properties prop;

	public CommonMethods() {
		driver = Setup.driver;
	}
	

	public void openURLWithConfigFile(String url) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/ressources/config/config.properties");
		prop.load(fis);
		driver.get(prop.getProperty(url));
	}

	// Check if element is displayed
	public static Boolean isElementDisplayed(WebElement element) {
		Boolean isElementDisplayed = element.isDisplayed();
		return isElementDisplayed;
	}

	// Upload file with robot
	public void uploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipBoard.setContents(stringSelection, null);

		Robot robot = null;
		try {
			robot = new Robot();

		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	// Handle Alert
	public void handleAlertPopUp() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
		alt.accept();	
	}
	
	// Select Data from calendar by JS
	public static void selectCalendarDateByJS(WebDriver driver,WebElement element, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);	
	}
	
	//Scroll down the web page by the visibility of the element
	public static void scrollVisibilityElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//Scroll vertically down by 1000 pixels
	public static void scrollVertical(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(1000,500)");
	}
	
	public void sleep(Integer seconds) {
		long secondsLong = (long) seconds;
		try {
			Thread.sleep(secondsLong);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Click action with JavaScript Executor	
	public static void clickJSExecutor (WebDriver driver,WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	



	
}
