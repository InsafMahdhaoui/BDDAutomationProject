package utiles;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
public class Setup {

	public static WebDriver driver;
	static DriverManager driverManager;

	@Before
	/**
	 * Call Browser with the design pattern Factory Navigator
	 */
	public static void setup() {
		driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		driver = driverManager.getDriver();
	}

	@After
	/**
	 * Embed a screenshot in the test report if test is marked as failed
	 */

	public void embedScreenshot(Scenario scenario) {

		System.out.println("Taking screenshot if the scenario fails");

		if ((scenario.isFailed())) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", scenario.getName());

		}

driver.quit();

		}

}
