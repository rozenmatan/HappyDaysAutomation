package pageobjects;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CommonElementsAndFunctions extends BasePage{

	AndroidDriver<MobileElement> driver;
	
	@AndroidFindBy(id="com.happy.yday:id/textLikeCount")
	MobileElement likeCount;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout")
	List <MobileElement> categories;
	
	
	
	public CommonElementsAndFunctions(AndroidDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void clickOnCategory(String choosenCategory) {
		
		while(true) {
			
			for(int i = 1;i <= categories.size();i++) {
				try {
					MobileElement categorie = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+i+"]/android.widget.RelativeLayout/android.widget.TextView"));
					String categorieName = categorie.getText();
					if(categorieName.equals(choosenCategory)) {
						tap(categorie);
						waitForElementToBeVisible(likeCount);
						return;
					}
				}catch (NoSuchElementException e) {
					// TODO: handle exception
				}

			}
			scrollDown();
		}
	}
	
	public void scrollToTop() {
		
		while(true) {
			try {
				MobileElement categorie = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView"));
				String categorieName = categorie.getText();
				if(categorieName.equals("Success")) 
					return;
			}catch (NoSuchElementException e) {
				// TODO: handle exception
			}
			scrollUp();
		}

	}
	

}
