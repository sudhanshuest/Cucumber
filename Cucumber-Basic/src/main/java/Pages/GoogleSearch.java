package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {
	
	public GoogleSearch(WebDriver rdriver){
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="(//cite)[1]")
	WebElement result;
	
	public String firstUrl()
	{
		return result.getText();
	}
}
