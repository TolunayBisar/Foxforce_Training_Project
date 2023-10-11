package inventory;

import basefunctions.FunctionLibrary;
import com.github.javafaker.Faker;
import dashboard.DashBoardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PromotionalCodes {
    WebDriver driver;
    Faker faker;
    DashBoardPage dashBoardPage;
    FunctionLibrary functionLibrary;
    @FindBy(xpath = "//*[@id=\"tab_control\"]/div[2]")
    WebElement createPromotionalCodeTab;
    @FindBy(name = "coupon[code]")
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
    @FindBy(xpath = "//*[@id=\"form_manufacturer_chosen\"]/ul/li/input")
    WebElement limitToManufacturer;
    @FindBy(name = "coupon[cart_order_id]")
    WebElement orderNumberField;
    @FindBy(xpath = "//*[@id=\"page_content\"]/form/div[3]/input[2]")
    WebElement saveButton;

    public PromotionalCodes(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);

        dashBoardPage = new DashBoardPage(driver);
    }

    public boolean promotionalCodes(){
        return true;
    }

    public void createPromotionalCode(){
        dashBoardPage.clickOnPromotionalCodes();
        functionLibrary.waitForElementPresent(createPromotionalCodeTab);
        createPromotionalCodeTab.click();
        functionLibrary.waitForElementPresent(codeField);
        codeField.sendKeys(faker.code().asin());
        functionLibrary.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(faker.name().fullName());
        Select select = new Select(discountType);
        select.selectByValue("fixed");
        functionLibrary.waitForElementPresent(discountValueField);
        discountValueField.sendKeys(faker.name().fullName());

    }
    public void createGiftCard(String orderNumber){}
    public void editPromotionalCode(int code){}
    public void deletePromotionalCode(int code){}

}
