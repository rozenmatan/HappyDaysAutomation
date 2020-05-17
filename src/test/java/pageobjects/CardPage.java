package pageobjects;

import org.testng.AssertJUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CardPage extends CommonElementsAndFunctions{

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
	private MobileElement cardText;
	@AndroidFindBy(id="com.happy.yday:id/imageViewFavorites")
	private MobileElement favortieButton;
	@AndroidFindBy(id="com.happy.yday:id/share_button")
	private MobileElement shareButton;
	@AndroidFindBy(id="com.happy.yday:id/like_button")
	private MobileElement likeButton;
	
	public CardPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getCardText() {
		
		return getText(cardText);
	}
	public void swipeCardUp() {
		
		String text = getCardText();
		swipeByCoordinate(700, 1800, 700, 1200);
		waitForElementToBeFixAtLocation(cardText);
		AssertJUnit.assertEquals(text, getCardText());
	}
	
	public void swipeCardDown() {
		
		String text = getCardText();
		swipeByCoordinate(700, 1200, 700, 1800);
		waitForElementToBeFixAtLocation(cardText);
		AssertJUnit.assertEquals(text, getCardText());
	}
	
	public void swipeCardLeft() {
		
		String text = getCardText();
		swipeByCoordinate(700, 1100, 1200, 1100);
		waitForElementToBeFixAtLocation(cardText);
		AssertJUnit.assertNotSame(text, getCardText());
	}
	
	public void swipeCardRight() {
		
		String text = getCardText();
		swipeByCoordinate(700, 1100, 200, 1100);
		waitForElementToBeFixAtLocation(cardText);
		AssertJUnit.assertNotSame(text, getCardText());
	}
	
	public void swipeCardBackAndForth() {
		
		String text = getCardText();
		swipeBackAndForth(700, 1100, 1200, 1100);
		waitForElementToBeFixAtLocation(cardText);
		AssertJUnit.assertEquals(text, getCardText());
	}
}
