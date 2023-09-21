package order;

import basefunctions.BaseClass;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunOrder extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    OrderPage orderPage;


    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        orderPage= new OrderPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPage.setOrderLink();

    }
    @Test
    public void orderListVerify(){
        orderPage.verifyOrder();


    }
    @Test
    public void verifyCheckUncheckLick(){
        orderPage.verifyCheckUncheckAllClick();

    }
    @Test
    public void billingAddress(){
        orderPage.createOrder();

    }





    @AfterClass
    public void tearDown(){
        closeBrowser();
    }





}
