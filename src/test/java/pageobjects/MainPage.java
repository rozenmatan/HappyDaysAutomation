package pageobjects;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends CommonElementsAndFunctions{

	@AndroidFindBy(id="com.happy.yday:id/title")
	private MobileElement title;
	@AndroidFindBy(id="android:id/message")
	private MobileElement exitPopUp;
	@AndroidFindBy(id="android:id/button2")
	private MobileElement noButtonExitPopUp;
	@AndroidFindBy(id="android:id/button1")
	private MobileElement yesButtonExitPopUp;
	@AndroidFindBy(id="com.happy.yday:id/nav_view")
	private MobileElement buttomMenu;
	@AndroidFindBy(id="com.happy.yday:id/navigation_favorites")
	private MobileElement favoritesButton;
	@AndroidFindBy(id="com.happy.yday:id/navigation_home")
	private MobileElement moodButton;
	
	
	
	public MainPage(AndroidDriver<MobileElement> driver) {
		
		super(driver);
	}
	
	public String getTitle() {
		
		return getText(title);
	}
	
	public void verifyCategoriesExistence() {
		
		Set<String> categorieNames = new HashSet<String>();
		
		while(categorieNames.size() < 12) {
			
			for(int i = 1;i <= categories.size();i++) {
				try {
					MobileElement categorie = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]/android.widget.RelativeLayout/android.widget.TextView"));
					waitForElementToBeFixAtLocation(categorie);
					String categorieName = categorie.getText();
					categorieNames.add(categorieName);
				}catch (NoSuchElementException e) {
					// TODO: handle exception
				}

			}
			scrollDown();
		}
		scrollToTop();
	}
	
	public void verifyCategoriesFuncuallty(List<String> categoriesNames) {
		
		for(int i = 0;i < categoriesNames.size();i++) {
			
			clickOnCategory(categoriesNames.get(i));
			back();
			waitForElementToBeVisible(title);
			waitForElementToBeVisible(categories.get(0));
			
		}
	}
	
	public void verifyExitPopUpIsShowing() {
		
		back();
		waitForElementToBeVisible(exitPopUp);
		back();
		waitForElementToBeVisible(title);
		waitForElementToBeVisible(categories.get(0));
	}
	
	public void verifyExitPopUpFuncuallty() {
		
		back();
		waitForElementToBeVisible(exitPopUp);
		waitForElementToBeVisible(yesButtonExitPopUp);
		tap(noButtonExitPopUp);
		waitForElementToBeVisible(title);
		waitForElementToBeVisible(categories.get(0));
		
	}
	
	public void verifyButtomMenuIsShowing() {
		
		waitForElementToBeVisible(buttomMenu);
	}
	
	public void verifyButtomMenuFancuallty(String favoritesText,String mainText) {
		
		tap(favoritesButton);
		waitForTextToBePresentOnElement(title,favoritesText);
		tap(moodButton);
		waitForTextToBePresentOnElement(title,mainText);
	}
	
}
