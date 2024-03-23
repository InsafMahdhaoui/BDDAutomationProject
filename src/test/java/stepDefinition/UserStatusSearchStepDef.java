package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UserRoleSearchPageObject;
import pageObject.UserStatusSearchPageObject;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class UserStatusSearchStepDef {
	
	private WebDriver driver;

	private UserStatusSearchPageObject userStatusSearchPageObject = new UserStatusSearchPageObject();

	WaitMethods waitMethods = new WaitMethods();

	private CommonMethods commonMethods = new CommonMethods();

	public UserStatusSearchStepDef(){
		driver = Setup.driver;	
		PageFactory.initElements(driver, UserStatusSearchPageObject.class);
	}

	@When("je clique sur la liste deroulante des userStatus")
	public void je_clique_sur_la_liste_deroulante_des_user_status() {
		String selecteur = UserStatusSearchPageObject.SELECT_ELEMENT_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);
		userStatusSearchPageObject.openSelectListMethod();
	
		
	}

	@When("je select le UserStatus {string}")
	public void je_select_le_user_status(String userStatus) {
		String selecteur = UserStatusSearchPageObject.SELECT_OPTIONS_CONTAINER;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);
		userStatusSearchPageObject.selectStatus();
		
		//appel de la fonction customisee :
		//userStatusSearchPageObject.selectStatus1(driver, userStatus);
	}

	@When("je clique sur le boutton de recherche")
	public void je_clique_sur_le_boutton_de_recherche() throws InterruptedException {
		String selecteur = UserStatusSearchPageObject.SEARCH_BTN;
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 9);
		Thread.sleep(5000);
		userStatusSearchPageObject.clickToSearch();
		
	}

	@Then("je verifi les status des users affichees {string}")
	public void je_verifi_les_status_des_users_affichees(String userStatus) {
		String selecteur = UserStatusSearchPageObject.STATUSTABLE_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);
		
		
		List<String> usersStatutsObtenu = userStatusSearchPageObject.verifStatusAffichee(driver);
		String ExpectedUserStatus = userStatus.toLowerCase();

		for (int i=1;i<=usersStatutsObtenu.size();i++) {
			Assert.assertEquals(ExpectedUserStatus, usersStatutsObtenu.get(i).toLowerCase());}
		
	}
}
