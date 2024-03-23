package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AuthentificationPageObject;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class AuthentificationStepDefinition extends CommonMethods {
	
	//declarer les variables de la classe
	private WebDriver driver;
	
	//instanciation de la classe AuthentificationPageObject
	private AuthentificationPageObject authentificationPageObject = new  AuthentificationPageObject();
	
	//instanciation de la classe CommonMethods
	private CommonMethods commonMethods = new CommonMethods();
	
	private WaitMethods waitMethods = new WaitMethods();
	
	//constructeur de la classe AuthentificationStepDefinition
	public AuthentificationStepDefinition() {
		
		//initialisation du webdriver instanciee dans la classe Setup
		driver = Setup.driver;
		
		//initialisation des elements web de la classe PageObject
		PageFactory.initElements(driver, AuthentificationPageObject.class);
	}
	
	
	@Given("je me connecte sur l'application")
	public void jeMeConnecteSurLApplication() throws IOException {
		//ouvrir l'url a partir du fichier de configa l'aide de methode openURLWithConfigFile developpee dans la classecommonMethods 
		commonMethods.openURLWithConfigFile("url");
	 }

	@When("je saisi le login {string}")
	public void jeSaisiLeLogin(String login) throws InterruptedException {
		
		//Thread.sleep(3000);
		String selecteur = authentificationPageObject.USERNAME_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);
		//appel a la methode qu'on a developpee dans la classe AuthentificationPageObject
		authentificationPageObject.saisirLogin(login);
		
	 }

	@When("je saisi le password {string}")
	public void jeSaisiLePassword(String password) {
		String selecteur = authentificationPageObject.PASSWORD_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);
		
		authentificationPageObject.saisirPassword(password);
	 }

	@When("je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() throws InterruptedException {
		String selecteur = authentificationPageObject.LOGIN_BTN_XPATH;
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 5);
		
		//Thread.sleep(5000);
		authentificationPageObject.clickBoutton();
	   }

	@Then("je me redirige vers la page d'accueil et {string} s'affiche")
	public void jeMe_RedirigeVersLaPageDAccueilEtSAffiche(String resultatAttendu) throws InterruptedException {
		//Thread.sleep(5000);
		String selecteur = authentificationPageObject.VERIF_MSG_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);
		
		String resultatObtenu = authentificationPageObject.verifierPageAccueil();
		Assert.assertEquals(resultatAttendu, resultatObtenu);
		
	 }

}
