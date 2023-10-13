package testrunners;

import basefunctions.BaseClass;
import basefunctions.TestDataHolder;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import inventory.ImportCatalogPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImportCatalogTestRunner extends BaseClass {
    TestDataHolder tdh=new TestDataHolder();
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    ImportCatalogPage importCatalogPage;
    @BeforeClass
    public void setUp(){
        openBrowser(tdh.url);
        loginPage=new LoginPage(driver);
        loginPage.logIn(tdh.userName, tdh.passWord);
        dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.verifyDashboardPage();
        importCatalogPage=new ImportCatalogPage(driver);
    }
    @Test
    public void importCatalogTest(){
        String filePath="/Users/user/IdeaProjects/foxforce-aliyeidris/TestData/catalog1.csv";
        dashBoardPage.clickOnImportCatalog();
        importCatalogPage.importCatalog(filePath);
        Assert.assertTrue(importCatalogPage.verifyImportSuccess());
    }
    @Test
    public void removeImportedCatalogs(){
        dashBoardPage.clickOnImportCatalog();
        Assert.assertTrue(importCatalogPage.removePreviousImports());
    }
    @Test(enabled = false)
    public void importCatalogWithRobot(){
        String filePath="/Users/user/IdeaProjects/foxforce-aliyeidris/TestData/catalog1.csv";
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
