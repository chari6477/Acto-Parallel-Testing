package actoapp.acto.browserstack;

import io.appium.java_client.ios.IOSDriver;

public class DriverSetup {

	@SuppressWarnings("rawtypes")
	public static IOSDriver driver;
	
	BrowserStackTestNGTest setter = new BrowserStackTestNGTest();

	public DriverSetup()
	{
		initialize();
	}

	private void createNewDriverInstance()
	{
		try {
			driver = setter.setDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeApplication()
	{
		try {
			driver.closeApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver = null;
	}

	public void destroyDriver()
	{	
		try{
			driver.quit();
			System.out.println("Driver instance is closed.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		driver = null;
	}

	public void initialize()
	{
		if(driver == null)
		{
			createNewDriverInstance();
		}
	}
}
