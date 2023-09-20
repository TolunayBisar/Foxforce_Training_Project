package basefunctions;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {
    FunctionLibrary functionLibrary=new FunctionLibrary();
    public void takeScreenShot(String imageName, WebDriver driver) {
        DateTime dateTime = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd-HH:ss");
        String timeStamp = dateTime.toString(formatter);
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String folderName = functionLibrary.readFromConfig("config.properties", "imageFolder");
        File file = new File(folderName + File.separator + imageName + "_" + timeStamp + ".jpg");
        try {
            FileUtils.copyFile(screenShotFile, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
