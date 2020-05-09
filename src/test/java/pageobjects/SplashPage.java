package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashPage extends BasePage{
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")
	private MobileElement splash;
	
	public SplashPage(AndroidDriver<MobileElement> driver) {
		
		super(driver);
	}
	

	public void moveToMainMenu() {
		tap(splash);
	}
}
