package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthentificationPageObject {

	// identifier les selecteurs des elements web
	public final static String USERNAME_XPATH = "//input[@name='username']";
	public final static String PASSWORD_XPATH = "//input[@name='password']";
	public final static String LOGIN_BTN_XPATH = "//button[@type='submit']";
	public final static String VERIF_MSG_XPATH = "/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6";

	// declaration des elements Web(identification des webelements avec l'annotation
	// "FindBy")
	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement userName;

	@FindBy(how = How.XPATH, using = PASSWORD_XPATH)
	public static WebElement password;

	@FindBy(how = How.XPATH, using = LOGIN_BTN_XPATH)
	public static WebElement loginBtn;

	@FindBy(how = How.XPATH, using = VERIF_MSG_XPATH)
	public static WebElement verifMsg;


	//creation des methodes
	public void saisirLogin(String login) {
		userName.sendKeys(login);
	}

	public void saisirPassword(String pswd) {
		password.sendKeys(pswd);
	}

	public void clickBoutton() {
		loginBtn.click();
	}

	public String verifierPageAccueil(){
		String msgObtenu = verifMsg.getText();
		return msgObtenu;
	}










	


}
