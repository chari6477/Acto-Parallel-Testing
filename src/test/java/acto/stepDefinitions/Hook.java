package acto.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import actoapp.acto.browserstack.DriverSetup;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook{

	public Scenario scenario ;

	@Before
	public void testSetup(Scenario scenario)
	{
		this.scenario = scenario;
		System.setProperty("name", scenario.getName());
		System.out.println("Test Envoronment setup.");
		System.out.println("------------------------------------------------------------");
		System.out.println("Executing Scenario is : "+ scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) throws Exception
	{
		scenario.write("Scenario is executed...");
		System.out.println("Scenario is ended...");
		if(scenario.isFailed())
		{
			System.err.println(scenario.getName() +    ": Scenario is failed.");
			try {
				scenario.embed(((TakesScreenshot)DriverSetup.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			}catch(Exception e) {}

			try{
				DriverSetup.driver.quit();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			DriverSetup.driver = null;
		}

		System.out.println("------------------------------------------------------------");
	}
	
}
