package inventory;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import basefunctions.TestDataHolder;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunTestForPromotionalCodesPage extends BaseClass {
    TestDataHolder testDataHolder;
    LoginPage loginPage;
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    PromotionalCodesPage promotionalCodesPage;

    @BeforeClass
    public void setUp(){
        testDataHolder = new TestDataHolder();
        openBrowser(testDataHolder.url);
        loginPage = new LoginPage(driver);
        loginPage.logIn(testDataHolder.userName,testDataHolder.passWord);
        functionLibrary = new FunctionLibrary(driver);
        dashBoardPage = new DashBoardPage(driver);
        promotionalCodesPage = new PromotionalCodesPage(driver);

    }
    @Test(priority = 1)
    public void verifyPromotionalCodes(){
        dashBoardPage.clickOnPromotionalCodes();
        Assert.assertTrue(promotionalCodesPage.viewAtLeaseOnePromotionalCodes());
    }
    @Test(priority = 2)
    public void createPromotionalCode(){
        dashBoardPage.clickOnPromotionalCodes();
        promotionalCodesPage.createPromotionalCode();
        Assert.assertTrue(promotionalCodesPage.verifyPromotionalCodeAddedMessage());
    }
    @Test(priority = 3)
    public void editPromotionalCode(){

    }

}
