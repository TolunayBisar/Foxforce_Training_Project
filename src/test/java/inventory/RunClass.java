package inventory;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import order.OrderPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunClass extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    FunctionLibrary functionLibrary;

    OrderPage orderPage;


    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickOnOrdersLink();
        orderPage= new OrderPage(driver);
        functionLibrary = new FunctionLibrary(driver);




    }
    @Test
    public void json(){
        functionLibrary.writeJson();

    }



}
