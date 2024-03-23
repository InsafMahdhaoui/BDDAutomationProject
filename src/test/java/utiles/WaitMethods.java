package utiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class WaitMethods {

	WebDriverWait waitExplicit;

	public void implicitWait(WebDriver driver, long second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.MILLISECONDS);
	}

	public WebElement explicitWaitUntilVisibilityOfButtonCss(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		return button;
	}

	public WebElement explicitWaitUntilVisibilityOfButtonXpath(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return button;
	}

	public WebElement explicitWaitUntilButtonIsClickableCss(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		return button;
	}

	public WebElement explicitWaitUntilButtonIsClickableXpath(WebDriver driver, String locator, long second) {
		WebElement button;
		waitExplicit = new WebDriverWait(driver, second);
		button = waitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		return button;
	}

	public WebElement explicitWaitUntilPresenceOfElementLocatedXpath(WebDriver driver, String locator, long second) {
		WebElement wElement;
		waitExplicit = new WebDriverWait(driver, second);
		wElement = waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		return wElement;
	}
	
	public WebElement explicitWaitUntilPresenceOfElementLocatedCss(WebDriver driver, String locator, long second) {
		WebElement wElement;
		waitExplicit = new WebDriverWait(driver, second);
		wElement = waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		return wElement;
	}


}
