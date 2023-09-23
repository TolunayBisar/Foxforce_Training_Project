package dashboard;


import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import mailinglist.MailingList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Run extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPag;
    MailingList mailingList;

    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        dashBoardPag = new DashBoardPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        mailingList = new MailingList(driver);
    }

    @Test(priority = 1, dataProvider = "loginData")
    public void invalidLoginTest(String userName, String password) {
        loginPage.logIn(userName, password);
        Assert.assertTrue(loginPage.veriFyinvalid());
    }

    @DataProvider
    public Object[][] loginData() {
        int[] i = new int[]{1, 2, 34, 8};
        Object[][] credentials = new Object[][]{
                {"testautomation3", "automation123"},
                {"testautomat4", "automation123!"},
        };
        return credentials;
    }

    @Test(priority = 2, dataProvider = "validloginData")
    public void validLoginTest(String userName, String password) {
        loginPage.loginAndLogOut(userName, password);
        Assert.assertTrue(loginPage.veriFyCubeCartLogo());
    }

    @DataProvider
    public Object[][] validloginData() {
        int[] y = new int[]{4, 3, 30, 5};
        Object[][] credentials2 = new Object[][]{
                {"testautomation1", "automation123!"},
                {"testautomation2", "automation123!"},
        };
        return credentials2;
    }

    @Test(priority = 3)
    public void loginTest() {
        loginPage.logIn("testautomation1", "automation123!");
        Assert.assertTrue(dashBoardPag.verifyDashboardPage());
    }
}