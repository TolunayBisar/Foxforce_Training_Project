package com.foxforce.study.regression.uitest;

import com.foxforce.study.basefunctions.BaseClass;
import com.foxforce.study.basefunctions.TestDataHolder;
import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.cubecartobjects.CustomerGroupObject;
import com.foxforce.study.cubecartobjects.CustomerObject;
import com.foxforce.study.customersmodule.CustomerListPage;
import com.foxforce.study.dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CustomerGroupTestRunner extends BaseClass {
    TestDataHolder testDataHolder;
    LoginPage loginPage;
    DashBoardPage dashBoardPag;
    CustomerListPage customerListPage;


    @BeforeClass
    public void setUp() {
        testDataHolder = new TestDataHolder();
        openBrowser(testDataHolder.url);
        loginPage = new LoginPage(driver);
        loginPage.logIn(testDataHolder.userName, testDataHolder.passWord);
        dashBoardPag = new DashBoardPage(driver);
        customerListPage = new CustomerListPage(driver);
    }
    @Test(priority = 1)
    public void viewAtLeaseOneCustomer(){
        dashBoardPag.clickOnCustomerListLink();
        Assert.assertTrue(customerListPage.viewAtLeaseOneCustomer());
    }

    @Test(priority = 2)
    public void createCustomerGroups(){
        CustomerGroupObject customerGroupObject = new CustomerGroupObject(
                "New Team","Welcome!!");
        dashBoardPag.clickOnCustomerListLink();
        customerListPage.addCustomerGroup(customerGroupObject);
        Assert.assertTrue(customerListPage.verifyCustomerGroupUpdatedMessage());
    }

    @Test(priority = 3)
    public void GDPRReport(){
        CustomerObject customerObject = new CustomerObject();
        customerObject.setEmail("james@gmail.com");
        dashBoardPag.clickOnCustomerListLink();
        customerListPage.createReport(customerObject);
        Assert.assertTrue(customerListPage.verifyCreateReport());
    }

    @Test(priority = 4)
    public void searchCustomer(){
        dashBoardPag.clickOnCustomerListLink();
        customerListPage.searchCustomer();
        Assert.assertTrue(customerListPage.verifySearchCustomer());
    }
}