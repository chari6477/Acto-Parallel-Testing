package acto.stepDefinitions;

import org.testng.Assert;

import actoapp.acto.browserstack.DriverSetup;
import actoapp.ios.pages.Login_Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_StepDefinition extends DriverSetup{


	Login_Page lp = new Login_Page(driver);

	@Given("^User is on \"([^\"]*)\" page$")
	public void user_is_on_page(String arg1) throws Throwable {
		Assert.assertTrue(lp.findWebElementFromPropertyName(arg1+"_Accessibility_ID", lp.timeout).isDisplayed());
	}

	@When("^User clicks \"([^\"]*)\" button$")
	public void user_clicks_button(String arg1) throws Throwable {
		lp.clickAction(arg1+"_Accessibility_ID", lp.timeout);
	}

	@When("^User clicks update \"([^\"]*)\" button$")
	public void user_clicks_update_button(String arg1) throws Throwable {
		try {
			lp.clickAction(arg1+"_Accessibility_ID", lp.timeout);
		}catch(Exception e)
		{
			System.err.println("Update popup is not displayed.");
		}
	}

	@Then("^Verify user is on \"([^\"]*)\" page$")
	public void verify_user_is_on_page(String arg1) throws Throwable {
		Assert.assertTrue(lp.findWebElementFromPropertyName(arg1+"_Accessibility_ID", lp.timeout).isDisplayed());
	}

	@Then("^Verify user is on \"([^\"]*)\" update page$")
	public void verify_user_is_on_update_page(String arg1) throws Throwable {
		try {
			Assert.assertTrue(lp.findWebElementFromPropertyName(arg1+"_Accessibility_ID", lp.timeout).isDisplayed());
		}catch(Exception e)
		{
			System.err.println("Update popup is not displayed.");
		}
	}

	@When("^User enter \"([^\"]*)\" in the text field \"([^\"]*)\"$")
	public void user_enter_in_the_text_field(String arg1, String arg2) throws Throwable {
		lp.type(arg2+"_TextField_XPATH", lp.timeout, arg1);
	}

	@Given("^I close the application$")
	public void i_close_the_application() throws Throwable {
		closeApplication();
	}

	@Given("^I quit the application$")
	public void i_quit_the_application() throws Throwable {
		destroyDriver();
	}
}
