package inventory;

import basefunctions.FunctionLibrary;
import cubecartobjects.ExcelFileObject;
import cubecartobjects.ManufactureObject;
import dashboard.DashBoardPage;
import order.CustomerInfoExcelList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        excelFileObject.setFile("ManufactureListFolder/ManufactureList.xlsx");
        excelFileObject.setSheet("group1");
        functionLibrary.sleep(1);
       // ExcelFileObject excelFileObject = new ExcelFileObject("ManufactureListFolder/ManufactureList.xlsx", "group1");

        dashBoardPage.clickOnManufactureLink();
        manufactureEditIcons.get(random.nextInt(manufactureEditIcons.size())).click();
        manufactureName.clear();
        int i= random.nextInt(functionLibrary.readExcelInfo(excelFileObject.getFile(),excelFileObject.getSheet()).size());
        manufactureName.sendKeys(functionLibrary.readExcelInfo(excelFileObject.getFile(),
                excelFileObject.getSheet()).get(i));
        manufactureSite.clear();
        manufactureSite.sendKeys(functionLibrary.readExcelInfo(excelFileObject.getFile(),
                excelFileObject.getSheet()).get(i+1));
        submitButton.click();
       if (manufactureNameList.get(0).getText().contains(functionLibrary.readExcelInfo(excelFileObject.getFile(),
               excelFileObject.getSheet()).toString()));
           System.out.println("edit successfully");
       return true;
    }

    public int deleteManufacture() {
        dashBoardPage.clickOnManufactureLink();
        int beforeDelete=manufactureDeleteIcons.size();
        manufactureDeleteIcons.get(random.nextInt(manufactureDeleteIcons.size())).click();
        driver.switchTo().alert().accept();
        int afterDelete=manufactureDeleteIcons.size();

        return beforeDelete-afterDelete;

    }

    public int addManufacture() {
        dashBoardPage.clickOnManufactureLink();
        addManufactureTab.click();
        int beforeAdd = manufactureEditIcons.size();
        manufactureObject.setManufacture(functionLibrary.generateFakeManufacture());
        manufactureName.sendKeys(manufactureObject.getManufacture());
        manufactureObject.setManufactureURL(functionLibrary.generateFakeManufactureURL());
        manufactureSite.sendKeys( manufactureObject.getManufactureURL());
        submitButton.click();
        int afterAdd = manufactureEditIcons.size();
        return afterAdd-beforeAdd;
    }

}
