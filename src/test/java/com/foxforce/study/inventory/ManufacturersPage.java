package com.foxforce.study.inventory;

import com.foxforce.study.basefunctions.FunctionLibrary;
import com.foxforce.study.cubecartobjects.ExcelFileObject;
import com.foxforce.study.cubecartobjects.ManufactureObject;
import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.order.CustomerInfoExcelList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ManufacturersPage{
    WebDriver driver;
    FunctionLibrary functionLibrary;
    Random random;
    DashBoardPage dashBoardPage;

    CustomerInfoExcelList writeExcel;
    ExcelFileObject excelFileObject;
    ManufactureObject manufactureObject;

    @FindAll(@FindBy(css = ".fa.fa-pencil-square-o"))
    List<WebElement> manufactureEditIcons;
@FindBy(id = "manu_name")
WebElement manufactureName;

    @FindBy(id = "manu_site")
    WebElement manufactureSite;

@FindBy(className = "submit")
WebElement submitButton;

@FindAll(@FindBy(xpath = "//div[@id='manufacturers']//tbody//td[1]/a[1]"))
List<WebElement> manufactureNameList;
    @FindAll(@FindBy(css = ".fa.fa-trash"))
    List<WebElement> manufactureDeleteIcons;



    @FindBy(xpath = "//a[text()='Add Manufacturer']")
    WebElement addManufactureTab;

    @FindBy(xpath = "//div[@class='pagination']/span/strong")
    WebElement numberOfQty;

    public ManufacturersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver) ;
        dashBoardPage= new DashBoardPage(driver);
        random = new Random();
        writeExcel = new CustomerInfoExcelList(driver);
        excelFileObject = new ExcelFileObject();
        manufactureObject = new ManufactureObject();
     }

    public boolean  editManufacture(){

        List<String> ManufactureList = Arrays.asList(
                functionLibrary.generateFakeManufacture(), functionLibrary.generateFakeManufactureURL(),
                functionLibrary.generateFakeManufacture(), functionLibrary.generateFakeManufactureURL(),
                functionLibrary.generateFakeManufacture(), functionLibrary.generateFakeManufactureURL(),
                functionLibrary.generateFakeManufacture(), functionLibrary.generateFakeManufactureURL());
        writeExcel.writeToExcel("ManufactureListFolder/ManufactureList.xlsx", "ManufactureListFolder", "group1", ManufactureList);

        functionLibrary.sleep(1);
       // ExcelFileObject excelFileObject = new ExcelFileObject("ManufactureListFolder/ManufactureList.xlsx", "group1");

        dashBoardPage.clickOnManufactureLink();
        manufactureEditIcons.get(random.nextInt(manufactureEditIcons.size())).click();
        manufactureName.clear();
       // int i= random.nextInt(functionLibrary.readExcelInfo(excelFileObject.getFile(),excelFileObject.getSheet()).size());
        excelFileObject.setFile("ManufactureListFolder/ManufactureList.xlsx");
        excelFileObject.setSheet("group1");
        manufactureName.sendKeys(functionLibrary.readExcelInfo(excelFileObject.getFile(),
                excelFileObject.getSheet()).get(0));
        manufactureSite.clear();
        manufactureSite.sendKeys(functionLibrary.readExcelInfo(excelFileObject.getFile(),
                excelFileObject.getSheet()).get(1));
        submitButton.click();
       if (manufactureNameList.get(0).getText().contains(functionLibrary.readExcelInfo(excelFileObject.getFile(),
               excelFileObject.getSheet()).toString()));
           System.out.println("edit successfully");
       return true;
    }

    public boolean deleteManufacture() {
        dashBoardPage.clickOnManufactureLink();
        boolean deleted = false;
        List<String> beforeDeleteName = new ArrayList<>();
        List<String> afterDeleteName = new ArrayList<>();
      for (WebElement beforeDeleteLocate:manufactureNameList){
          beforeDeleteName.add(beforeDeleteLocate.getText());
      }
        System.out.println(beforeDeleteName);
        manufactureDeleteIcons.get(random.nextInt(manufactureDeleteIcons.size())).click();
        driver.switchTo().alert().accept();
        for (WebElement afterDeleteLocate:manufactureNameList){
            afterDeleteName.add(afterDeleteLocate.getText());
        }
        System.out.println(afterDeleteName);
        if (!(beforeDeleteName.contains(afterDeleteName))){
            deleted = true;
        }


      return deleted;
    }

    public int addManufacture() {
        dashBoardPage.clickOnManufactureLink();
        String beforeAdd = numberOfQty.getText();
        addManufactureTab.click();

        manufactureObject.setManufacture(functionLibrary.generateFakeManufacture());
        manufactureName.sendKeys(manufactureObject.getManufacture());
        manufactureObject.setManufactureURL(functionLibrary.generateFakeManufactureURL());
        manufactureSite.sendKeys( manufactureObject.getManufactureURL());
        submitButton.click();
        String afterAdd = numberOfQty.getText();
        return Integer.parseInt(afterAdd)-Integer.parseInt(beforeAdd);
    }

}
