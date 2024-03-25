package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class EmployeeNameSearchPageObject {

	public final static String EMPLOYEE_INPUT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input";
	public final static String SEARCH_BTN = "//button[@type='submit']";
	public final static String EMPLOYEE_NAME_TABLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div";
	public final static String FIRST_PART_XPATH_EMPLOYEE_NAME = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_PART_XPATH_EMPLOYEE_NAME = "]/div/div[4]/div";
	public final static String LISTBOX_CONTAINER_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]";
	public final static String LISTBOX_OPTION_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div";
	public final static String LISTBOX_OPTION_TEXT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div/span";


	@FindBy(how = How.XPATH, using = EMPLOYEE_INPUT_XPATH)
	public static WebElement employeeSearchInputElement;

	@FindBy(how = How.XPATH, using = LISTBOX_CONTAINER_XPATH)
	public static WebElement listBoxContainerElement;

	@FindBy(how = How.XPATH, using = LISTBOX_OPTION_XPATH)
	public static WebElement listBoxOptionElement;

	@FindBy(how = How.XPATH, using = LISTBOX_OPTION_TEXT_XPATH)
	public static WebElement listBoxOptionTextElement;

	@FindBy(how = How.XPATH, using = SEARCH_BTN)
	public static WebElement searchBtnElement;

	@FindBy(how = How.XPATH, using = EMPLOYEE_NAME_TABLE_XPATH)
	public static List <WebElement> employeeNameTableElement;


	public void saisiEmployeeName(String employeeName) {
		employeeSearchInputElement.sendKeys(employeeName);
	}

	public void listOptionClick() {
		//Select select = new Select(listBoxContainerElement);
		//String option = listBoxOptionTextElement.getText();
		//	select.deselectByValue(option);
		listBoxContainerElement.click();
	}

	public void searchSubmit()  {
		searchBtnElement.click();
	}

	public List<String> verifEmployeeNameSearchResult(WebDriver driver) {
		List<String> empolyeeNames = new ArrayList<>();

		int listSize = employeeNameTableElement.size();

		for(int i=1;i<=listSize;i++) {
			String empolyeeNameXpath = FIRST_PART_XPATH_EMPLOYEE_NAME + i + SECOND_PART_XPATH_EMPLOYEE_NAME;
			WebElement empolyeeName = driver.findElement(By.xpath(empolyeeNameXpath));

			String empolyeeNameValue = empolyeeName.getText();
			empolyeeNames.add(empolyeeNameValue);

		}
		return empolyeeNames;

	}









}
