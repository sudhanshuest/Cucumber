package org.bdd.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bdd.pages.HeroKuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CapstoneStepDef {

    private WebDriver driver;
    private HeroKuPage herokuPage;



    @Before

    public void setup(){
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }



    @Given("Launch given url and verify Title")
    public void launch_given_url_and_verify_title() {
        driver.get("http://the-internet.herokuapp.com/");
        herokuPage = new HeroKuPage(driver);
    }

    @When("Click on AB Testing link")
    public void click_on_a_b_testing_link() {
        herokuPage.clickLoginButton();

    }

    @Then("verify the text on the page")
    public void verify_the_text_on_the_page() {
        Assert.assertEquals( driver.findElement(By.xpath("//*[@id='content']/div/h3")).isDisplayed(), true);

    }

    @And("Navigate back to Home page and click on dropdown link")
    public void naviagate_To_Homepage_and_ClickOnDropdown_Link() {
        driver.navigate().back();
        herokuPage.dropdownLink();

    }

    @And("Select Option1 value form drop down and confirm if its selected or not")
    public void select_option1_from_dropdown() {
        Select objSelect =new Select(driver.findElement(By.id("dropdown")));
        objSelect.selectByValue("1");
        WebElement o = objSelect.getFirstSelectedOption();
        String selectedOption = o.getText();
        System.out.println("Selected element: " + selectedOption);
        String expectedOption="Option 1";
        Assert.assertEquals(selectedOption,expectedOption);


    }


    @And("Navigate back to Home Page and Click on Frames")
    public void naviagate_To_Homepage_and_ClickOnframes_Link() {
        driver.navigate().back();
        herokuPage.framesLink();

    }

    @Then("Verify the Nested Frames and iFrame are presented on the Frames Page")
    public void verify_nested_frame_and_iframe_on_the_page() {
        Assert.assertEquals( driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/a")).isDisplayed(), true);
        Assert.assertEquals( driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/a")).isDisplayed(), true);

    }


}
