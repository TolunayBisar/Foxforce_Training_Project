package com.foxforce.study.regression.uitest;

import com.foxforce.study.basefunctions.BaseClass;
import com.foxforce.study.basefunctions.TestDataHolder;
import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.dashboard.LoginPage;
import com.foxforce.study.inventory.ImportCatalogPage;
import com.foxforce.study.inventory.TestResultListener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestResultListener.class)
public class ImportCatalogTestRunner extends BaseClass {
    TestDataHolder tdh=new TestDataHolder();
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    ImportCatalogPage importCatalogPage;
    @BeforeClass
    public void setUp(ITestContext context){
        openBrowser(tdh.url);
        loginPage=new LoginPage(driver);
        loginPage.logIn(tdh.userName, tdh.passWord);
        dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.verifyDashboardPage();
        importCatalogPage=new ImportCatalogPage(driver);
        context.setAttribute("driver",driver);
    }
    @Test
    public void importCatalogTest(){
        String filePath="/Users/tolunaybisar/IdeaProjects/foxforce-tolunay/TestData/catalog1.csv";
        dashBoardPage.clickOnImportCatalog();
        importCatalogPage.importCatalog(filePath);
        Assert.assertTrue(importCatalogPage.verifyImportSuccess());
    }
    @Test()
    public void removeImportedCatalogs(){
        dashBoardPage.clickOnImportCatalog();
        Assert.assertTrue(importCatalogPage.removePreviousImports());
    }
    @Test()
    public void importCatalogWithRobot(){
        String filePath="/Users/tolunaybisar/IdeaProjects/foxforce-tolunay/TestData/catalog1.csv";
        dashBoardPage.clickOnImportCatalog();
        importCatalogPage.importCatalogDetail(filePath);
        Assert.assertTrue(importCatalogPage.verifyImportSuccess());
    }
    @AfterClass
    public void tearDown(){
        dashBoardPage.logout();
        closeBrowser();
    }

}
