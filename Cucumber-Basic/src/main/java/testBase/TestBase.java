package testBase;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReadConfigFile;


public class TestBase {

	public  static WebDriver driver;
	public static Logger Log;
	

		
	
	
	public static WebDriver selectBrowser(String browser) {
	    System.setProperty("webdriver.chrome.driver","./drivers//chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    //intialize logger
	    Log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		return driver;
	}
	public String getProperty(String s)
	{
		ReadConfigFile r=new ReadConfigFile();
		return r.read().getProperty(s);
	}
	
	public void takeScreenShot(WebDriver driver) 
	{
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
	     File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
         File DestFile=new File("./screenshots/"+new Date().getTime()+".png");
         try {
         FileUtils.copyFile(SrcFile, DestFile);
         }catch(IOException ie)
         {
        	 ie.printStackTrace();
         }
	}

	
	
}
