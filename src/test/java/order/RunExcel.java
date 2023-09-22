package order;

import basefunctions.BaseClass;
import cubecartobjects.OrderObject;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunExcel extends BaseClass {

    LoginPage loginPage;
    DashBoardPage dashBoardPage;


    ExcelObject excelObject;


    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.setOrderLink();

        excelObject= new ExcelObject(driver);




    }
    @Test
    public void createOrder(){

        excelObject.createOrder();


    }





}
