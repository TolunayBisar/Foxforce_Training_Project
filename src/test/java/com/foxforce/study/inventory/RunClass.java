package com.foxforce.study.inventory;

import com.foxforce.study.basefunctions.BaseClass;
import com.foxforce.study.basefunctions.FunctionLibrary;

import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.dashboard.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunClass extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    FunctionLibrary functionLibrary;

    ProductOptionsPage productOptionsPage;

  ManufacturersPage manufacturersPage;



    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPage = new DashBoardPage(driver);
        functionLibrary = new FunctionLibrary(driver);
        productOptionsPage = new ProductOptionsPage(driver);
manufacturersPage = new ManufacturersPage(driver);


    }

    @Test(priority = 1)
    public void verifyOptionGroupPage() {
        Assert.assertTrue(productOptionsPage.verifyAtLeastOneOptionGroupOnTable());

    }

    @Test (priority = 2)
    public void editProductOption() {
        productOptionsPage.editOptionGroup();
        Assert.assertTrue(productOptionsPage.verifyEditOptionGroup());

    }

    @Test (priority = 3,invocationCount = 3)

    public void addProductOption() {
        Assert.assertEquals(productOptionsPage.addNewOptionGroup(), 2);

    }

    @Test(priority = 4)
    public void deleteProductOption() {
        Assert.assertTrue(productOptionsPage.deleteOptionGroup());
    }

    @Test(priority = 5)
    public void OptionAttributeTab() {
        Assert.assertTrue(productOptionsPage.addNewOptionAttributes()>0);

    }


    @Test(priority = 6)
    public void OptionSetTab() {

        Assert.assertTrue(productOptionsPage.addNewOptionSets());

    }

    @Test(priority = 7)
    public void editManufacture(){

        Assert.assertTrue(manufacturersPage.editManufacture());

    }

    @Test(priority = 8)
    public void deleteManufacture(){

        Assert.assertTrue(manufacturersPage.deleteManufacture());

    }
    @Test(priority = 9)
    public void addManufacture(){

        Assert.assertTrue(manufacturersPage.addManufacture()>=1);

    }


    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
