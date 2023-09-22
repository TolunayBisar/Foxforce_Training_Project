package order;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerInfoList extends BaseClass {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public ReadCustomerInfoList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }
    public List<String> readCustomerInfo() {
        String file = "CustomerInfoFolder/CustomerName.xlsx";



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
        XSSFSheet sheet = workbook.getSheet("1.Page");


        int rowCount = sheet.getLastRowNum();
        int cellCount=sheet.getRow(0).getLastCellNum();// column count
        System.out.println(rowCount);
        System.out.println(cellCount);
        List<String> c = new ArrayList<>();

        for (int row =0; row<=rowCount;row++){
            XSSFRow rows = sheet.getRow(row);
            for (int column = 0; column<cellCount;column++){
                XSSFCell columns = rows.getCell(column);



                        c.add(columns.getStringCellValue());



            }System.out.println(c);


        }
        System.out.println(c.size());
        return c;

    }



}


