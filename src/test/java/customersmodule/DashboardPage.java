package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    BaseClass basePage = new BaseClass();
    @FindBy(css = "#tab_dashboard a")
    WebElement dashboardLink;
    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Products")
    WebElement productsLink;

    @FindBy(css = ".fa.fa-sign-out")
    WebElement logoutLink;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }
    public boolean verifyDashboardPage() {
        functionLibrary.waitForElementPresent(dashboardLink);
        if (dashboardLink.isDisplayed() && dashboardLink.getText().contains("Dashboard")) {
            System.out.println("Dashboard page opened...");
            return true;
        } else {
            System.out.println("Dashboard page failed to open...");
            return false;
        }

    }
    @FindAll(
            @FindBy(xpath = "//*[@id=\"customer-list\"]/child::table[last()]/tbody/tr"))
    List<WebElement> customersList ;
    public boolean viewAtLeaseOneCustomer() {
        if (customersList.size() >= 1) {
            System.out.println("See at least one customer");
            return true;
        } else {
            System.out.println("See at least nul customer");
            return false;
        }
    }

    public void clickOnCustomersLink() {
        functionLibrary.waitForElementPresent(customerListLink);
        customerListLink.click();
    }
    public void clickOnProductsLink(){
        functionLibrary.waitForElementPresent(productsLink);
        productsLink.click();
    }


    public void logout() {
        logoutLink.click();
    }

}
