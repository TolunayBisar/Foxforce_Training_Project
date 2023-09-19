package addcustomer;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);

    }
    @FindBy(linkText = "Customer List")
    WebElement customerList;
    @FindBy(linkText = "Add Customer")
    WebElement addCustomer;
    @FindBy(id = "customer_status")
    WebElement status;
    @FindBy(id = "cust-title")
    WebElement titile;
    @FindBy(id = "cust-firstname")
    WebElement firstName;
    @FindBy(id = "cust-lastname")
    WebElement lastName;
    @FindBy(id = "cust-type")
    WebElement type;
    @FindBy(id = "language")
    WebElement language;
    @FindBy(id = "cust-notes")
    WebElement notes;
    @FindBy(id = "cust-email")
    WebElement email;
    @FindBy(id = "cust-phone")
    WebElement phone;
    @FindBy(id = "cust-mobile")
    WebElement cellPhones;
    @FindBy(id = "subscription_status")
    WebElement subscribed;
    @FindBy(id = "cust-password")
    WebElement newPassword;
    @FindBy(id = "cust-passconf")
    WebElement confirmPassword;
    @FindBy(name = "save")
    WebElement saveButton;
    @FindBy(linkText = "Addresses")
    WebElement addresses;
    @FindBy(linkText = "Add Address")
    WebElement addAddresses;
    @FindBy(id = "edit_description")
    WebElement description;
    @FindBy(id = "edit_title")
    WebElement editTitle;
    @FindBy(id = "edit_first_name")
    WebElement editFirstName;
    @FindBy(id = "edit_last_name")
    WebElement editLastName;
    @FindBy(id = "edit_company_name")
    WebElement companyName;
    @FindBy(id = "edit_line1")
    WebElement editAddress;
    @FindBy(id = "edit_line2")
    WebElement additionalAddress;
    @FindBy(id = "edit_town")
    WebElement town;
    @FindBy(id = "edit_country")
    WebElement country;
    @FindBy(id = "edit_state")
    WebElement state;
    @FindBy(id = "edit_postcode")
    WebElement zipCode;
    @FindBy(id = "billing")
    WebElement billing;
    @FindBy(id = "default")
    WebElement defaultAddress;
    @FindBy(xpath = "//input[@type='button']")
    WebElement addButton;
    @FindBy(linkText = "Customer Groups")
    WebElement customerGroup;
    @FindBy(id="group-join")
    WebElement membership;












}
