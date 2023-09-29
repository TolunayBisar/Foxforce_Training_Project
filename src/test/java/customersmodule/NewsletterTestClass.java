package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewsletterTestClass extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPag;
    NewslettersPage newslettersPage;
    FunctionLibrary functionLibrary;
    @BeforeClass
    public void setUp(){
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        dashBoardPag = new DashBoardPage(driver);
        newslettersPage = new NewslettersPage(driver);
        functionLibrary = new FunctionLibrary();
        loginPage.logIn(functionLibrary.readFromConfig("config.properties","username1"),
                functionLibrary.readFromConfig("config.properties","password"));
    }
    @Test(priority = 0)
    public void createNewsletterTest(){
        newslettersPage.createDefaultNewsletter();
        Assert.assertTrue(newslettersPage.verifyNewsletterSuccessfullyCreated());
    }
    @Test(priority = 1)
    public void editNewsletterTest(){
        newslettersPage.editNewsletter();
        newslettersPage.verifyNewsletterSuccessfullyEdit();
    }
    @Test(priority = 2)
    public void deleteNewsletterTest(){
        newslettersPage.deleteNewsletter();
        newslettersPage.verifyNewsletterSuccessfullyDeleted();
    }
//    @Test(priority = 3)
//    public void sendNewsletter(){
//        newslettersPage.sendNewsletter();
//        newslettersPage.verifyNewsletterSuccessfullySent();
//    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
