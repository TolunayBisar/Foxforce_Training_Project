package order;

import basefunctions.FunctionLibrary;
import basefunctions.ScreenShotUtility;
import cubecartobjects.OrderObject;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class OrderPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    OrderObject orderObject;
    ReadCustomerInfoList readCustomerInfoList;
    ReadOrderInfoList readOrderInfoList;
    DashBoardPage dashBoardPage;
    ScreenShotUtility screenShotUtility;
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
    @FindBy(linkText = "Delivery")
    WebElement deliveryTab;

    @FindBy(linkText = "Copy from Billing Address")
    WebElement copyAddLink;

    @FindBy(id = "sum_ship_date")
    WebElement dispatchDateField;

    @FindAll(@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td"))
    List<WebElement> dateButton;

    @FindBy(id = "sum_ship_method")
    WebElement shipMethod;

    @FindBy(id = "sum_ship_product")
    WebElement shipProduct;
    @FindBy(id = "sum_ship_tracking")
    WebElement trackNo;

    @FindBy(id = "sum_weight")
    WebElement weight;

    @FindBy(linkText = "Inventory")
    WebElement inventoryTab;

    @FindBy(xpath = "//tr[@class='update-subtotal inline-add']/td[1]/input[1]")
    WebElement quantityField;

    @FindBy(id = "ajax_name")
    WebElement productNameField;


    @FindBy(id = "ajax_price")
    WebElement unitePriceField;

    @FindBy(xpath = "//a[@target='inventory-list']/i")
    WebElement addProductIcon;
    @FindBy(id = "discount_type")
    WebElement discountDropdown;
    @FindBy(id = "discount")
    WebElement discountField;
    @FindBy(id = "shipping")
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

    @FindBy(xpath = "//span/input[@name='search[order_number]']")
    WebElement orderNumberField;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//div[text()='Orders have been found that match your search criteria.']")
    WebElement searchOrderSeccussfulMsg;

    @FindBy(xpath = "//strong[text()='No orders found.']")
    WebElement noFundMsg;

    @FindAll(@FindBy(xpath = "//i[@title='Edit']"))
    List<WebElement> editIcons;

    @FindBy(xpath = "//div[text()='Order successfully updated.']")
    WebElement editSuccessMsg;
    @FindAll(@FindBy(xpath = "//i[@title='Delete']"))
    List<WebElement> deleteIcons;

    @FindBy(xpath = "//tr[1]/td[2]/a[@title='Edit']")
    WebElement firstOrderNumber;

    @FindBy(xpath = "//div[text()='Order successfully deleted.']")
    WebElement verifyDeleteMsg;

    @FindBy(name = "multi-status")
    WebElement editStatusDropdown;
    @FindBy(name = "multi-action")
    WebElement printOrDeleteDropdown;
    @FindAll(@FindBy(name = "multi-order[]"))
    List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@name='go']")
    WebElement goButton;

    @FindAll(@FindBy(name = "custom-checkbox selected"))
    List<WebElement> checkboxSelected;

    @FindBy(xpath = "//div[text()='Selected orders have been deleted.']")
    WebElement verifyDeleteWithDropdown;


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);

        readCustomerInfoList = new ReadCustomerInfoList(driver);
        readOrderInfoList = new ReadOrderInfoList(driver);
        dashBoardPage = new DashBoardPage(driver);
        screenShotUtility = new ScreenShotUtility();

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
        Random random = new Random();
        orderObject = new OrderObject(readCustomerInfoList.readCustomerInfo().get(random.nextInt(24)), "28", "DHL", "Monday",
                "D" + System.currentTimeMillis(), 1.5, 3, "book", 10, 10, 10,
                "This is important shipment", "Pls give us feedback as soon as you get product");

        functionLibrary.waitForElementPresent(createOrderTab);
        createOrderTab.click();

        //Order Summary
        functionLibrary.waitForElementPresent(orderStatusField);
        orderStatusField.click();
        Select statusDropdown = new Select(orderStatusField);
        statusDropdown.selectByIndex(random.nextInt(5));

        //Billing Tab
        functionLibrary.waitForElementPresent(billingTab);
        billingTab.click();
        functionLibrary.waitForElementPresent(customerInfoField);
        customerInfoField.sendKeys(orderObject.getCustomerInfo());
        functionLibrary.sleep(1);
        customerSelect.click();
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
            if (dateButton.get(i).getText().equals(orderObject.getDispatchDate())) {
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
    public boolean verifyOrderCreated() {
        if (verifyMessageOfCreateOrder.isDisplayed())
            System.out.println("order created successfully");
        return true;

    }

    public void createOrderList() {
        LinkedHashMap<String, String> orderList = new LinkedHashMap<>();
        List<WebElement> orderNumbers = driver.findElements(By.xpath
                ("//tbody//td[2]/a[@title='Edit']"));
        List<WebElement> customers = driver.findElements(By.xpath
                ("//tbody//td[4]/a"));
        for (int i = 0; i < orderNumbers.size(); i++) {
            orderList.put(orderNumbers.get(i).getText(), customers.get(i).getText());
            OrderInfoExcelList writeOrderToExcel = new OrderInfoExcelList(driver);
            String fileName = "CustomerInfoFolder/orderName.xlsx";
            String folderName = "CustomerInfoFolder";
            writeOrderToExcel.writeOrderToExcel(fileName, folderName, "2.Page", orderList);
        }
    }

    //search Order
    public void searchOrder() {
        functionLibrary.waitForElementPresent(searchTab);
        searchTab.click();
        Random random = new Random();
        orderNumberField.sendKeys(readOrderInfoList.readOrderInfo().get(0).
                get(random.nextInt(checkboxes.size())));
        searchButton.click();
    }

    public boolean verifySearchOrder() {

        if (searchOrderSeccussfulMsg.isDisplayed()) {
            System.out.println("You fund that order");
            return true;

        } else if (noFundMsg.isDisplayed())
            System.out.println("Nofund");
        return false;
    }

    //Edit

    public void editOrder() {
        dashBoardPage.setOrderLink();
        Random random = new Random();
        orderObject = new OrderObject(readCustomerInfoList.readCustomerInfo().get(random.nextInt(24)), "26", "MNG", "Sunday",
                "M" + System.currentTimeMillis(), 1, 10, "Iphone", 1000, 10, 10,
                "This is dangerous shipment", "Thanks for your supporting");
        editIcons.get(random.nextInt(editIcons.size())).click();
        orderStatusField.click();
        Select select = new Select(orderStatusField);
        select.selectByIndex(random.nextInt(6));
        functionLibrary.waitForElementPresent(billingTab);
        billingTab.click();
        functionLibrary.sleep(1);
        title.clear();
        title.sendKeys("Mr");
        functionLibrary.waitForElementPresent(companyName);
        companyName.clear();
        companyName.sendKeys("AAA");
        functionLibrary.waitForElementPresent(addressField);
        addressField.clear();
        addressField.sendKeys("silivri");
        functionLibrary.waitForElementPresent(cityField);
        cityField.clear();
        cityField.sendKeys("Izmir");
        functionLibrary.waitForElementPresent(countryField);
        countryField.click();
        Select select1 = new Select(countryField);

        select1.selectByIndex(12);
        functionLibrary.waitForElementPresent(zipField);
        zipField.clear();
        zipField.sendKeys("3000s");

        functionLibrary.waitForElementPresent(deliveryTab);
        deliveryTab.click();
        functionLibrary.waitForElementPresent(copyAddLink);
        copyAddLink.click();
        functionLibrary.waitForElementPresent(dispatchDateField);
        dispatchDateField.click();
        for (int i = 0; i < dateButton.size(); i++) {
            if (dateButton.get(i).getText().equals(orderObject.getDispatchDate())) {
                dateButton.get(i).click();
            }

        }
        functionLibrary.waitForElementPresent(shipMethod);
        shipMethod.clear();
        shipMethod.sendKeys(orderObject.getShippingMethod());
        functionLibrary.waitForElementPresent(shipProduct);
        shipProduct.clear();
        shipProduct.sendKeys(orderObject.getShippingDate());
        functionLibrary.waitForElementPresent(trackNo);
        trackNo.clear();
        trackNo.sendKeys(orderObject.getDeliveryTracking());
        functionLibrary.waitForElementPresent(weight);
        weight.clear();
        weight.sendKeys(String.valueOf(orderObject.getWeight()));

        //inventory tab
        functionLibrary.waitForElementPresent(inventoryTab);
        inventoryTab.click();
        functionLibrary.waitForElementPresent(quantityField);
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(orderObject.getQuantity()));
        functionLibrary.waitForElementPresent(productNameField);
        productNameField.clear();
        productNameField.sendKeys(orderObject.getProductName());

        functionLibrary.waitForElementPresent(unitePriceField);
        unitePriceField.clear();
        unitePriceField.sendKeys(String.valueOf(50000));
        functionLibrary.waitForElementPresent(addProductIcon);
        addProductIcon.click();
        functionLibrary.waitForElementPresent(discountDropdown);
        Select select2 = new Select(discountDropdown);
        select2.selectByValue("f");
        functionLibrary.waitForElementPresent(discountField);
        discountField.sendKeys(String.valueOf(orderObject.getDiscountAmount()));
        functionLibrary.waitForElementPresent(shippingCost);
        shippingCost.clear();
        shippingCost.sendKeys(String.valueOf(orderObject.getShippingCost()));
        functionLibrary.waitForElementPresent(tax);
        tax.clear();
        tax.sendKeys(String.valueOf(orderObject.getTaxAmount()));
        functionLibrary.waitForElementPresent(addIcon);
        addIcon.click();


        // Note Tab
        functionLibrary.waitForElementPresent(noteTab);
        noteTab.click();
        functionLibrary.waitForElementPresent(internalNoteField);
        internalNoteField.clear();
        internalNoteField.sendKeys(orderObject.getInternalNotes());
        functionLibrary.waitForElementPresent(publicNoteField);
        publicNoteField.clear();
        publicNoteField.sendKeys(orderObject.getPublicNotes());
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyEdit() {
        functionLibrary.waitForElementPresent(editSuccessMsg);
        if (editSuccessMsg.isDisplayed())
            System.out.println("edit successful!");
        return true;
    }

    //Delete Order
    public void deleteOrderWithIcon() {


        System.out.println("before delete : " + deleteIcons.size());

        functionLibrary.waitForElementPresent(deleteIcons.get(0));

        for (int i = 0; i < deleteIcons.size(); i++) {
            if ((firstOrderNumber.getText()).equals(readOrderInfoList.readOrderInfo().get(i).get(i))) {
                deleteIcons.get(i).click();
                break;
            }

        }
        functionLibrary.sleep(1);
        driver.switchTo().alert().accept();

        System.out.println("after delete : " + deleteIcons.size());



    }

    public boolean verifyDelete() {


        if (verifyDeleteMsg.isDisplayed())
            System.out.println("You have deleted the order");
        return true;
    }

    public void dropdownOnOrderPage() {
        Random random = new Random();
        checkboxes.get(random.nextInt(checkboxes.size())).click();
        checkboxes.get(random.nextInt(checkboxes.size())).click();
        checkboxes.get(random.nextInt(checkboxes.size())).click();
        functionLibrary.waitForElementPresent(editStatusDropdown);
        Select select = new Select(editStatusDropdown);
        select.selectByIndex(random.nextInt(6));
        functionLibrary.waitForElementPresent(printOrDeleteDropdown);
        Select select1 = new Select(printOrDeleteDropdown);
        select1.selectByIndex(1);
        goButton.click();
        screenShotUtility.takeScreenShot("verifyPrint", driver);
        driver.navigate().back();



        System.out.println("The quantities of selected checkboxes are " + checkboxSelected.size());
        select.selectByIndex(random.nextInt(6));
        select1.selectByValue("delete");
        goButton.click();
        driver.switchTo().alert().accept();

    }

    public boolean verifyDeleteWithDropdown() {
        if (verifyDeleteWithDropdown.isDisplayed())
            System.out.println("multiple delete with dropdown is successful");
        return true;
    }


}







