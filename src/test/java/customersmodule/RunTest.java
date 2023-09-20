package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunTest extends BaseClass{

    LoginPage loginPage;

    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    CustomerListPage customerListPage;

@BeforeClass
   public void setUp(){
        openBrowser("http://cubecartuat.unitedcoder.com/admin_tu8sml.php");
        loginPage = new LoginPage(driver);
        loginPage.logIn("testautomation1","automation123!");
        dashBoardPage = new DashBoardPage(driver);
        customerListPage = new CustomerListPage(driver);
        functionLibrary = new FunctionLibrary(driver);

   }
   @Test
   public void viewDashboard(){
       Assert.assertTrue(dashBoardPage.verifyDashboardPage());
   }
   @Test
    public void createCustomerGroups(){
        dashBoardPage.setCustomerListLink();
        customerListPage.addCustomerGroup();
        Assert.assertTrue(customerListPage.verifyCustomerGroupUpdatedMessage());
   }

   @Test
    public void searchCustomer(){
        dashBoardPage.setCustomerListLink();
        customerListPage.searchCustomer();
        Assert.assertTrue(customerListPage.verifySearchCustomer());
   }

//   @Test
//   public void deleteGroup(){
//    dashBoardPage.setCustomerListLink();
//    customerListPage.deleteCustomerGroup();
//   // Assert.assertTrue(customerListPage.verifyDeleteCustomerGroup());
//   }

   @Test
   public void GDPRReport(){
        dashBoardPage.setCustomerListLink();
        customerListPage.createReport();
        Assert.assertTrue(customerListPage.verifyCreateReport());
   }
//   @AfterClass
//    public void tearDown(){
//        dashBoardPage.logout();
//        closeBrowser();
//
//   }
}
