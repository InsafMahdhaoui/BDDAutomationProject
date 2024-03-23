package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LogOutPageObject;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class LogoutStepDef {

	private WebDriver driver;

	private LogOutPageObject logoutPO = new LogOutPageObject();

	private WaitMethods waitMethods = new WaitMethods();
	private CommonMethods commonMethods = new CommonMethods();


	public LogoutStepDef() {
		driver = Setup.driver;
		
	PageFactory.initElements(driver, LogOutPageObject.class);}


	@When("cliquer sur l element de nom d utilisateur")
	public void cliquer_sur_l_element_de_nom_d_utilisateur() {
		String selecteur = logoutPO.PROFILE_ELEMENT_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 7);
		logoutPO.profileClick();
	}

	@When("je select l item Log Out")
	public void je_select_l_item_log_out() {
		
		String selecteur = logoutPO.LOGOUT_ITEM_XPATH;
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 7);
		logoutPO.logout();
	}

	@Then("je verifi je me redirige vers la page d authentification et le mot {string} s affiche")
	public void je_verifi_je_me_redirige_vers_la_page_d_authentification_et_le_mot_s_affiche(String expectedMsg) throws InterruptedException {
		String selecteur = logoutPO.VERIF_MSG;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 7);
Thread.sleep(5000);
		String msgObtenu = logoutPO.verifDeconnexion();
		Assert.assertEquals(expectedMsg, msgObtenu);
	}

}
