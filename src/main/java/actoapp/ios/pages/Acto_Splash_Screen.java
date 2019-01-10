package actoapp.ios.pages;

import actoapp.util.helpers.BaseObject;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Acto_Splash_Screen extends BaseObject{

	@SuppressWarnings("rawtypes")
	public Acto_Splash_Screen(IOSDriver driver)
	{
		super(driver);
	}
	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>LogIn_Accessibility_ID</b>.
	 */
	public IOSElement logInBtn(){
		return findWebElementFromPropertyName("LogIn_Accessibility_ID", timeout);
	}

	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>TakeATour_Accessibility_ID</b>.
	 */
	public IOSElement takeAtourBtn(){
		return findWebElementFromPropertyName("TakeATour_Accessibility_ID", timeout);
	}


	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>TryADemo_Accessibility_ID</b>.
	 */
	public IOSElement tryAdemoBtn(){
		return findWebElementFromPropertyName("TryADemo_Accessibility_ID", timeout);
	}
}
