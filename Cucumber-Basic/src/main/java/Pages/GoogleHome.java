package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHome {
	WebDriver ldriver;
	
	public GoogleHome(WebDriver rdriver){
	 PageFactory.initElements(rdriver, this);
	 ldriver=rdriver;	
	}
	
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(xpath="(//input[@name='btnK'])[2]")
	WebElement btnOk;
	
	//Search in google
	public GoogleSearch searchName(String Url)
	  {
		System.out.println("chk"+Url);
		searchBox.sendKeys(Url);
		searchBox.sendKeys(Keys.ENTER);
		//btnOk.click();
		  return new GoogleSearch(ldriver);
		  
	  }
}
