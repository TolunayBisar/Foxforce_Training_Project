package basefunctions;

import com.github.javafaker.Faker;
import cubecartobjects.OptionGroupObject;
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

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void sleep() {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //below method returns the last 5 digits of a timestamp
    public String timeStamp() {
        long timeStamp = System.currentTimeMillis();
        return (Long.toString(timeStamp).toString().substring(8));
    }


    public String readFromConfig(String fileName, String key) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value = properties.getProperty(key);
        return value;
    }

    public String generateFakeNames() {
        String fakeName = Faker.instance().name().firstName();
        return fakeName;
    }

    public String generateFakeEmail() {
        String fakeEmail = Faker.instance().internet().emailAddress();
        return fakeEmail;
    }

    public String readTextFile(String path) {
        StringBuilder content = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {fileInputStream = new FileInputStream(path);
            int data;
            while ((data = fileInputStream.read()) != -1) {content.append((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null
            ) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return content.toString();
    }

    // Serialization
    public void writeJson(){
        OptionGroupObject optionGroupObject1=new OptionGroupObject("Dish","A Quality");
        OptionGroupObject optionGroupObject2=new OptionGroupObject("Salmon Fish","Import from Norway ");
        OptionGroupObject optionGroupObject3=new OptionGroupObject("Apple","Fresh");
        OptionGroupObject optionGroupObject4=new OptionGroupObject("Carpet","AA Quality");


    }


    /*  CustomerObject customerObject1 = new CustomerObject("Aynur","Alim","Mrs",
                "0896754",true);

        CustomerObject customerObject2 = new CustomerObject("Abdugeni","Adil","Mr",
                "0896754",false);

        ObjectMapper objectMapper = new ObjectMapper(); // Serialization with this Class ObjectMapper

        String customer = null;
        try {
            customer = objectMapper.writeValueAsString(customerObject1);// convert Object value to
            // String with this method. then we will write this String value to Jason file.

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.writeStringToFile(new File("jsonFile//CustomerInfoTeam2.json"),customer);
            // creat file:  File file = new File(pathname)---> use FileUtils.writeStingToFile method to write content.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/

}
