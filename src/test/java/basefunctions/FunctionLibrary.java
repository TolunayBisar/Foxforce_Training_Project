package basefunctions;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FunctionLibrary {
    public WebDriver driver;
    int timeOut=Integer.parseInt(readFromConfig("config.properties","timeout"));

    public FunctionLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public FunctionLibrary() {
    }
    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void sleep(){
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void sleep(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //below method returns the last 5 digits of a timestamp
    public String timeStamp(){
        long timeStamp=System.currentTimeMillis();
        return (Long.toString(timeStamp).toString().substring(8));
    }


    public String readFromConfig(String fileName, String key){
        Properties properties=new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream=new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value= properties.getProperty(key);
        return value;
    }
    public String generateFakeNames(){
        String fakeName= Faker.instance().name().firstName();
        return fakeName;
    }
    public String generateFakeEmail(){
        String fakeEmail=Faker.instance().internet().emailAddress();
        return fakeEmail;
    }
}
