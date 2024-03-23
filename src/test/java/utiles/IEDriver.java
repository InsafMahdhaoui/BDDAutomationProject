package utiles;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriver extends DriverManager {

	@Override
	protected void startService() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");

	}

	@Override
	protected void stopService() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createDriver() {
		// TODO Auto-generated method stub
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}

}
