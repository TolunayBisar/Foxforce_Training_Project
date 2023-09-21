package order;

import basefunctions.FunctionLibrary;
import cubecartobjects.OrderObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ExcelObject {


    WebDriver driver;
    FunctionLibrary functionLibrary;
    OrderObject orderObject;
    ReadCustomerInfoList readCustomerInfoList;
    @FindAll(@FindBy(xpath = "//div/table[last()]/tbody/tr"))
    List<WebElement> orderList;

    @FindBy(linkText = "Check/Uncheck all")
    WebElement checkUncheckallClick;

    @FindAll(@FindBy(xpath = "//div[@class='custom-checkbox']"))
    List<WebElement> checkboxList;
    @FindAll(@FindBy(xpath = "//div[@class='custom-checkbox selected']"))
    List<WebElement> checkboxSelectedList;

    @FindBy(xpath = "//div[@class='tab']/a[text()='Create Order']")
    WebElement createOrderTab;

    @FindBy(id = "o_status")
    WebElement orderStatusField;

    @FindBy(xpath = "//div[@id='tab_order_billing']/a[text()='Billing']")
    WebElement billingTab;

    @FindBy(id = "sum_name")
    WebElement customerInfoField;

    @FindBy(xpath = "//span[@name='1']")
    WebElement customerSelect;

    @FindBy(id = "ajax_title")
    WebElement title;

    @FindBy(id = "sum_company_name")
    WebElement companyName;

    @FindBy(id = "sum_line1")
    WebElement addressField;
    @FindBy(id = "sum_town")
    WebElement cityField;

    @FindBy(id = "sum_country")
    WebElement countryField;

    @FindBy(id = "sum_postcode")
    WebElement zipField;

    public ExcelObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);

        readCustomerInfoList = new ReadCustomerInfoList(driver);
        orderObject = new OrderObject(readCustomerInfoList.readCustomerInfo().get(0), "28", "DHL", "Monday",
                "D" + System.currentTimeMillis(), 1.5, 3, "book", 10, 10, 10,
                "This is important shippment", "Pls give us feedback as soon as you get product");
    }

    public void createOrder() {

        functionLibrary.waitForElementPresent(createOrderTab);
        createOrderTab.click();
        functionLibrary.waitForElementPresent(orderStatusField);
        orderStatusField.click();
        Select statusDropdown = new Select(orderStatusField);
        // for (int i = 1; i <= 3; i++) {
        statusDropdown.selectByIndex(0);
        functionLibrary.waitForElementPresent(billingTab);
        billingTab.click();
        functionLibrary.waitForElementPresent(customerInfoField);
        customerInfoField.sendKeys(orderObject.getCustomerInfo());
        functionLibrary.sleep(1);
        customerSelect.click();
        functionLibrary.waitForElementPresent(title);
        title.sendKeys("Mr");
        functionLibrary.waitForElementPresent(companyName);
        companyName.sendKeys("Limon");
        functionLibrary.waitForElementPresent(addressField);
        addressField.sendKeys("fatih");
        functionLibrary.waitForElementPresent(cityField);
        cityField.sendKeys("Istanbul");
        Select select = new Select(countryField);
        select.selectByVisibleText("Turkey");
        functionLibrary.waitForElementPresent(zipField);
        zipField.sendKeys("345000");

    }
}
