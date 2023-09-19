package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage extends  BaseClass{
    WebDriver driver;
    LoginPage loginPage;
    CustomerListPage customerListPage;
    FunctionLibrary functionLibrary;
    DashboardPage dashboardPage;

@BeforeClass
   public void setUp(){
        openBrowser();
        loginPage = new LoginPage(driver);
        loginPage.logIn();
        functionLibrary = new FunctionLibrary(driver);
        customerListPage = new CustomerListPage(driver);
   }
   @Test
   public void viewDashboard(){
       Assertions.assertTrue(dashboardPage.verifyDashboardPage());
   }
   @Test
    public void createCustomerGroups(){


   }
}
