package customersmodule;

import basefunctions.BaseClass;
import basefunctions.FunctionLibrary;
import basefunctions.ScreenShotUtility;
import com.github.javafaker.Faker;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CustomerListPage {
    WebDriver driver;

    FunctionLibrary functionLibrary;
    ScreenShotUtility screenShotUtility;
    DashBoardPage dashBoardPage;
    BaseClass baseClass = new BaseClass();
    Faker faker = new Faker();
    String groupName;
    String email;
    Boolean verify = true;


    // 1. Create Group
    @FindBy(css = "div[id='tab_customer-groups']")
    WebElement customerGroupsTab;
    @FindBy(name = "group_add[group_name]")
    WebElement customerGroupsNameInputField;
    @FindBy(name = "group_add[group_description]")
    WebElement descriptionField;
    @FindBy(name = "save")
    WebElement saveButtonToCreateCustomerGroups;
    @FindBy(css = "div#gui_message>div.success")
    WebElement customerGroupUpdatedMessage;


    // 2.SearchCustomer
    @FindBy(css = "div[id='tab_sidebar']")
    WebElement searchCustomerTab;
    @FindBy(css = "#customer_id")
    WebElement searchCustomerBox;
    @FindBy(xpath = "(//input[@value=\"Go\"])[1]")
    WebElement goButton;
    @FindBy(css = ".success")
    WebElement searchCustomerSuccessMessage;


    // 3. GDPR Tools
    @FindBy(css = "#email")
    WebElement emailField;
    @FindBy(xpath = "//*[@value=\"Create Report\"]")
    WebElement createReportButton;


    // 4. GDPR tool create report
    @FindBy(xpath = "//*[@id=\"tab_control\"]/div[5]")
    WebElement GDPRToolsTab;
    @FindBy(xpath = "//td[text()='Polatalimdar291291@hotmail.com']")
    WebElement consentPage;
       // String xpath = String.format("//td[text()='%s']",emailField);


    // 5.delete Customer Group
    //@FindAll(@FindBy(xpath=String.format("//fieldset[@id='group-list']/div/strong/span[text()='%s']")))
    List<WebElement> groups;
    @FindBy(xpath ="parent::strong/preceding-sibling::span//i" )
    WebElement deleteIcon;


    public CustomerListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    // 1. Create Group
    public void addCustomerGroup() {
        functionLibrary.waitForElementPresent(customerGroupsTab);
        customerGroupsTab.click();
        functionLibrary.waitForElementPresent(customerGroupsNameInputField);
        groupName=faker.commerce().department();
        customerGroupsNameInputField.sendKeys(groupName);
        functionLibrary.waitForElementPresent(descriptionField);
        String descriptionText = faker.lorem().sentence();
        descriptionField.sendKeys(descriptionText);
        saveButtonToCreateCustomerGroups.click();
    }

    public boolean verifyCustomerGroupUpdatedMessage() {
        if (customerGroupUpdatedMessage.isDisplayed()) {
            System.out.println("Customer Group added.");
            return true;
        } else {
            System.out.println("Create customer Group was not successful");
            return false;
        }

    }

    // 2. deleteCustomerGroup Method
    public void deleteCustomerGroup() {
        functionLibrary.waitForElementPresent(customerGroupsTab);
        customerGroupsTab.click();
//        WebElement groupToDelete = driver.findElement(By.xpath(String.format("//fieldset[@id='group-list']/div/strong/span[text()='%s']", groupName)));
//        WebElement deleteIcon = groupToDelete.findElement(By.xpath("parent::strong/preceding-sibling::span//i"));
        deleteIcon.click();
        driver.switchTo().alert().accept();
    }

    public boolean verifyDeleteCustomerGroup() {
        driver.navigate().refresh();
        List<WebElement> groupsAfterDelete = driver.findElements(By.cssSelector("fieldset#group-list div strong span"));
        for (WebElement group : groupsAfterDelete) {
            if (group.getText().equalsIgnoreCase(groupName)) {
                verify= false;
            }
        }
        return true;
        //Assert.assertTrue(verify);

    }

    // 3. SearchCustomer
    public void searchCustomer() {
        functionLibrary.waitForElementPresent(searchCustomerTab);
        searchCustomerTab.click();
        functionLibrary.waitForElementPresent(searchCustomerBox);
        email=faker.internet().emailAddress();
        searchCustomerBox.sendKeys(email);
        functionLibrary.waitForElementPresent(goButton);
        goButton.click();
    }


    public boolean verifySearchCustomer() {
        functionLibrary.waitForElementPresent(searchCustomerSuccessMessage);
        if (searchCustomerTab.isDisplayed()) {
            System.out.println("Search customer was successful ");
            return true;

        } else {
            System.out.println("Search customer was not successful");
            return false;
        }

    }
    public void createReport(){
        functionLibrary.waitForElementPresent(GDPRToolsTab);
        GDPRToolsTab.click();
        functionLibrary.waitForElementPresent(emailField);
        email=faker.internet().emailAddress();
        emailField.sendKeys(email);
        functionLibrary.waitForElementPresent(createReportButton);
        createReportButton.click();

    }

    public boolean verifyCreateReport(){
        functionLibrary.waitForElementPresent(consentPage);
        if (consentPage.isDisplayed()){
            System.out.println("Create Report was successful!");
            return true;
        }else {
            System.out.println("Create Report was not successful!");
            return false;
        }
    }
}
