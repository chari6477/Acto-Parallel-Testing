package actoapp.ios.pages;

import actoapp.util.helpers.BaseObject;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ActoNotificationsPopup extends BaseObject{

	@SuppressWarnings("rawtypes")
	public ActoNotificationsPopup(IOSDriver driver)
	{
		super(driver);
	}
	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>Allow_Accessibility_ID</b>.
	 */
	public IOSElement allowBtn(){
		return findWebElementFromPropertyName("Allow_Accessibility_ID", timeout);
	}
	
	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>NotAllow_Accessibility_ID</b>.
	 */
	public IOSElement notAllowBtn(){
		return findWebElementFromPropertyName("NotAllow_Accessibility_ID", timeout);
	}

}
