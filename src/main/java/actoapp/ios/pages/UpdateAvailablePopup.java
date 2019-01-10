package actoapp.ios.pages;

import actoapp.util.helpers.BaseObject;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class UpdateAvailablePopup extends BaseObject{

	@SuppressWarnings("rawtypes")
	public UpdateAvailablePopup(IOSDriver driver)
	{
		super(driver);
	}
	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>Update_Accessibility_ID</b>.
	 */
	public IOSElement updateBtn(){
		return findWebElementFromPropertyName("Update_Accessibility_ID", timeout);
	}

	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>NotNow_Accessibility_ID</b>.
	 */
	public IOSElement notNowBtn(){
		return findWebElementFromPropertyName("NotNow_Accessibility_ID", timeout);
	}

}
