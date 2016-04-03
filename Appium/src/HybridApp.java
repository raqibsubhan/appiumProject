import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


public class HybridApp 
{
/*There are two approaches to building a hybrid app: 
 * WebView app: The HTML, CSS and JavaScript code base runs in an internal browser (called WebView) 
 * that is wrapped in a NATIVE APP
*/
	@Test
	public void test() throws MalformedURLException 
	{
		File appDirectory = new File("src");
		File app = new File(appDirectory, "hybridApp.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
															// not 'Android Emulator'
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		try {
			Thread.sleep(6000); //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
			}
		
		System.out.println("Current view --->  " + driver.getContext());
		driver.findElement(By.id("com.mmbox.xbrowser.pro:id/search_box")).sendKeys("http://www.google.com");
		driver.findElement(By.id("com.mmbox.xbrowser.pro:id/search_ctrl_btn")).click();
		
		// getContextHandles() returns the amount of views present currently
		Set<String> set = driver.getContextHandles();
		// to switch to a particular view and the names are found from getContextHandles()
		// and Appium can interpret the objects as webview objects rather than Native objects
		
		for (String handle : set)
		{
			System.out.println(handle);
		}
		
		driver.context("WEBVIEW_com.mmbox.xbrowser.pro");
		System.out.println("Current view --->  " + driver.getContext());
		driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("Bangladesh");
		
		
		//To enable WebView debugging, call the static method setWebContentsDebuggingEnabled 
		//on the WebView class.
	}
}
