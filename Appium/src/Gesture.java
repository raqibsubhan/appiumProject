
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Gesture 
{
	@Test
	public void test() throws MalformedURLException 
	{
		File appDirectory = new File("src");
		File app = new File(appDirectory, "apiDemos.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//AppiumDriver was implemented by AndroidDriver and IosDriver
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		try {
			Thread.sleep(6000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
	
		System.out.println(driver.getContext());
		List<WebElement> list = driver.findElements(By.className("android.widget.TextView"));
		TouchAction tc = new TouchAction(driver);
		tc.tap(list.get(2)).perform();
		list = driver.findElements(By.className("android.widget.TextView"));
		tc.longPress(list.get(2)).perform();
		
	}
}