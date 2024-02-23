package org.bdd.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeroKuPage {

    private WebDriver driver;

    // Locators
    private By ABTestingLinkLocator = By.xpath("//a[text()='A/B Testing']");
    private By dropdownLinkLocator = By.xpath("//*[@id='content']/ul/li[11]/a");
    private By frameLocator = By.xpath("//a[text()='Frames']");
    public By nestedFrameLocator = By.xpath("//*[@id='content']/div/ul/li[1]/a");
    public By iFrameLocator = By.xpath("//*[@id='content']/div/ul/li[1]/a");




    // Constructor
    public HeroKuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods

    public void clickLoginButton() {
        WebElement ABTestingButton = driver.findElement(ABTestingLinkLocator);
        ABTestingButton.click();
    }

    public void dropdownLink() {
        WebElement dropdownLink = driver.findElement(dropdownLinkLocator);
        dropdownLink.click();
    }

    public void framesLink() {
        WebElement framesLink = driver.findElement(frameLocator);
        framesLink.click();
    }



}
