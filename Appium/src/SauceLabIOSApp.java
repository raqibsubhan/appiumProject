
 import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
	
public class SauceLabIOSApp
{
	public static void main(String[] args) throws MalformedURLException
	{
		// By default some apps come with device but some apps are specific to users
		// cURL: is a computer software project providing a library and command-line tool for transferring data using various protocols
		DesiredCapabilities dc = DesiredCapabilities.iphone();
		dc.setCapability("platformName", "iOS");
		dc.setCapability("platformVersion", "7.1");dc.setCapability("appiumVersion", "1.3.4");
		dc.setCapability("deviceName", "iPhone Simulator");
		dc.setCapability("browserName", "");
		dc.setCapability("app", "sauce-storage:UICatalog.app.zip");
		IOSDriver driver=new IOSDriver(new URL("http://raqibSubhan:4cb51ddb-2b31-494e-a1b1-1111ca9bd73d@ondemand.saucelabs.com:80/wd/hub"),dc);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.quit();
		
		}

} 
