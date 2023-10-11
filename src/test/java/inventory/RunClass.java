package inventory;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import order.OrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunClass extends BaseClass {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    FunctionLibrary functionLibrary;

    OrderPage orderPage;
    ProductOptionsPage productOptionsPage;


    @BeforeClass
    public void setUp() {
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1", "automation123!");
        dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickOnProductOptionLink();
        functionLibrary = new FunctionLibrary(driver);
     productOptionsPage = new ProductOptionsPage(driver);



    }
@Test
    public void verifyOptionGroupPage(){

        productOptionsPage.verifyAtLeastOneOptionGroupOnTable();



    }
 @Test
    public void editProductOption(){


        productOptionsPage.editOptionGroup();


 }
 @Test

 public void addProductOption(){

     productOptionsPage.addNewOptionGroup();

 }

    @Test

    public void deleteProductOption(){

        productOptionsPage.deleteOptionGroup();

    }


    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }



}
