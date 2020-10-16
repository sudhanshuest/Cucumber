package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.GoogleHome;
import Pages.GoogleSearch;
import cucumber.api.java.en.*;
import testBase.TestBase;

public class StepDefination extends TestBase{
	WebDriver driver;
	GoogleHome lp;
	GoogleSearch gs;
	@Given("Open the Chrome Browser")
	public void open_the_Chrome_Browser() {
		driver=TestBase.selectBrowser(getProperty("browser"));
		Log.info("Running...Open the Chrome Browser");
		Log.info("Priniting browser name "+getProperty("browser"));
		Log.info("Finishing...Open the Chrome Browser");

		}

	@When("User Open the URL {string}")
	public void user_Open_the_URL(String string) {
		Log.info("Running...User Open the URL {string}");
		Log.info("URL is "+string);
		lp=new GoogleHome(driver);
		driver.get(string);
		takeScreenShot(driver);
		Log.info("Finishing...User Open the URL {string}");

	}

	@When("Search for {string}")
	public void search_for(String string) {
		Log.info("Running...Search for {string}");
		gs=lp.searchName(string);
		Log.info("Search Query is "+string);
		Log.info("Finishing...Search for {string}");

	}

	@And("Make sure {string} is the first search result")
	public void make_sure_is_the_first_search_result(String string) {
		Log.info("Running... Make sure {string} is the first search result");
		String actual=gs.firstUrl();
		Log.info("Actual url is "+actual);
		Log.info("Expected url is"+string);
		takeScreenShot(driver);
		Assert.assertEquals(actual,string);
		Log.info("Finishing... Make sure {string} is the first search result");
}
	@And("close the browser")
	public void close_the_browser()
	{
		Log.info("Running... Closing browser");
		driver.close();
		Log.info("Finshing... Closing browser");
	}
}
