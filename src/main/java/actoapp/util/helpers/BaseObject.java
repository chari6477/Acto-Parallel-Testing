package actoapp.util.helpers;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class BaseObject {

	public PropertyReader properties= new PropertyReader();

	public long timeout = 25;

	@SuppressWarnings("rawtypes")
	public IOSDriver driver = null;

	@SuppressWarnings("rawtypes")
	public BaseObject(IOSDriver driver)
	{
		this.driver = driver;
	}

	public By by_From_PropertyFile(String propertyName)
	{
		System.out.println("\nAction: Find Element\t\tName: "+propertyName+"\t\tValue: "+String.format(properties.readProperty(propertyName)));
		if(propertyName.contains("_ID"))
		{
			return MobileBy.AccessibilityId(properties.readProperty(propertyName));
		}
		else if(propertyName.contains("_XPATH"))
		{
			return MobileBy.xpath(properties.readProperty(propertyName));
		}
		else
		{
			System.err.println("Please provide valid property name");
		}

		return null;
	}

	public IOSElement findElement(String locator)
	{
		return (IOSElement) driver.findElement(by_From_PropertyFile(locator));
	}


	public void click(String locator)
	{	
		findElement(locator).click();
	}

	public void clickAction(String locator , long timeout)
	{	
		System.out.println("\nAction: Click\t\t\tIOSElement: Element Found in Previous Step");
		findWebElementFromPropertyName(locator,timeout).click();
	}



	public String getAttribute(String locator, String attribute)
	{
		return findElement(locator).getAttribute(attribute);
	}

	public String getCssValue(String locator, String cssValue)
	{
		return findElement(locator).getCssValue(cssValue);
	}

	public void type(String locator, Keys keysss[])
	{

		findElement(locator).clear();

		int i=0;
		for (Keys key : keysss) 
		{
			if(i > 0)
			{
				findElement(locator).sendKeys(",");
			}
			System.out.println("\nAction: Text Entry\t\tText: "+key);
			findElement(locator).sendKeys(key);
			i++;
		}
	}

	public void type(String locator, long timeout, String text)
	{
		System.out.println("\nAction: Text Entry\t\tText: "+text);
		findWebElementFromPropertyName(locator,timeout).clear();
		findWebElementFromPropertyName(locator,timeout).sendKeys(text);
	}

	public String verifyElementClass(String locator)
	{
		return findWebElementFromPropertyName(locator,timeout).getAttribute("class");
	}

	public boolean verifyElementIsDisplayed(String locator)
	{
		return findWebElementFromPropertyName(locator,timeout).isDisplayed();
	}

	public boolean verifyElementIsEnabled(String locator)
	{
		return findWebElementFromPropertyName(locator,timeout).isEnabled();
	}

	public boolean verifyTextInElement(String locator, String text)
	{
		return findWebElementFromPropertyName(locator,timeout).getText().contains(text);
	}


	public IOSElement findWebElementFromPropertyName(String locator, long timeout){
		return waitForElementToBePresent(by_From_PropertyFile(locator),timeout);
	}

	public void jsScrollIntoView(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public IOSElement waitForElementToBePresent(By locatorType, long timeout)
	{
		return (IOSElement) new WebDriverWait(driver, timeout).until(
				ExpectedConditions.elementToBeClickable(locatorType));
	}

	public void threadWait(int seconds){
		try {
			System.out.println("\nAction: Wait\t\t\tDuration: "+seconds+" seconds");
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterText(String locator, long timeout, String textToEnter){
		System.out.println("\nAction: Text Entry\t\tText: "+textToEnter);

		IOSElement TextField = findWebElementFromPropertyName(locator,timeout);
		try {
			TextField.clear();
		} catch (Exception e) {
			System.out.println("Unable to Clear");
		}
		TextField.sendKeys(textToEnter);
	}

	public void scrollMobileScreenDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}

	public void scrollUsingDirectionAndElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}
}
