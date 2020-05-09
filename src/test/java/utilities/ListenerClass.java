package utilities;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.android.AndroidDriver;

public class ListenerClass extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult result) {
		Object androidDriverAttrubute = result.getTestContext().getAttribute("AndroidDriver");
		if (androidDriverAttrubute instanceof AndroidDriver) {
			AllureAttachment.captureScreenshot((AndroidDriver) androidDriverAttrubute);
		}

	}
}
