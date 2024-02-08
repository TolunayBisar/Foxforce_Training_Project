package com.foxforce.study.regression.uitest;

import com.foxforce.study.basefunctions.TestDataHolder;
import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.dashboard.LoginPage;
import com.foxforce.study.inventory.ExportCatalogPage;
import com.foxforce.study.inventory.TestResultListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
@Listeners(TestResultListener.class)

public class ExportCatalogTestRunner {
    WebDriver driver;
    TestDataHolder tdh=new TestDataHolder();
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    ExportCatalogPage exportCatalogPage;

    @BeforeClass
    public void setUp(ITestContext context){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        HashMap<String,Object> chromePrefs=new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        String downloadFilepath= System.getProperty("user.dir");
        chromePrefs.put("download.default directory", downloadFilepath);
        options.setExperimentalOption("prefs",chromePrefs);
        options.setCapability (CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver=new ChromeDriver(options);
        driver.get(tdh.url);
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        loginPage.logIn(tdh.userName, tdh.passWord);
        dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.verifyDashboardPage();
        exportCatalogPage=new ExportCatalogPage(driver);
        context.setAttribute("driver",driver);
    }
    @Test
    public void exportCatalog(){
        dashBoardPage.clickOnExportCatalog();
        exportCatalogPage.exportCatalog("50");
        Assert.assertTrue(exportCatalogPage.verifyExportSuccessful("cubecart_20231013_1.csv"));
    }
    @AfterClass
    public void tearDown(){
        dashBoardPage.logout();
        driver.close();
        driver.quit();
    }
}
