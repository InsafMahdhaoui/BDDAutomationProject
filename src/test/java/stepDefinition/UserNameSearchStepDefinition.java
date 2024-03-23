package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UserNameSearchPageObject;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class UserNameSearchStepDefinition {

	private WebDriver driver; 

	private UserNameSearchPageObject userNameSearchPageObject = new UserNameSearchPageObject();


	private WaitMethods waitMethods = new WaitMethods();
	private CommonMethods commonMethods = new CommonMethods();

	public UserNameSearchStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, UserNameSearchPageObject.class);
	}

	@When("je clique sur l element Admin dans le menu")
	public void je_clique_sur_l_element_admin_dans_le_menu() {	
		String selecteur = userNameSearchPageObject.ADMIN_MENU_ITEM_XPATH;
		waitMethods.explicitWaitUntilVisibilityOfButtonXpath(driver, selecteur, 5);
		userNameSearchPageObject.clickAdminBtn();

	}

	@When("je saisi le userName {string}")
	public void je_saisi_le_user_name(String userName) {
		//userNameSaisi = userName;
		String selecteur = userNameSearchPageObject.SEARCH_INPUT;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);
		userNameSearchPageObject.writeToSearch(userName);
	}

	@When("je clique sur le boutton Search")
	public void je_clique_sur_le_boutton_search() {
		String selecteur = userNameSearchPageObject.SEARCH_BTN;
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 7);
		userNameSearchPageObject.submitSearch();
	}

	@Then("je verifi le tableau affichee {string}")
	public void je_verifi_le_tableau_affichee(String username) {

		String selecteur = userNameSearchPageObject.SEARCHRESULT_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);

		List<String> userNameObtenu = userNameSearchPageObject.verifSearchResult(driver);
		String expectedUserName = username.toLowerCase();

		for (int i=1;i<=userNameObtenu.size();i++) {
			Assert.assertEquals(expectedUserName, userNameObtenu.get(i).toLowerCase());}
	}


}
