package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import basefunctions.ScreenShotUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addCustomerPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    ScreenShotUtility screenShotUtility;
    BaseClass baseClass = new BaseClass();


    // 1. Create Group
    @FindBy(xpath = "//*[@id=\"tab_customer-groups\"]/a")
    WebElement customerGroupsLink;
    @FindBy(name = "group_add[group_name]")
    WebElement customerGroupsName;
    @FindBy(name = "group_add[group_description]")
    WebElement descriptionFile;
    @FindBy(name = "save")
    WebElement saveButtonToCreateCustomerGroups;
    @FindBy(css = "div#gui_message>div.success")
    WebElement customerGroupUpdatedMessage;


    // 2.SearchCustomer
    @FindBy(css = "div[id='tab_sidebar']")
    WebElement searchCustomerLink;
    @FindBy(css = "#customer_id")
    WebElement searchCustomerBox;
    @FindBy(xpath = "(//input[@value=\"Go\"])[1]")
    WebElement goButton;
    @FindBy(css = ".success")
    WebElement searchCustomerSuccessMessage;

    // 2. GDPR Tools
    @FindBy(css = "#email")
    WebElement email;
    @FindBy(xpath = "//*[@value=\"Create Report\"]")
    WebElement createReportButton;

    // 3.
    @FindBy(xpath = "//body//h1[1]")
    WebElement consentPage;

    public addCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }
    // 1. Create Group
    public void createCustomerGroups() {
        functionLibrary.waitForElementPresent(customerGroupsLink);
        customerGroupsLink.click();
        functionLibrary.waitForElementPresent(customerGroupsName);
        customerGroupsName.sendKeys("Team A 4");
        functionLibrary.waitForElementPresent(descriptionFile);
        descriptionFile.sendKeys("Welcome");
        saveButtonToCreateCustomerGroups.click();
    }
//    public boolean verifyCustomerGroupUpdatedMessage() {
//        screenShotUtility.takeScreenShot("AddCustomerGroup");
//        if (customerGroupUpdatedMessage.isDisplayed()) {
//            System.out.println("Customer Group added.");
//            return true;
//        } else {
//            System.out.println("Create customer Group was not successful");
//            return false;
//        }
//
//    }
}
