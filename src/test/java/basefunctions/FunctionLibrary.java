package basefunctions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import cubecartobjects.OptionGroupObject;
import cubecartobjects.OptionGroups;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<OptionGroupObject> optionGroupObjects =new ArrayList<>();
        optionGroupObjects.add(optionGroupObject1);
        optionGroupObjects.add(optionGroupObject2);
        optionGroupObjects.add(optionGroupObject3);
        optionGroupObjects.add(optionGroupObject4);


        ObjectMapper objectMapper = new ObjectMapper();
        OptionGroups s = new OptionGroups(optionGroupObjects);
        String optionGroupInfo = null;

        try {
            optionGroupInfo = objectMapper.writeValueAsString(s);// convert Object value to

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // String with this method. then we will write this String value to Jason file.


        try {
            FileUtils.writeStringToFile(new File("jsonFile/OptionGroupInfo.json"),optionGroupInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<OptionGroupObject> readJson(){



        ObjectMapper objectMapper = new ObjectMapper();
        OptionGroups optionGroups=null;

        try {
            optionGroups=objectMapper.readValue(new File("jsonFile/OptionGroupInfo.json"), OptionGroups.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<OptionGroupObject> optionGroupObjects = optionGroups.getOptionGroups();


        /*ObjectMapper objectMapper = new ObjectMapper();
        Users users=null;
        try {
            users = objectMapper.readValue(new File("jsonFile/loginUser.json"), Users.class);// readValue ask
            // us to give class type here. format is: User.class. Means - parse Json file object to Users class.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<LoginUser> loginUsers = users.getLoginUsers();
        openBrowser();
        LoginPage loginPage = new LoginPage(driver);
        for (LoginUser eachUser: loginUsers){
        loginPage.login(eachUser.getUserName(), eachUser.getPassword());
        Logout logout =new Logout();
        logout.logout();}
        driver.close();
        driver.quit();
    }
}
   */
     return optionGroupObjects;
    }



}
