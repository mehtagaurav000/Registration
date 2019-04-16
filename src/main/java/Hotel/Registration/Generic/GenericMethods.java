package Hotel.Registration.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GenericMethods {
	
	public WebDriver driver;
	
	private static GenericMethods gm;
	
	
	//For singleton class--to restrict object creation
	private GenericMethods()
	{
		
	}
	//singleton class--to provide the object when required
	public static GenericMethods co()
	{
		if(gm==null)
		{
			gm=new GenericMethods();
		}
		return gm;
	}
	
	
	public void fn_launchBrowser(String browserName) throws Exception
	{
		try
		{
		if(browserName.equalsIgnoreCase("FF"))
		{
		System.setProperty("webdriver.gecko.driver", "D:\\Himani\\Registration\\Drivers\\geckodriver.exe");
		DesiredCapabilities dc=DesiredCapabilities.firefox();
		dc.setCapability("marionette", true);
		
		// capabilities.setCapability("marionette", true);
         //FirefoxProfile profile = new FirefoxProfile();
         //profile.setPreference("browser.link.open_newwindow.restriction", 1);
         //profile.setPreference("browser.link.open_newwindow", 2);
         //capabilities.setCapability(FirefoxDriver.PROFILE, profile);
         driver= new FirefoxDriver(dc);
		}	
		else if(browserName.equalsIgnoreCase("CH"))
		{
			
		}
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	

}
