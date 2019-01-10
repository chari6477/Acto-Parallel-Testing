package actoapp.acto.browserstack;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.browserstack.local.Local;
import io.appium.java_client.ios.IOSDriver;

public class BrowserStackTestNGTest {

	private Local l;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IOSDriver setDriver() throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/single.conf.json"));
		JSONObject envs = (JSONObject) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("name", System.getProperty("name"));
		
		
		Map<String, String> envCapabilities = (Map<String, String>) envs.get("iPhone_7");
		Iterator it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			if(capabilities.getCapability(pair.getKey().toString()) == null){
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		String username = System.getenv("BROWSERSTACK_USERNAME");
		if(username == null) {
			username = (String) config.get("user");
		}

		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if(accessKey == null) {
			accessKey = (String) config.get("key");
		}

		String app = System.getenv("BROWSERSTACK_APP_ID");
		if(app != null && !app.isEmpty()) {
			capabilities.setCapability("app", app);
		}

		if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
			l = new Local();
			Map<String, String> options = new HashMap<String, String>();
			options.put("key", accessKey);
			l.start(options);
		}

		IOSDriver driver = new IOSDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);

		return driver;
	}

}
