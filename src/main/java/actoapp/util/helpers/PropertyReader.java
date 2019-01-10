package actoapp.util.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	Properties properties = new Properties();

	public PropertyReader()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		try
		{
			FileInputStream inputStream = new FileInputStream("src/main/resources/automation.properties");

			properties.load(inputStream);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String readProperty(String property)
	{
		return properties.getProperty(property);
	}
	
}
