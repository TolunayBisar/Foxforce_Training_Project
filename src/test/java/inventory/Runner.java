package inventory;

import basefunctions.*;
import cubecartobjects.ProductObjectClass;
import dashboard.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;

/**
 * @author : ahamu
 * @created : 2023-10-17,2:55 p.m.
 * @Email : alimhamut.job@gmail.com
 **/
public class Runner extends BaseClass {
    LoginPage loginPage;
    ProductsPage productsPage;
    DBConnection dbConnection;
    Connection connection;
    VerifySQLScript sqlScripts;
    DataClass dataClass;
    ProductObjectClass productObjectClass;
    @BeforeClass
    public void setUp() {
        openBrowser("http://localhost/admin_Jsjjam.php");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productObjectClass = new ProductObjectClass();
        dbConnection = new DBConnection();
        sqlScripts = new VerifySQLScript();
        dataClass = new DataClass();
        connection=dbConnection.connectToDataBaseServer(dataClass.getUrl(), dataClass.getPort(), dataClass.getUsername(), dataClass.getPassword(), dataClass.getDefaultDB(), ConnectionType.MYSQL);
    }
    @Test(priority = 1, dataProvider = "loginData")
    public void loginTest(String userName, String password) {
        loginPage.logIn(userName, password);
    }
    @DataProvider
    public Object[][] loginData() {
        Object[][] credentials = new Object[][]{
                {"admin", "123456789"}
        };
        return credentials;
    }
    @Test(priority = 2)
    public void addProduct(){
        Assert.assertTrue(productsPage.addProduct());
    }
    @Test(priority = 3)
    public void verifyProductInDatabase(){
        boolean isProductExist=sqlScripts.getProductInfo(connection,productObjectClass.getProductName());
        Assert.assertTrue(isProductExist);
    }
}
