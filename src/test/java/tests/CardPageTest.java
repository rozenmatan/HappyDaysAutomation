package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import pageobjects.CardPage;
import pageobjects.MainPage;

public class CardPageTest extends BaseTest{

	@BeforeClass
	public void clickOnCaregory() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.clickOnCategory("Success");
	}
	
	@Test
	public void swipeCardUp() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.swipeCardUp();

	}
	
	@Test
	public void swipeCardDown() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.swipeCardDown();

	}
	
	@Test
	public void swipeCardLeft() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.swipeCardLeft();

	}
	
	@Test
	public void swipeCardRight() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.swipeCardRight();

	}
	
	@Test
	public void swipeCardBackAndForth() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.swipeCardBackAndForth();
	}
	
	@Test
	public void clickOnMusicButton() {
		
		CardPage cardPage = new CardPage(driver);
		cardPage.clickOnMusicButton();
		
	}
}
