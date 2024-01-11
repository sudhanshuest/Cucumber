package stepDefination;

import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pages.GoogleHome;
import Pages.GoogleSearch;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testBase.TestBase;

public class CapstoneStepDef extends TestBase {
	
	WebDriver driver;
	GoogleHome lp;
	GoogleSearch gs;
	@Given("Launch given url and verify Title")
	public void launchBrowserandVerifyTitle() {
		driver=TestBase.selectBrowser(getProperty("browser"));
		lp=new GoogleHome(driver);
		driver.get("http://the-internet.herokuapp.com/");
		takeScreenShot(driver);
		Log.info("Finishing...User Open the URL {string}");
		String title=driver.getTitle();
		Assert.assertEquals("The Internet", title);
	   

		}

	@When("Click on A/B Testing link")
	public void clickOnTestLink(String string) {
		WebElement element=driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a"));
		Log.info("Running...User Open the URL {string}");
		Log.info("URL is "+string);
		lp=new GoogleHome(driver);
		Actions action=new Actions(driver);
		action.moveToElement(element).click();
		takeScreenShot(driver);
		Log.info("Finishing...User Open the URL {string}");

	}

	@Then("verify the text on the page")
	public void verifytext(String string) {
		String testtext="A/B Test Control";
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertEquals(testtext, ele);

	}

	@And("Navigate back to Home page and click on dropdown link")
	public void navigateAndClick(String string) {
	driver.navigate().back();
	WebElement dropdownlink=driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a"));
	Actions action=new Actions(driver);
	action.click(dropdownlink);
}
	@And("Select Option1 value form drop down and confirm if its selected or not")
	public void selectAndConfirm()
	{
		WebElement element=driver.findElement(By.xpath(""));
		Select objSelect =new Select(driver.findElement(By.id("dropdown")));
		objSelect.selectByVisibleText(“Option 1”);
		WebElement o = select.getFirstSelectedOption();
	    String selectedoption = o.getText();
	    System.out.println("Selected element: " + selectedoption);
	}
	
	@And("Navigate back to Home page and click on frames")
	public void navigateAndClickframes(String string) {
	driver.navigate().back();
	WebElement frames=driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a"));
	Actions action=new Actions(driver);
	action.click(frames);
	}
	
	@Then("Verify the Nested Frames and iFrame are presented on the Frames Page")
	public void verifyframes(String string) {
		String frame1="Nested Frames";
		String frame2="iFrame";
		WebElement eleframe1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a"));
		WebElement eleframe2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a"));
		Assert.assertEquals(frame1, eleframe1);
		Assert.assertEquals(frame2, eleframe2);

	}

}
