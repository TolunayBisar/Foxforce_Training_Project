package com.foxforce.study.order;

import com.foxforce.study.basefunctions.BaseClass;

import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.dashboard.LoginPage;


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
        dashBoardPage.clickOnOrdersLink();
        orderPage= new OrderPage(driver);




    }

    @Test(priority = 2)
    public void orderListVerify(){

        Assert.assertTrue(orderPage.verifyOrder());


    }
    @Test(priority = 3)
    public void verifyCheckUncheckLick(){
        orderPage.verifyCheckUncheckAllClick();
        Assert.assertTrue(orderPage.verifyCheckUncheckAllClick());

    }
    @Test(priority = 1,invocationCount = 6)
    public void createOrder(){
        orderPage.createOrder();
        orderPage.verifyOrderCreated();
        Assert.assertTrue(orderPage.verifyOrderCreated());

    }
    @Test(priority = 4)
    public void searchOrder(){
        orderPage.createOrderList();
        orderPage.searchOrder();
        //orderPage.verifySearchOrder();
        Assert.assertTrue(orderPage.verifySearchOrder());
    }

    @Test(priority = 5)
    public void editOrder(){
        orderPage.editOrder();
        orderPage.verifyEdit();
        Assert.assertTrue(orderPage.verifyEdit());
    }

@Test(priority = 6)
public void deleteOrder(){
        orderPage.createOrderList();

        orderPage.deleteOrderWithIcon();
        Assert.assertTrue( (orderPage.verifyDelete())); //(orderPage.deleteOrderWithIcon()==1)&&
}

@Test(priority = 7)
public void deleteAndPrintWithDropdown(){
        orderPage.dropdownOnOrderPage();
        Assert.assertTrue(orderPage.verifyDeleteWithDropdown());
}







  @AfterClass
  public void tearDown(){

     closeBrowser();
  }





}
