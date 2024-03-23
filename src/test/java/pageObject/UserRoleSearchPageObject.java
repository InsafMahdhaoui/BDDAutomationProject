package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

//*[@id="app"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div

public class UserRoleSearchPageObject {
	public final static String SELECT_CONTAINER = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]";
	public final static String SELECT_ADMIN_ITEM_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]";
	public final static String SELECT_ESS_ITEM_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]";
	public final static String SELECT_ELEMENT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]";
	public final static String SEARCH_BTN = "//button[@type='submit']";
	public final static String ROLETABLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div";
	public final static String ROLE_FIRST_PART_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String ROLE_SECOND_PART_XPATH = "]/div/div[3]/div";


	@FindBy(how = How.XPATH, using = SELECT_ELEMENT_XPATH)
	public static WebElement selectElement;

	@FindBy(how = How.XPATH, using = SELECT_ADMIN_ITEM_XPATH)
	public static WebElement selectAdminItem;

	@FindBy(how = How.XPATH, using = SELECT_ESS_ITEM_XPATH)
	public static WebElement selectEssItem;

	@FindBy(how = How.XPATH, using = SEARCH_BTN)
	public static WebElement searchBtn;

	@FindBy(how = How.XPATH, using = ROLETABLE_XPATH)
	public static List<WebElement> roleTable;

	public void selectClick()
	{
		selectElement.click();
	}

	/*
	 * public void selectRole(WebDriver driver, String valueToSelect) {
	 * List<WebElement> roles = driver.findElements(By.xpath(SELECT_ESS_ITEM_XPATH)); 
	 * for (WebElement role :roles) {
	 *  if (role.getText().equals(valueToSelect))
	 *   { role.click(); break; } }
	 * }
	 */

	public void selectAdminRole() {
		selectAdminItem.click();
	}
	
	public void selectESSRole() {
		selectEssItem.click();
	}


	public void clickSearch() {
		searchBtn.click();
	}

	public List<String> verifRoleAffichee(WebDriver driver){

		List<String> usersRoles = new ArrayList<>();

		int listSize = roleTable.size();

		for(int i=1;i<=listSize;i++) {
			String roleXpath = ROLE_FIRST_PART_XPATH + i + ROLE_SECOND_PART_XPATH;
			WebElement userRoleElm = driver.findElement(By.xpath(roleXpath));

			String userRoleValue = userRoleElm.getText();
			usersRoles.add(userRoleValue);

		}
		return usersRoles;
	}











}
