package com.foxforce.study.order;

import com.foxforce.study.basefunctions.FunctionLibrary;
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

public class ReadOrderInfoList {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public ReadOrderInfoList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public List<List<String>> readOrderInfo() {
        String file = "CustomerInfoFolder/orderName.xlsx";


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
        XSSFSheet sheet = workbook.getSheet("2.Page");


        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(0).getLastCellNum();// column count
//        System.out.println("Row count: "+rowCount);
//        System.out.println("Column count: "+cellCount);
        List<String> c1 = new ArrayList<>();
        List<String> c2 = new ArrayList<>();
        List<List<String>> c = new ArrayList<>();

            XSSFRow row1 = sheet.getRow(0);
            for (int column = 0; column < cellCount; column++) {
                XSSFCell columns = row1.getCell(column);

                c1.add(columns.getStringCellValue());

            }
            //System.out.println("Order Number : "+c1);

        XSSFRow row2 = sheet.getRow(1);
        for (int column = 0; column < cellCount; column++) {
            XSSFCell columns = row2.getCell(column);

            c2.add(columns.getStringCellValue());

        }
        //System.out.println("Customer Name: "+c2);
       c.add(c1);
       c.add(c2);

        //System.out.println("total list : "+c);

        return c;

    }


}




