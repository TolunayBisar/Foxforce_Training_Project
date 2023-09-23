package mailinglist;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestForMailing extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPag;
    MailingList mailingList;
    FunctionLibrary functionLibrary;

    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        dashBoardPag = new DashBoardPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        mailingList = new MailingList(driver);
    }

    @Test(priority = 1)
    public void mailingListdashboard() {
        // test and verify mailing list page
        dashBoardPag.clickOnMailingListLink();
        Assert.assertTrue(mailingList.veriFyMailingListDashboard());
    }

    @Test(priority = 2)
    public void filterAndSearchEmail() {
        // test filter mailing list
        dashBoardPag.clickOnMailingListLink();
        mailingList.filterMailingList();
        // test and verify search email function
        mailingList.searchSubscribersNewsletter();
        Assert.assertTrue(mailingList.veriFyNofoundMessage());
    }

    @Test(priority = 3)
    public void importSubscribers() {
        // test and verify importsubscribers
        dashBoardPag.clickOnMailingListLink();
        mailingList.importSubscribers();
    }

    @Test(priority = 5)
    public void exportSubscribers() {
        // test and verify exportSubscribers
        dashBoardPag.clickOnMailingListLink();
        mailingList.exportSubscribers();
        Assert.assertTrue(mailingList.veriFyExportButton());
    }

    @Test(priority = 6)
    public void deleteMailingList() {
        dashBoardPag.clickOnMailingListLink();
        mailingList.deleteEmail();
        Assert.assertTrue(mailingList.verifySuccess());
    }

}
