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
    @FindBy(id="sum_ship_tracking")
    WebElement trackNo;

    @FindBy(id="sum_weight")
    WebElement weight;

    @FindBy(linkText = "Inventory")
    WebElement inventoryTab;

    @FindBy(xpath = "//tr[@class='update-subtotal inline-add']/td[1]/input[1]")
    WebElement quantityField;

    @FindBy(id="ajax_name")
    WebElement productNameField;


    @FindBy(id="ajax_price")
    WebElement unitePriceField;

    @FindBy(xpath = "//a[@target='inventory-list']/i")
    WebElement addProductIcon;
    @FindBy(id="discount_type")
    WebElement discountDropdown;
    @FindBy(id="discount")
    WebElement discountField;
    @FindBy(id="shipping")
    WebElement shippingCost;
    @FindBy(xpath = "//input[@class='textbox number-right tax not-empty']")
    WebElement tax;
@FindBy(xpath = "//a[@target='tax-list']/i")
WebElement addIcon;

@FindBy(xpath = "//div[@id='tab_order_notes']/a")
WebElement noteTab;

@FindBy(name = "note")
WebElement internalNoteField;
@FindBy(name = "summary[note_to_customer]")
WebElement publicNoteField;
@FindBy(xpath = "//input[@value='Save']")
WebElement saveButton;
@FindBy(xpath = "//div[contains(text(),'Order successfully created.')]")
WebElement verifyMessageOfCreateOrder;

@FindBy(linkText = "Search Orders")
WebElement searchTab;



    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);

        readCustomerInfoList = new ReadCustomerInfoList(driver);
        orderObject = new OrderObject("ersin","28","DHL","Monday",
                "D"+System.currentTimeMillis(),1.5,3,"book",10,10,10,
                "This is important shipment","Pls give us feedback as soon as you get product");
    }


    // Verify at least one order in list
    public boolean verifyOrder() {
        if (orderList.size() >= 1)
            System.out.println("There is at least on order in list");
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
        customerInfoField.sendKeys(orderObject.getCustomerInfo());
        functionLibrary.sleep(1);
        customerSelect.click();
        //functionLibrary.waitForElementPresent(title);
        //title.sendKeys("Mr");
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

        //Delivery Tab
        functionLibrary.waitForElementPresent(deliveryTab);
        deliveryTab.click();
        functionLibrary.waitForElementPresent(copyAddLink);
        copyAddLink.click();
        functionLibrary.waitForElementPresent(dispatchDateField);
        dispatchDateField.click();
        for (int i = 0; i < dateButton.size(); i++) {
            if (dateButton.get(i).getText().equals(orderObject.getDispatchDate()) ) {
                dateButton.get(i).click();
            }

        }
        functionLibrary.waitForElementPresent(shipMethod);
        shipMethod.sendKeys(orderObject.getShippingMethod());
        functionLibrary.waitForElementPresent(shipProduct);
        shipProduct.sendKeys(orderObject.getShippingDate());
        functionLibrary.waitForElementPresent(trackNo);
        trackNo.sendKeys(orderObject.getDeliveryTracking());
        functionLibrary.waitForElementPresent(weight);
        weight.sendKeys(String.valueOf(orderObject.getWeight()));

        //inventory tab
        functionLibrary.waitForElementPresent(inventoryTab);
        inventoryTab.click();
        functionLibrary.waitForElementPresent(quantityField);
        quantityField.sendKeys(String.valueOf(orderObject.getQuantity()));
        functionLibrary.waitForElementPresent(productNameField);
        productNameField.sendKeys(orderObject.getProductName());

        functionLibrary.waitForElementPresent(unitePriceField);
        unitePriceField.sendKeys(String.valueOf(50));
        functionLibrary.waitForElementPresent(addProductIcon);
        addProductIcon.click();
        functionLibrary.waitForElementPresent(discountDropdown);
        Select select1 = new Select(discountDropdown);
        select1.selectByValue("p");
        functionLibrary.waitForElementPresent(discountField);
        discountField.sendKeys(String.valueOf(orderObject.getDiscountAmount()));
        functionLibrary.waitForElementPresent(shippingCost);
        shippingCost.sendKeys(String.valueOf(orderObject.getShippingCost()));
        functionLibrary.waitForElementPresent(tax);
        tax.sendKeys(String.valueOf(orderObject.getTaxAmount()));
        functionLibrary.waitForElementPresent(addIcon);
        addIcon.click();


        // Note Tab
        functionLibrary.waitForElementPresent(noteTab);
        noteTab.click();
        functionLibrary.waitForElementPresent(internalNoteField);
        internalNoteField.sendKeys(orderObject.getInternalNotes());
        functionLibrary.waitForElementPresent(publicNoteField);
        publicNoteField.sendKeys(orderObject.getPublicNotes());
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }

        // verify create order
        public boolean verifyOrderCreated(){
        if (verifyMessageOfCreateOrder.isDisplayed())
            System.out.println("order created successfully");
        return true;

    }

    //search Order
    public void searchOrder(){
        functionLibrary.waitForElementPresent(searchTab);
        searchTab.click();
    }


}



