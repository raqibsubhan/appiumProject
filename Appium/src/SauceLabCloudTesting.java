import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SauceLabCloudTesting 
{
	@Test
	public void test() throws MalformedURLException, InterruptedException 
	{
		// Cloud testing: codes could be executed in virtual machine which is not in one's control for limited resources/ampha structure.
		// Companies have hosted in their servers which we could use to execute our code from our local machine in their servers
		// DesiredCapabilities: we provide all our requirements to the class or configure setting and correct vm are identified in 
		// saucelab server
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.5.0");
		caps.setCapability("deviceName","iPhone 6");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion","9.2");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");
		
		// Sauce lab connectivity url has to be provided
		IOSDriver driver=new IOSDriver(new URL("http://raqibSubhan:4cb51ddb-2b31-494e-a1b1-1111ca9bd73d@ondemand.saucelabs.com:80/wd/hub"),caps);
		
		// To run in simulator in local mac OS
		//IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );

		driver.get("http://google.com");

		Thread.sleep(8000);

	}
}
