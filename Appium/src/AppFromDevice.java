import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppFromDevice
{
	@Test
	public void moga() throws MalformedURLException
	{
		/****************CMD COMMANDS*****************/
		//  adb shell pm list packages
		//  adb shell pm path <app package name> (this will generate the path in device)
		//  And to pull from the device location:
		//  adb pull <the generated path>   <destination> 
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "net.one97.paytm");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "net.one97.paytm.AJRMainActivity");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
	}
}
