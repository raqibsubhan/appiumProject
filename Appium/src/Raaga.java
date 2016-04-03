import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Raaga 
{
	@Test
	public void moga() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		try {
			Thread.sleep(6000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
	}
}
