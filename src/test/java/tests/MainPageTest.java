package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import pageobjects.MainPage;
public class MainPageTest extends BaseTest{

	@Test
	public void checkTitle() {
		
		MainPage mainPage = new MainPage(driver);
		String res = mainPage.getTitle();
		AssertJUnit.assertEquals("Happy Days1", res);
	}
	
	@Test
	public void clickOnMusicButton() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnMusicButton();
		
	}
	
	
	
	
}
