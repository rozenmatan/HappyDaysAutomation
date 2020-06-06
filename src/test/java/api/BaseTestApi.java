package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BaseTestApi {

	@Test
	public void checkResponseStatus() {

		given().when().get("https://happyday-da368.firebaseio.com/levels.json").then().statusCode(200);
	}

	@Test
	public void checkContentType() {

		given().when().get("https://happyday-da368.firebaseio.com/levels.json").then().contentType(ContentType.JSON);
	}

	@Test
	public void checkResponseTime() {

		given().when().get("https://happyday-da368.firebaseio.com/levels.json").then().time(lessThan(2L), TimeUnit.SECONDS);
	}
}
