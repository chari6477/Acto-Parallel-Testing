package actoapp.ios.pages;

import actoapp.util.helpers.BaseObject;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Login_Page extends BaseObject{
	
	@SuppressWarnings("rawtypes")
	public Login_Page(IOSDriver driver)
	{
		super(driver);
	}
	
	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>userName_TextField_XPATH</b>.
	 */
	public IOSElement usernameTextFld(){
		return findWebElementFromPropertyName("userName_TextField_XPATH", timeout);
	}

	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>pwd_TextField_XPATH</b>.
	 */
	public IOSElement passwordTextFld(){
		return findWebElementFromPropertyName("pwd_TextField_XPATH", timeout);
	}

	/**
	 * This method creates IOSElement object based on property given.
	 * @return IOSElement for the property named <b>SignInBtn_Accessibility_ID</b>.
	 */
	public IOSElement signInBtn(){
		return findWebElementFromPropertyName("SignInBtn_Accessibility_ID", timeout);
	}


}
