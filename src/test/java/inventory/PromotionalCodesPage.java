package inventory;

import basefunctions.FunctionLibrary;
import com.github.javafaker.Faker;
import cubecartobjects.PromotionalCodesObject;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PromotionalCodesPage {
    WebDriver driver;
    Faker faker = new Faker();
    FunctionLibrary functionLibrary;

    PromotionalCodesObject promotionalCodesObject;
    String code = faker.code().asin();

    @FindBy(id = "tab_coupons")
    WebElement promotionalCodesTab;
    @FindBy(xpath = "//*[@id=\"tab_control\"]/div[2]")
    WebElement createPromotionalCodeTab;
    @FindBy(id = "tab_certificates")
    WebElement giftCardsTab;
    @FindAll(
            @FindBy(xpath = "//*[@id=\"coupons\"]/table"))
    List<WebElement> promotionalCodesList;
    @FindBy(xpath = "//*[@id=\"form-code\"]")
    WebElement codeField;
    @FindBy(name = "coupon[description]")
    WebElement descriptionField;
    @FindBy(name = "discount_type")
    WebElement discountType;
    @FindBy(name = "discount_value")
    WebElement discountValueField;
    @FindBy(name = "coupon[starts]")
    WebElement startsField;
    @FindAll(@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td"))
    List<WebElement> startsDateButton;
    @FindBy(name = "coupon[expires]")
    WebElement expiresField;
    @FindAll(@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td"))
    List<WebElement> expiresDateButton;
    @FindBy(name = "coupon[allowed_uses]")
    WebElement allowedUsesField;
    @FindBy(name = "coupon[min_subtotal]")
    WebElement minimumSubtotalField;
    @FindBy(xpath = "//*[@id=\"edit-coupon\"]/fieldset[3]/div[5]/span/img")
    WebElement discountCheckbox;
    @FindBy(xpath = "//*[@id=\"edit-coupon\"]/fieldset[3]/div[6]/span/img")
    WebElement couponCheckbox;
    @FindBy(xpath = "//*[@id=\"edit-coupon\"]/fieldset[3]/div[7]/span/img")
    WebElement disallowCheckbox;
    @FindBy(xpath = "//*[@id=\"edit-coupon\"]/fieldset[3]/div[8]/span/img")
    WebElement excludeCheckbox;
    @FindBy(name = "coupon[coupon_per_customer]")
    WebElement maximumUsesPerCustomerField;
    @FindAll(@FindBy(css = "div.chosen-drop ul li"))
    List<WebElement> limitToManufacturer;
    @FindBy(id = "form_manufacturer_chosen")
    WebElement limitToManufacturerField;
    @FindBy(name = "coupon[cart_order_id]")
    WebElement orderNumberField;
    @FindBy(xpath = "//*[@id=\"page_content\"]/form/div[3]/input[2]")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"coupons\"]/table/tbody/tr[1]/td[7]/a[2]")
    WebElement deleteIcon;
    @FindBy(css = "div#gui_message>div.success")
    WebElement promotionalCodeAddedMessage;
    @FindBy(xpath = "//*[@id=\"gui_message\"]/div")
    WebElement promotionalCodeUpdateMessage;
    @FindBy(css = "div#gui_message>div.success")
    WebElement promotionalCodeDeletedMessage;


    public PromotionalCodesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);

    }

    public boolean viewAtLeaseOnePromotionalCodes() {
        if (promotionalCodesList.size() >= 1) {
            System.out.println("See at least one promotionalCodesPage");
            return true;
        } else {
            System.out.println("See at least nul promotionalCodesPage");
            return false;
        }
    }

    public void createPromotionalCode() {
        promotionalCodesObject = new PromotionalCodesObject("1", "30",
                "All", "500", "Amazon Essentials");

        functionLibrary.waitForElementPresent(createPromotionalCodeTab);
        createPromotionalCodeTab.click();
        functionLibrary.waitForElementPresent(codeField);
        codeField.sendKeys(code);
        System.out.println(code);
        functionLibrary.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(faker.harryPotter().quote());
        Select select = new Select(discountType);
        select.selectByValue("fixed");
        functionLibrary.waitForElementPresent(discountValueField);
        discountValueField.sendKeys(faker.number().digit());
        functionLibrary.waitForElementPresent(startsField);
        startsField.click();
        for (int i = 0; i < startsDateButton.size(); i++) {
            if (startsDateButton.get(i).getText().equals(promotionalCodesObject.getStartsDate())) {
                startsDateButton.get(i).click();
            }
        }
        functionLibrary.waitForElementPresent(expiresField);
        expiresField.click();
        functionLibrary.sleep(1);
        for (int i = 0; i < expiresDateButton.size(); i++) {
            if (expiresDateButton.get(i).getText().equals(promotionalCodesObject.getExpiresDate())) {
                expiresDateButton.get(i).click();
            }
        }
        functionLibrary.waitForElementPresent(allowedUsesField);
        allowedUsesField.sendKeys(promotionalCodesObject.getAllowedUses());
        functionLibrary.waitForElementPresent(minimumSubtotalField);
        minimumSubtotalField.sendKeys(promotionalCodesObject.getMinimumSubtotal());
        functionLibrary.waitForElementPresent(discountCheckbox);
        discountCheckbox.click();
        functionLibrary.waitForElementPresent(couponCheckbox);
        couponCheckbox.click();
        functionLibrary.waitForElementPresent(disallowCheckbox);
        disallowCheckbox.click();
        functionLibrary.waitForElementPresent(excludeCheckbox);
        excludeCheckbox.click();
        functionLibrary.waitForElementPresent(maximumUsesPerCustomerField);
        maximumUsesPerCustomerField.sendKeys(faker.number().digit());
        functionLibrary.waitForElementPresent(limitToManufacturerField);
        limitToManufacturerField.click();
        functionLibrary.sleep(1);
        limitToManufacturer.get(0).click();
        limitToManufacturerField.click();
        functionLibrary.sleep(1);
        limitToManufacturer.get(2).click();
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean verifyPromotionalCodeAddedMessage() {
        if (promotionalCodeAddedMessage.isDisplayed()) {
            System.out.println("Promotional code added.");
            return true;
        } else {
            System.out.println("Promotional code added was not successful");
            return false;
        }
    }

    public void editPromotionalCode() {
        promotionalCodesTab.click();
        WebElement promotionalCodeLink = driver.findElement(By.xpath(String.format
                ("//tbody/tr/td/a[text()='%s']", code)));
        promotionalCodeLink.click();
        descriptionField.clear();
        descriptionField.sendKeys(faker.book().author());
        saveButton.click();
    }

    public boolean verifyPromotionalCodeUpdateMessage() {
        if (promotionalCodeUpdateMessage.isDisplayed()) {
            System.out.println("Promotional code updated.");
            return true;
        } else {
            System.out.println("Promotional code was not updated successful");
            return false;
        }

    }

    public void createGiftCard() {
        // order Number
        String orderNumber = "";
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickOnOrdersLink();
        List<WebElement> orderNumberList = driver.findElements(By.xpath(
                "//tbody/tr/td/a[@title='Edit']"));
        for (WebElement element : orderNumberList) {
            orderNumber = element.getText();
            System.out.println(orderNumber);
            break;
        }
        functionLibrary.sleep(3);
        dashBoardPage.clickOnPromotionalCodes();
        WebElement promotionalCodeLink = driver.findElement(By.xpath(String.format
                ("//tbody/tr/td/a[text()='%s']", code)));
        promotionalCodeLink.click();
        orderNumberField.sendKeys(orderNumber);
        saveButton.click();
    }

    public boolean verifyGiftCard() {
        giftCardsTab.click();
        functionLibrary.sleep(2);
        WebElement codeDisplay = driver.findElement(By.xpath(String.format
                ("//tbody/tr/td[text()='%s']", code)));
        return codeDisplay.isDisplayed();
    }

    public void deletePromotionalCode() {
        promotionalCodesTab.click();
        functionLibrary.waitForElementPresent(deleteIcon);
        functionLibrary.sleep(3);
        deleteIcon.click();
        functionLibrary.sleep(3);
        driver.switchTo().alert().accept();
    }

    public boolean verifyPromotionalCodeDeleted() {
        if (promotionalCodeDeletedMessage.isDisplayed()) {
            System.out.println("Promotional code deleted.");
            return true;
        } else {
            System.out.println("Promotional code deleted was not successful");
            return false;
        }
    }

}


