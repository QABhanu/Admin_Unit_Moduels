package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.DriverPage;

public class DriverUtils extends DriverPage {

	public static String captureScreenshot(String name) {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File file = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")+"\\Admin_Unit_Moduels\\Unit_Admin\\ScreenShorts\\"+name+".png";
 
		try {
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}

//	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir")+"\\Admin_Unit_Moduels\\Unit_Admin\\ScreenShorts\\google.png");
//	}

}
