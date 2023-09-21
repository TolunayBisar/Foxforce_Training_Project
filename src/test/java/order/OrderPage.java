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
        System.out.println(readCustomerInfoList.readCustomerInfo());
         customerInfoField.sendKeys(readCustomerInfoList.readCustomerInfo().get(1));
         functionLibrary.sleep(1);


       // }
        System.out.println(readCustomerInfoList.readCustomerInfo());

    }
}



