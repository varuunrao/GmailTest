package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameWorkUtils {
	
	public static String takeScreenshot(WebDriver driver) throws IOException {		
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHmmssSSS");
		TakesScreenshot ts = (TakesScreenshot)driver;		
		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\target\\Screenshots\\img_name"+format.format(new Date())+".png";		
		File destinationFile = new File(destinationPath);
		FileUtils.copyFile(Screenshot, destinationFile);
		
		return destinationPath;		
	}
}
