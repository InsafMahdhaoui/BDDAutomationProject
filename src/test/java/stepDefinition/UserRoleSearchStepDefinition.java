package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UserRoleSearchPageObject;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class UserRoleSearchStepDefinition {

	private WebDriver driver;

	private UserRoleSearchPageObject userRoleSearchPageObject = new UserRoleSearchPageObject();

	WaitMethods waitMethods = new WaitMethods();

	private CommonMethods commonMethods = new CommonMethods();

	public UserRoleSearchStepDefinition(){
		driver = Setup.driver;	
		PageFactory.initElements(driver, UserRoleSearchPageObject.class);
	}


	@When("je clique sur la liste deroulante des userRole")
	public void je_clique_sur_la_liste_deroulante_des_user_role() {
		String selecteur = UserRoleSearchPageObject.SELECT_ELEMENT_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);
		userRoleSearchPageObject.selectClick();

	}

	@When("je select le UserRole {string}")
	public void je_select_le_user_role(String userRole) throws InterruptedException {
		Thread.sleep(7000);
		String selecteur = UserRoleSearchPageObject.SELECT_CONTAINER;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);
		//userRoleSearchPageObject.selectRole(driver, userRole );
		userRoleSearchPageObject.selectAdminRole();
	}
	@When("je clique sur le boutton rechercher")
	public void je_clique_sur_le_boutton_rechercher() throws InterruptedException {
		Thread.sleep(5000);

		String selecteur = UserRoleSearchPageObject.SEARCH_BTN;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);
		userRoleSearchPageObject.clickSearch();

	}

	@Then("je verifi les roles des users affichees {string}")
	public void je_verifi_les_roles_des_users_affichees(String userRole) throws InterruptedException {
		//Thread.sleep(5000);

		String selecteur = UserRoleSearchPageObject.ROLETABLE_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 9);

		List<String> usersRolesObtenus = userRoleSearchPageObject.verifRoleAffichee(driver);
		String ExpectedUserRole = userRole.toLowerCase();

		for (int i=1;i<=usersRolesObtenus.size();i++) {
			Assert.assertEquals(ExpectedUserRole, usersRolesObtenus.get(i).toLowerCase());}
	}



}
