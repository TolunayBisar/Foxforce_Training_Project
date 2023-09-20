package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage extends BaseClass{

    LoginPage loginPage;

    FunctionLibrary functionLibrary;
    DashboardPage dashboardPage;
    CustomerListPage customerListPage;

@BeforeClass
   public void setUp(){
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn();
        dashboardPage = new DashboardPage(driver);
        customerListPage = new CustomerListPage(driver);
        functionLibrary = new FunctionLibrary(driver);

   }
   @Test
   public void viewDashboard(){
       Assert.assertTrue(dashboardPage.verifyDashboardPage());
   }
   @Test
    public void createCustomerGroups(){
    dashboardPage.clickOnCustomersLink();
    customerListPage.addCustomerGroup();
    Assert.assertTrue(customerListPage.verifyCustomerGroupUpdatedMessage());
   }

   @Test
    public void searchCustomer(){
    dashboardPage.clickOnCustomersLink();
    customerListPage.searchCustomer();
    Assert.assertTrue(customerListPage.verifySearchCustomer());


   }
   @AfterClass
    public void tearDown(){
    dashboardPage.logout();

   }
}
