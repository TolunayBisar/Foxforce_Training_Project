package inventory;

import basefunctions.BaseClass;
import basefunctions.DBConnection;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class test extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPag;
    ReviewPage reviewPage;
    FunctionLibrary functionLibrary;

    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPag = new DashBoardPage(driver);
        reviewPage = new ReviewPage(driver);

    }
    @Test (priority = 1)
    public void addReview() {
        dashBoardPag.clickOnReviewLink();
        reviewPage.addReview();
    }
    @Test(priority = 2)
    public void editReview(){
        dashBoardPag.clickOnReviewLink();
        reviewPage.editProductReview();
    }
    @Test(priority = 3)
    public void deleteReview(){
        dashBoardPag.clickOnReviewLink();
        reviewPage.deleteProductReview();
        Assert.assertTrue(reviewPage.verifyDeleteMessage());
    }
    @Test(priority = 4)
    public void searchReview(){
        dashBoardPag.clickOnReviewLink();
        reviewPage.searchOfReview();
        Assert.assertTrue(reviewPage.verifySearchReview());
    }
}
