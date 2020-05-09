package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage{

	@AndroidFindBy(id="com.happy.yday:id/title")
	private MobileElement title;
	@AndroidFindBy(id="com.happy.yday:id/imageViewSound")
	private MobileElement musicButton;
	
	public MainPage(AndroidDriver<MobileElement> driver) {
		
		super(driver);
	}
	
	public String getTitle() {
		
		return title.getText();
	}
	
	public void clickOnMusicButton() {
		
		tap(musicButton);		
	}
}
