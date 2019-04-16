package Hotel.Registration;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Hotel.Registration.Generic.GenericMethods;



public class RegistrationTest {
	
	@Test
	public void fn_launchingHotelogixDotCom() throws Exception
	{
		try
		{
		GenericMethods.co().fn_launchBrowser("FF");
		GenericMethods.co().driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		GenericMethods.co().driver.get("http://www.hotelogix.com/");
		System.out.println("My name is Himani");
		System.out.println("My name is Himani1");
		System.out.println("Hey AGAIN");
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public void fn_hotelRegistration()
	{
		
	}

}
