package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LogOutPageObject {


	public final static String PROFILE_ELEMENT_XPATH= "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span";
	public final static String LOGOUT_ITEM_XPATH = "//*[text()='Logout']";
	public final static String VERIF_MSG = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5";


	@FindBy(how = How.XPATH, using = PROFILE_ELEMENT_XPATH)
	public static WebElement profileElement;

	@FindBy(how = How.XPATH, using = LOGOUT_ITEM_XPATH)
	public static WebElement logoutElement;

	@FindBy(how = How.XPATH, using = VERIF_MSG)
	public static WebElement verifMsg;


	public void profileClick() {
		profileElement.click();
	}
	
	//public void selectRole(WebDriver driver, String valueToSelect) {
//		List<WebElement> roles = driver.findElements(By.xpath(SELECT_ESS_ITEM_XPATH)); 
//		for (WebElement role :roles) {
//			if (role.getText().equals(valueToSelect))
//			{ role.click(); break; } }
//	}

	public void logout() {
		logoutElement.click();
	}

	public String verifDeconnexion() {
		String msgObtenu = verifMsg.getText();
		return msgObtenu;
	}
}

