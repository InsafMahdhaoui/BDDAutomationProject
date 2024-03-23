package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserNameSearchPageObject {


	public final static String ADMIN_MENU_ITEM_XPATH = "//*[text()='Admin']";
	public final static String SEARCH_INPUT = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
	public final static String SEARCH_BTN = "//button[@type='submit']";
	public final static String SEARCHRESULT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div";

	public final static String XPATHFIRSTPART ="//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String XPATHSECONDPART = "]/div/div[2]";

	@FindBy(how = How.XPATH, using = ADMIN_MENU_ITEM_XPATH)
	public static WebElement adminMenuItemBtn;

	@FindBy(how = How.XPATH, using = SEARCH_INPUT)
	public static WebElement searchInput;

	@FindBy(how = How.XPATH, using = SEARCH_BTN)
	public static WebElement searchBtn;

	@FindBy(how = How.XPATH, using = SEARCHRESULT_XPATH)
	public static List <WebElement> searchResult;
	
	

	public void clickAdminBtn() {
		adminMenuItemBtn.click();
	}

	public void writeToSearch(String username) {
		searchInput.sendKeys(username);
	}

	public void submitSearch() {
		searchBtn.click();
	}

	

	public List<String> verifSearchResult(WebDriver driver) {
		List<String> usernames = new ArrayList<>();

		int listSize = searchResult.size();

		for(int i=1;i<=listSize;i++) {
			String userNameXpath = XPATHFIRSTPART + i + XPATHSECONDPART;
			WebElement userName = driver.findElement(By.xpath(userNameXpath));

			String userNameValue = userName.getText();
			usernames.add(userNameValue);

		}
		return usernames;

	}




}





