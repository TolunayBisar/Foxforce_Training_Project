package order;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class OrderInfoExcelList extends BaseClass {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public OrderInfoExcelList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }


    public void writeOrderToExcel(String fileName,String folderName, String sheetName,LinkedHashMap<String,String> content) {

        String projectPath = System.getProperty("user.dir");// this is fix value, there is case sensitive.
        String folderLocation = projectPath + File.separator + folderName;// folder location
        // /Users/tolunaybisar/IdeaProjects/CubeCartApplication202303/files/myfile.txt
        File folder = new File(folderLocation);// create one file in folder location.
        if (!folder.exists()) {
            folder.mkdir();  // the method for creating folder
            System.out.println("folder is created");
        }
//        String finalFileLocation = folderLocation + File.separator + fileName + extention;
//        File file = new File(finalFileLocation);

        File file = new File(fileName); // create file first
        FileOutputStream outputStream = null; //FileOutputStream outputStream = new FileOutputStream(file)
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        List<String> rowContent= new ArrayList<>();
        List<String> rowContent1= new ArrayList<>();
        Set<String> keySet = content.keySet();
        for (String key: keySet) {
            rowContent.add(key);
            String value = content.get(key);
            rowContent1.add(value);

        }
        int rowNumber=0;

            XSSFRow row = sheet.createRow(rowNumber);

            for (int cellNumber = 0; cellNumber < rowContent.size(); cellNumber++) {
                XSSFCell cell = row.createCell(cellNumber);
                cell.setCellValue(rowContent.get(cellNumber));
            }


        int rowNumber1=1;
        XSSFRow row1 = sheet.createRow(rowNumber1);


        for (int cellNumber = 0; cellNumber < rowContent1.size(); cellNumber++) {
            XSSFCell cell = row1.createCell(cellNumber);
            cell.setCellValue(rowContent1.get(cellNumber));
        }

        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass();
        baseClass.openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        LoginPage login = new LoginPage(baseClass.driver);
        login.logIn("testautomation1", "automation123!");

        DashBoardPage dashBoardPage = new DashBoardPage(baseClass.driver);
        dashBoardPage.clickOnOrdersLink();
        LinkedHashMap<String,String> orderList = new LinkedHashMap<>();
        List<WebElement> orderNumbers= baseClass.driver.findElements(By.xpath
                ("//tbody//td[2]/a[@title='Edit']"));
        List<WebElement> customers= baseClass.driver.findElements(By.xpath
                ("//tbody//td[4]/a"));
        for (int i=0;i< orderNumbers.size();i++){
            orderList.put(orderNumbers.get(i).getText(),customers.get(i).getText());
            OrderInfoExcelList writeOrderToExcel = new OrderInfoExcelList(baseClass.driver);
            String fileName = "CustomerInfoFolder/orderName.xlsx";
            String folderName="CustomerInfoFolder";
            writeOrderToExcel.writeOrderToExcel(fileName, folderName,"2.Page", orderList);}
    }
}
