package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	private AndroidDriver<MobileElement> driver;
	private TouchAction action;
	private int timeOutInSeconds = 30;
	
	public BasePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		action = new TouchAction(driver);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);

	}
	
	protected void tap(MobileElement el) {
		
		action.tap(PointOption.point(el.getLocation().x,el.getLocation().y)).perform();
	}
	protected void tap(int x, int y) {
		
		action.tap(PointOption.point(x,y)).perform();
	}
	
	protected void swipeByCoordinate(int fromX,int fromY,int toX,int toY) {
		action.press(PointOption.point(fromX,fromY)).moveTo(PointOption.point(toX,toY)).release().perform();
		
	}
	
	protected void turnOffData() {
		
		if(driver.getConnection().isAirplaneModeEnabled() == false)
			driver.toggleAirplaneMode();
	}
	
	protected void turnOnData() {
		
		if(driver.getConnection().isAirplaneModeEnabled())
			driver.toggleAirplaneMode();
	}
	
	protected void scrollDown() {
		
		swipeByCoordinate(15, 2400, 15, 1800);
	}
	
	protected void scrollUp() {
		
		swipeByCoordinate(15, 1800, 15, 2400);
	}
	
	protected void back() {
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}
	
	protected void waitForElementToBeVisible(MobileElement el) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	protected void waitForElementToInvisible(MobileElement el) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(el));
	}
}
