package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.EmployeeNameSearchPageObject;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class EmployeeNameSearchStepDef {

	private WebDriver driver;

	//	instantiation de classe PageObject du cas de test
	private EmployeeNameSearchPageObject employeeNameSearchPageObject = new EmployeeNameSearchPageObject();

	//	instantiation des classes WaitMethods et CommonMethods
	private WaitMethods waitMethods = new WaitMethods();
	private CommonMethods commonMethods = new CommonMethods();

	//constructeur
	public EmployeeNameSearchStepDef() {
		driver =Setup.driver;
		PageFactory.initElements(driver, EmployeeNameSearchPageObject.class);
	}



	@When("je saisi le employeeName {string}")
	public void je_saisi_le_employee_name(String employeeName) {
		String selecteur = employeeNameSearchPageObject.EMPLOYEE_INPUT_XPATH;
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);
		employeeNameSearchPageObject.saisiEmployeeName(employeeName);
	}
	
	@When("je clique sur l element dans la list")
	public void je_clique_sur_l_element_dans_la_list() throws InterruptedException {
		String selecteur = employeeNameSearchPageObject.LISTBOX_OPTION_XPATH;
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 7);
		Thread.sleep(5000);
		employeeNameSearchPageObject.listOptionClick();
	}

	@When("je clique sur le searchButton")
	public void je_clique_sur_le_search_button() throws InterruptedException {
		String selecteur = employeeNameSearchPageObject.SEARCH_BTN;
		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, selecteur, 7);
		Thread.sleep(5000);
		employeeNameSearchPageObject.searchSubmit();
		//Thread.sleep(5000);
	}

	@Then("je verifi les empolyeeNames affichees {string}")
	public void je_verifi_les_empolyee_names_affichees(String employeeName) throws InterruptedException {
	
	String selecteur = employeeNameSearchPageObject.EMPLOYEE_NAME_TABLE_XPATH;
	waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, selecteur, 5);
	Thread.sleep(5000);
	
	List<String> employeesNamesObtenus = employeeNameSearchPageObject.verifEmployeeNameSearchResult(driver);
	String employeeNameAttendu = employeeName.toLowerCase();

	for (int i=1;i<employeesNamesObtenus.size();i++) {
		Assert.assertEquals(employeeNameAttendu, employeesNamesObtenus.get(i).toLowerCase());}
}

	}


