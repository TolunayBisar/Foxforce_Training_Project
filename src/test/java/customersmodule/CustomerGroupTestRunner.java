package customersmodule;


import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import cubecartobjects.CustomerGroupObject;
import cubecartobjects.CustomerObject;
import dashboard.DashBoardPage;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CustomerGroupTestRunner extends BaseClass {
    LoginPage loginPage;
    FunctionLibrary functionLibrary= new FunctionLibrary();
    DashBoardPage dashBoardPag;
    CustomerListPage customerListPage;
    String url = functionLibrary.readFromConfig("config.properties","url");
    String userName = functionLibrary.readFromConfig("config.properties","username1");
    String passWord = functionLibrary.readFromConfig("config.properties","password");


    @BeforeClass
    public void setUp() {
        openBrowser(url);
        loginPage = new LoginPage(driver);
        loginPage.logIn(userName,passWord);
        dashBoardPag = new DashBoardPage(driver);
        customerListPage = new CustomerListPage(driver);
    }
    @Test(priority = 1)
    public void viewAtLeaseOneCustomer(){
        dashBoardPag.setCustomerListLink();
        Assert.assertTrue(customerListPage.viewAtLeaseOneCustomer());
    }

    @Test(priority = 2)
    public void createCustomerGroups(){
        CustomerGroupObject customerGroupObject = new CustomerGroupObject("New Team","Welcome!!");
        dashBoardPag.setCustomerListLink();
        customerListPage.addCustomerGroup(customerGroupObject);
        Assert.assertTrue(customerListPage.verifyCustomerGroupUpdatedMessage());
    }

    @Test(priority = 3)
    public void GDPRReport(){
        CustomerObject customerObject = new CustomerObject();
        customerObject.setEmail("james@gmail.com");
        dashBoardPag.setCustomerListLink();
        customerListPage.createReport(customerObject);
        Assert.assertTrue(customerListPage.verifyCreateReport());
    }
}