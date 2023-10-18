package inventory;

import basefunctions.FunctionLibrary;
import cubecartobjects.ExcelFileObject;
import dashboard.DashBoardPage;
import order.CustomerInfoExcelList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ManufacturersPage{
    WebDriver driver;
    FunctionLibrary functionLibrary;
    Random random;
    DashBoardPage dashBoardPage;

    CustomerInfoExcelList writeExcel;
    ExcelFileObject excelFileObject;

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
     }

    public boolean  editManufacture(){
        dashBoardPage.clickOnManufactureLink();
        manufactureEditIcons.get(random.nextInt(manufactureEditIcons.size())).click();
        manufactureName.clear();
        manufactureName.sendKeys("Sert");
        manufactureSite.sendKeys("www.sertplas.com.tr");
        submitButton.click();
       if (manufactureNameList.get(0).equals("Sert"))
           System.out.println("edit successfully");
       return true;
    }

    public int deleteManufacture() {
        int beforeDelete=manufactureDeleteIcons.size();
        manufactureDeleteIcons.get(random.nextInt(manufactureDeleteIcons.size())).click();
        driver.switchTo().alert().accept();
        int afterDelete=manufactureDeleteIcons.size();

        return beforeDelete-afterDelete;

    }

    public int addManufacture() {
        addManufactureTab.click();
        int beforeAdd = manufactureEditIcons.size();

        manufactureName.sendKeys("Trendyol");
        manufactureSite.sendKeys("www.trendyol.com.tr");
        submitButton.click();
        int afterAdd = manufactureEditIcons.size();
        return afterAdd-beforeAdd;
    }

}
