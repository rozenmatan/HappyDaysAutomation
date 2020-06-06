package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pageobjects.SplashPage;

public class BaseTest {

	AndroidDriver<MobileElement> driver;

	
	@BeforeSuite
	public void setup(ITestContext testContext) throws MalformedURLException {
		
		

		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		   capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		   capabilities.setCapability("deviceName", "Google Pixel 2 XL");
		   capabilities.setCapability("appPackage", "com.happy.yday");
		   capabilities.setCapability("appActivity","com.happy.yday.MainActivity");
		   capabilities.setCapability(MobileCapabilityType.UDID, "712KPKN1244077");
		   capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		   capabilities.setCapability("AppiumserviceReset", false); 
		   capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		   capabilities.setCapability("newCommandTimeout", 120);
		   driver = new AndroidDriver<MobileElement>(new URL("http://matanrozen.ddns.net:4723/wd/hub"), capabilities);
		   testContext.setAttribute("AndroidDriver", this.driver);		   
		   



	}
	@BeforeSuite(dependsOnMethods = "setup")
	public void moveToMainMenu() {
		
		SplashPage splashPage = new SplashPage(driver);
		splashPage.moveToMainMenu();
	}
	@AfterMethod
	public void failedTest(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

	}
	
	@AfterSuite
	public void quit() {
		
		driver.closeApp();
	}
}
