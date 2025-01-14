package com.foxforce.study.mailinglist;

import com.foxforce.study.basefunctions.BaseClass;
import com.foxforce.study.basefunctions.FunctionLibrary;
import com.foxforce.study.dashboard.DashBoardPage;
import com.foxforce.study.dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
    public void mailingListDashboard() {
        // Test and verify mailing list page
        dashBoardPag.clickOnMailingListLink();
        Assert.assertTrue(mailingList.verifyMailingListDashboard());
    }

    @Test(priority = 2)
    public void filterAndSearchEmail() {
        // Test filter mailing list
        dashBoardPag.clickOnMailingListLink();
        mailingList.filterMailingList();  // Test and verify search email function
        mailingList.searchSubscribersNewsletter();
        Assert.assertTrue(mailingList.verifyNoFoundMessage());
    }

    @Test(priority = 3)
    public void importSubscribers() {
        // Test and verify importsubscribers
        dashBoardPag.clickOnMailingListLink();
        mailingList.importSubscribers();
        Assert.assertTrue(mailingList.verifySuccessfullyImportSubscriber());
    }

    @Test(priority = 5)
    public void exportSubscribers() {
        // Test and verify exportSubscribers
        dashBoardPag.clickOnMailingListLink();
        mailingList.exportSubscribers();
        Assert.assertTrue(mailingList.verifyExportButton());
    }

    @Test(priority = 6)
    public void deleteMailingList() {
        dashBoardPag.clickOnMailingListLink();
        mailingList.deleteEmail();
        Assert.assertTrue(mailingList.verifyEmailSuccessfullyDeletedFromMailingList());
    }

    @AfterClass
    public void close() {
        closeBrowser();
    }
}
