import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppFromDevice2
{
	@Test
	public void moga() throws IOException
	{
		/****************CMD COMMANDS*****************/
		//  adb shell 
		//	dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'
		//	And copy from mCurrentFocus
		
		Runtime.getRuntime().exec("cmd /c start C:\\appiumstart.bat");
		try {
			Thread.sleep(10000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "net.one97.paytm");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "net.one97.paytm.AJRMainActivity");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		try {
			Thread.sleep(6000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
		
	}
}
