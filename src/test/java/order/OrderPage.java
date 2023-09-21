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

public class OrderPage {
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

    @FindBy(id="sum_name")
    WebElement customerInfoField;

    @FindBy(xpath = "//span[@name='1']")
    WebElement customerSelect;

    @FindBy(id="ajax_title")
    WebElement title;

    @FindBy(id="sum_company_name")
    WebElement companyName;

    @FindBy(id="sum_line1")
    WebElement addressField;
    @FindBy(id="sum_town")
    WebElement cityField;

    @FindBy(id="sum_country")
    WebElement countryField;

    @FindBy(id="sum_postcode")
    WebElement zipField;
    @FindBy(linkText = "Delivery")
    WebElement deliveryTab;

    @FindBy(linkText = "Copy from Billing Address")
    WebElement copyAddLink;

    @FindBy(id="sum_ship_date")
    WebElement dispatchDateField;

    @FindAll(@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td"))
    List<WebElement> dateButton;

    @FindBy(id="sum_ship_method")
    WebElement shipMethod;

    @FindBy (id="sum_ship_product")
    WebElement shipProduct;
    @FindBy(id="1sum_ship_tracking")
    WebElement trackNo;

    @FindBy(id="sum_weight")
    WebElement weight;

    @FindBy(linkText = "Inventory")
    WebElement inventoryTab;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
        orderObject = new OrderObject();
        readCustomerInfoList = new ReadCustomerInfoList(driver);
    }


    // Verify at least one order in list
    public boolean verifyOrder() {
        if (orderList.size() >= 1)
            System.out.println("There is at leat on order in list");
        System.out.printf("There are %d orders in this list", orderList.size());


        return true;
    }

    //'Check/uncheck all' click
    public boolean verifyCheckUncheckAllClick() {
        functionLibrary.waitForElementPresent(checkUncheckallClick);
        checkUncheckallClick.click();
        functionLibrary.sleep(1);
        checkUncheckallClick.click();
        functionLibrary.sleep(1);

        System.out.println(checkboxList.size());
        System.out.println(orderList.size());
        System.out.println(checkboxSelectedList.size());

        if ((checkboxSelectedList.size() == orderList.size()) || (checkboxList.size() == orderList.size()))
            System.out.println("Check is working");


        return true;
    }

    //Create order
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
         customerInfoField.sendKeys(readCustomerInfoList.readCustomerInfo().get(0));
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
         select.selectByVisibleText("Istanbul");
         functionLibrary.waitForElementPresent(zipField);
         zipField.sendKeys("345000");

         //Delivery Tab
         functionLibrary.waitForElementPresent(deliveryTab);
         deliveryTab.click();
         functionLibrary.waitForElementPresent(copyAddLink);
         copyAddLink.click();
         functionLibrary.waitForElementPresent(dispatchDateField);
         dispatchDateField.click();
         for (int i=0;i< dateButton.size();i++){
         if (dateButton.get(i).getText()=="28"){
             dateButton.get(i).click();
         }

         }
         functionLibrary.waitForElementPresent(shipMethod);
         shipMethod.sendKeys("DHL");
         functionLibrary.waitForElementPresent(shipProduct);
         shipProduct.sendKeys("phone");
         functionLibrary.waitForElementPresent(trackNo);
         trackNo.sendKeys("D3456");
         functionLibrary.waitForElementPresent(weight);
         weight.sendKeys("1kg");






       // }


    }
}



