package utility_package;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static String screenshots(WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="./screenshot/"+System.currentTimeMillis()+".jpg";
		File dst =new File(path);
		FileHandler.copy(src, dst);
		return path;
	}
	
	
}
