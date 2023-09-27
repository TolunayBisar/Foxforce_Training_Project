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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CustomerInfoExcelList extends BaseClass {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public CustomerInfoExcelList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }


    public void writeToExcel(String fileName,String folderName, String sheetName, List<String> content) {

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
        int rowSize = content.size();
        for (int rowNumber = 0; rowNumber < rowSize; rowNumber++) {
            XSSFRow row = sheet.createRow(rowNumber);
            String[] rowContent = content.get(rowNumber).split(",");//{testautomation1,automationtest123!}
            // =[testautomation1,automationtest123!]
            int totalCell = rowContent.length;
            for (int cellNumber = 0; cellNumber < totalCell; cellNumber++) {
                XSSFCell cell = row.createCell(cellNumber);
                cell.setCellValue(rowContent[cellNumber]);
            }

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
        WebElement customerList = baseClass.driver.findElement(By.linkText("Customer List"));
        customerList.click();

        List<String> customerInfoList = new ArrayList<>();
        List<WebElement> customerNames = baseClass.driver.findElements(By.xpath("//i[@class='fa fa-user registered']/parent::td/following-sibling::td[1]/a"));
        for (int i = 0; i < customerNames.size(); i++) {
            customerInfoList.add(customerNames.get(i).getText());
            //String[] s = userInfo.get(0).split(",");
            //System.out.println(Arrays.toString(s));
            CustomerInfoExcelList writeToExcelFile = new CustomerInfoExcelList(baseClass.driver);
            String fileName = "CustomerInfoFolder/CustomerName.xlsx";
            String folderName="CustomerInfoFolder";
            writeToExcelFile.writeToExcel(fileName, folderName,"1.Page", customerInfoList);}



            }

    }



