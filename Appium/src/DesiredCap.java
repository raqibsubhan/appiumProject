import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DesiredCap 
{
	@Before
	public void m() throws IOException
	{
		//From cmd
		//"C:\Program Files (x86)\Appium\node.exe" "C:\Program Files (x86)\Appium\node_modules\appium\bin\appium.js"
		 Runtime.getRuntime().exec("cmd /c start C:\\appiumstart.bat");
	}

	@Test
	public void test() throws MalformedURLException 
	{
		File appDirectory = new File("src");
		File app = new File(appDirectory, "BookMyShow.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		try {
			Thread.sleep(6000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
		driver.findElementById("com.bt.bms:id/btnLogin").click();
//		driver.findElementById("com.bt.bms:id/signUp").click();
//		int size = driver.findElements(By.className("android.widget.EditText")).size();
//		System.out.println(size);
//		List<WebElement> list = driver.findElements(By.className("android.widget.EditText"));
//		list.get(0).sendKeys("Abdullah");
//		list.get(1).sendKeys("Alam");
//		list.get(2).sendKeys("Abdullah@yahoo.com");
//		list.get(3).sendKeys("Password");
//		list.get(4).sendKeys("999999999");
//		driver.findElementById("com.bt.bms:id/rightMenu").click();
//		driver.findElementById("com.bt.bms:id/dismiss").click();
		
		
		
//		driver.findElementById("com.bt.bms:id/btnNoThanks").click();
		try {
			Thread.sleep(15000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
//		driver.findElementById("com.bt.bms:id/dismiss").click();
//		MobileElement x = (MobileElement) driver.findElementByClassName("android.widget.CheckedTextView");
//		x.swipe(SwipeElementDirection.UP, 2000);
		
		System.out.println(driver.isLocked());;
		System.out.println(driver.getContext());
		driver.currentActivity();
//		driver.installApp("");
//		driver.context("");
		driver.closeApp();
	}

}
