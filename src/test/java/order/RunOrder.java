package order;

import basefunctions.BaseClass;

import dashboard.DashBoardPage;
import dashboard.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class RunOrder extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;

    OrderPage orderPage;


    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.setOrderLink();
        orderPage= new OrderPage(driver);




    }
    @Test
    public void orderListVerify(){

        Assert.assertTrue(orderPage.verifyOrder());


    }
    @Test
    public void verifyCheckUncheckLick(){
        orderPage.verifyCheckUncheckAllClick();
        Assert.assertTrue(orderPage.verifyCheckUncheckAllClick());

    }
    @Test
    public void createOrder(){
        orderPage.createOrder();
        orderPage.verifyOrderCreated();
        Assert.assertTrue(orderPage.verifyOrderCreated());

    }





    @AfterClass
    public void tearDown(){

        closeBrowser();
    }





}
