package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserStatusSearchPageObject {

	public static final String SELECT_ELEMENT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[1]";
	public static final String SELECT_OPTIONS_CONTAINER =  "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]";
	public static final String SELECT_OPTION_ENABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]";
	public static final String SELECT_OPTION_DISABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[3]";
	public final static String STATUSTABLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div";
	public final static String FIRST_PART_STATUS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_PART_STATUS_XPATH = "]/div/div[5]";
	public final static String SEARCH_BTN = "//button[@type='submit']";



	@FindBy(how = How.XPATH, using = SELECT_ELEMENT_XPATH)
	public static WebElement selectElement;

	@FindBy(how = How.XPATH, using = SELECT_OPTIONS_CONTAINER)
	public static WebElement selectOptionsContainerElement;

	@FindBy(how = How.XPATH,using = SELECT_OPTION_ENABLED_XPATH)
	public static WebElement enabledOptionElement;

	@FindBy(how = How.XPATH, using = SELECT_OPTION_DISABLED_XPATH)
	public static WebElement disabledOptionElement;

	@FindBy(how = How.XPATH, using = STATUSTABLE_XPATH)
	public static List<WebElement> statusTableElement;

	@FindBy(how = How.XPATH, using = SEARCH_BTN)
	public static WebElement btnRechercherElement;


	public void openSelectListMethod() {
		selectElement.click();
	}
	public void selectStatus() {
		disabledOptionElement.click();
	}
	//autre fonction customisee pour cliquer sur un item en cas des select creees avec un html customiser (sans la balise <Select>):
	/*
	 * public void selectStatus1(WebDriver driver, String valueToSelect) {
	 * List<WebElement> statuts =
	 * driver.findElements(By.xpath(SELECT_OPTION_ENABLED_XPATH)); for (WebElement
	 * status : statuts) { if (status.getText().equals(valueToSelect)) {
	 * status.click(); break; } } }
	 */
	

	
	public void clickToSearch() {
		btnRechercherElement.click();
	}
	
	public List<String> verifStatusAffichee(WebDriver driver){

		List<String> usersStatuts = new ArrayList<>();

		int listSize = statusTableElement.size();

		for(int i=1;i<=listSize;i++) {
			String statusXpath = FIRST_PART_STATUS_XPATH + i + SECOND_PART_STATUS_XPATH;
			WebElement userStatusElm = driver.findElement(By.xpath(statusXpath));

			String userStatusValue = userStatusElm.getText();
			usersStatuts.add(userStatusValue);

		}
		return usersStatuts;
	}


}
