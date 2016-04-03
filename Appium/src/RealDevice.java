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


public class RealDevice 
{
	@Test
	public void test() throws MalformedURLException 
	{
		File appDirectory = new File("src");
		File app = new File(appDirectory, "BookMyShow.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
															// not 'Android Emulator'
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		try {
			Thread.sleep(6000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
		driver.findElementById("com.bt.bms:id/btnLogin").click();
		driver.findElementById("com.bt.bms:id/signUp").click();
		int size = driver.findElements(By.className("android.widget.EditText")).size();
		System.out.println(size);
		List<WebElement> list = driver.findElements(By.className("android.widget.EditText"));
		list.get(0).sendKeys("Abdullah");
		list.get(1).sendKeys("Alam");
		list.get(2).sendKeys("Abdullah@yahoo.com");
		list.get(3).sendKeys("Password");
		list.get(4).sendKeys("999999999");
		driver.findElementById("com.bt.bms:id/rightMenu").click();
		driver.findElementById("com.bt.bms:id/dismiss").click();
	}
}
