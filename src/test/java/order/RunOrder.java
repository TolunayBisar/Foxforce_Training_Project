package order;

import basefunctions.BaseClass;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunOrder extends BaseClass {
    LoginPage loginPage;


    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);

    }
    @Test(priority = 1, dataProvider = "loginData")
    public void Login(String userName, String password) {
        loginPage.loginAndLogOut(userName, password);
        Assert.assertTrue(loginPage.veriFyCubeCartLogo());
    }

    @DataProvider
    public Object[][] loginData() {
        Object[][] credential = new Object[][]{
                {"testautomation1", "automation123!"},

        };
        return credential;
    }
}
