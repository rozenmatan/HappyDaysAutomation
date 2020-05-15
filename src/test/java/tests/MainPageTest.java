package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;

import pageobjects.MainPage;
public class MainPageTest extends BaseTest{

	@Test
	public void checkTitle() {
		
		MainPage mainPage = new MainPage(driver);
		String res = mainPage.getTitle();
		AssertJUnit.assertEquals("Happy Days", res);
	}
	
	@Test
	public void clickOnMusicButton() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnMusicButton();
		
	}
	
	@Test
	public void verifyCategoriesExistence() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyCategoriesExistence();
	}
	
	@Test(dependsOnMethods = "verifyCategoriesExistence")
	public void verifyCategoriesFuncuallty() {
		
		List<String> categorieNames = new ArrayList<String>();
		categorieNames.add("Success");
		categorieNames.add("Peaceful thoughts");
		categorieNames.add("Happiness");
		categorieNames.add("Romantic");
		categorieNames.add("Fitness Workout");
		categorieNames.add("Feeling Lonely");
		categorieNames.add("Work & Study");
		categorieNames.add("Meditation");
		categorieNames.add("Self Confidence");
		categorieNames.add("Anxiety");
		categorieNames.add("Stay Healthy");
		categorieNames.add("Friendship");
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyCategoriesFuncuallty(categorieNames);
	}
	
	@Test
	public void verifyExitPopUpIsShowing() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyExitPopUpIsShowing();
	}
	
	@Test
	public void verifyExitPopUpFuncuallty() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyExitPopUpFuncuallty();
	}
	
	@Test
	public void verifyButtomMenuIsShowing() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyButtomMenuIsShowing();
	}
	
	@Test
	public void verifyButtomMenuFancuallty() {
		
		MainPage mainPage = new MainPage(driver);
		mainPage.verifyButtomMenuFancuallty("Favorites", "Happy Days");
		
	}
	
}
