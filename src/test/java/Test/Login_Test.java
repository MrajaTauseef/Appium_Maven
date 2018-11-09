package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Login_Test{
	
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void Launch_Application() throws MalformedURLException
	{
		// *This Will Create Session On Appium Server And Will Launch App*
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("deviceName", "Samsung Galaxy S7");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.appirio.mobile.pheaa.fedloan");                
		capabilities.setCapability("appActivity", "com.pheaa.MainActivity");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.2:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void login() throws Exception
	{
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.widget.EditText[@text='username']")).sendKeys("Tar478");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.widget.EditText[@text='password']")).sendKeys("Test1234");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='SUBMIT']")).click();
			Thread.sleep(10000);	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
