package acto.testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/functionalTests"},
		glue = {"acto.stepDefinitions"},
		plugin = {"json:target/cucumber.json" , "html:target/site/cucumber-pretty"},
		tags ={"@Functional"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
