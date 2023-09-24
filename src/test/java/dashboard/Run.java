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
}