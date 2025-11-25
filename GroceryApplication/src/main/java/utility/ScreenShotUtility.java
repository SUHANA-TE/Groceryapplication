package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {//string failed testcase will store method name of failed test case

				TakesScreenshot scrShot = (TakesScreenshot) driver;//interface used to capture screenshot/giving driver out of bracket is called as casting
				File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//to store captured screenshot temporarily

				String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

				File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory
				if (!f1.exists()) {

			f1.mkdirs();
				}
				String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
				// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
				// ".png";

			File finalDestination = new File(destination);
				FileHandler.copy(screenShot, finalDestination);
			}

}
