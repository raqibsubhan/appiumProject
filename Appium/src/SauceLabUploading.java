

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SauceLabUploading 
{
	@Test
	public void test() throws MalformedURLException, InterruptedException 
	{
		// curl -u raqibSubhan:4cb51ddb-2b31-494e-a1b1-1111ca9bd73d -X POST -H "Content-Type: application/octet-stream" https://saucelabs.com/rest/v1/storage/raqibSubhan/bookMyShow?overwrite=true --data-binary @/C:\Users\Subhan PC\Downloads\BookMyShow–Movie Tickets Plays_v4.2.3_apkpure.com
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.5.1");
		caps.setCapability("deviceName","Android Emulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","4.3");
		caps.setCapability("platformName","Android");
		caps.setCapability("app", "https://github.com/raqibsubhan/Appium/blob/master/BookMyShow.apk");
		
		AndroidDriver driver=new AndroidDriver(new URL("http://raqibSubhan:4cb51ddb-2b31-494e-a1b1-1111ca9bd73d@ondemand.saucelabs.com:80/wd/hub"),caps);
		driver.findElementById("com.bt.bms:id/btnLogin").click();
		Thread.sleep(8000);

	}
}
