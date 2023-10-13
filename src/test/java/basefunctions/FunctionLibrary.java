package basefunctions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import cubecartobjects.OptionGroupObject;
import cubecartobjects.OptionGroups;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

     return optionGroupObjects;
    }


    public List<String> readExcelInfo(String file,String sheetName ) {
//        ExcelFileObject excelFileObject = new ExcelFileObject();
//        String file = excelFileObject.getFile();
//        String sheetName= excelFileObject.getSheet();


        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet(sheetName);


        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();// column count
        System.out.println(rowCount);
        System.out.println(cellCount);
        List<String> c = new ArrayList<>();

        for (int row = 0; row < rowCount; row++) {
            XSSFRow rows = sheet.getRow(row);
            for (int column = 0; column < cellCount; column++) {
                XSSFCell columns = rows.getCell(column);

                c.add(columns.getStringCellValue());

            }
            //System.out.println(c);

        }
        //System.out.println(c.size());
        return c;

    }


}
