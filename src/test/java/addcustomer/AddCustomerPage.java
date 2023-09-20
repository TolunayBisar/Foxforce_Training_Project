package addcustomer;

import basefunctions.FunctionLibrary;
import basefunctions.ScreenShotUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AddCustomerPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    ScreenShotUtility screenShotUtility = new ScreenShotUtility();

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);

    }
    @FindBy(linkText = "Customer List")
    WebElement customerList;
    @FindBy(linkText = "Add Customer")
    WebElement addCustomer;
    @FindBy(xpath = "//img[@class='checkbox cbs']")
    WebElement status;
    @FindBy(id = "cust-title")
    WebElement title;
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
    WebElement addressesTab;
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
    @FindBy(xpath = "//*[@id=\"address-form\"]/fieldset/div[12]/span/div")
    WebElement billing;
    @FindBy(xpath = "//*[@id=\"address-form\"]/fieldset/div[13]/span/div")
    WebElement defaultAddress;
    @FindBy(xpath = "//input[@type='button']")
    WebElement addButton;
    @FindBy(linkText = "Customer Groups")
    WebElement customerGroup;
    @FindBy(id="group-join")
    WebElement membership;
    @FindBy(xpath = "//div[text()='Customer successfully added.']")
            WebElement successMessage;
    Properties properties = new Properties();
    FileInputStream inputStream;

    {
        try {
            inputStream = new FileInputStream("customerdata.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    String Title = properties.getProperty("title");
    String FirstName = properties.getProperty("firstName");
    String LastName = properties.getProperty("lastName");
    String Notes = properties.getProperty("notes");
    String Email = properties.getProperty("email");
    String Phone = properties.getProperty("phone");
    String CellPhone = properties.getProperty("cellPhone");
    String NewPassword = properties.getProperty("newPassword");
    String ConfirmPassword = properties.getProperty("confirmPassword");
    String Description = properties.getProperty("description");
    String CompanyName = properties.getProperty("companyName");
    String Address = properties.getProperty("address");
    String Address2 = properties.getProperty("address2");
    String Town = properties.getProperty("town");
    String  ZipCode  = properties.getProperty("zipCode");
    public void addCustomer(){
        functionLibrary.waitForElementPresent(customerList);
        customerList.click();
        functionLibrary.waitForElementPresent(addCustomer);
        addCustomer.click();
        functionLibrary.waitForElementPresent(status);
        status.click();
        functionLibrary.waitForElementPresent(title);
        title.sendKeys(Title);
        functionLibrary.waitForElementPresent(firstName);
        firstName.sendKeys(FirstName);
        functionLibrary.waitForElementPresent(lastName);
        lastName.sendKeys(LastName);
        functionLibrary.waitForElementPresent(type);
        Select selectType = new Select(type);
        selectType.selectByIndex(0);
        functionLibrary.waitForElementPresent(language);
        Select selectLanguage = new Select(language);
        selectLanguage.selectByIndex(0);
        functionLibrary.waitForElementPresent(notes);
        notes.sendKeys(Notes);
        functionLibrary.waitForElementPresent(email);
        email.sendKeys(Email);
        functionLibrary.waitForElementPresent(phone);
        phone.sendKeys(Phone);
        functionLibrary.waitForElementPresent(cellPhones);
        cellPhones.sendKeys(CellPhone);
        functionLibrary.waitForElementPresent(subscribed);
        Select selectSubscribed = new Select(subscribed);
        selectSubscribed.selectByIndex(0);
        functionLibrary.waitForElementPresent(newPassword);
        newPassword.sendKeys(NewPassword);
        functionLibrary.waitForElementPresent(confirmPassword);
        confirmPassword.sendKeys(ConfirmPassword);
        functionLibrary.waitForElementPresent(addressesTab);
        addressesTab.click();
        functionLibrary.waitForElementPresent(addAddresses);
        addAddresses.click();
        functionLibrary.waitForElementPresent(description);
        description.sendKeys(Description);
        functionLibrary.waitForElementPresent(editTitle);
        editTitle.sendKeys(Title);
        functionLibrary.waitForElementPresent(editFirstName);
        editFirstName.sendKeys(FirstName);
        functionLibrary.waitForElementPresent(editLastName);
        editLastName.sendKeys(LastName);
        functionLibrary.waitForElementPresent(companyName);
        companyName.sendKeys(CompanyName);
        functionLibrary.waitForElementPresent(editAddress);
        editAddress.sendKeys(Address);
        functionLibrary.waitForElementPresent(additionalAddress);
        additionalAddress.sendKeys(Address2);
        functionLibrary.waitForElementPresent(town);
        town.sendKeys(Town);
        functionLibrary.waitForElementPresent(country);
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("United States");
        functionLibrary.waitForElementPresent(state);
        Select selectState = new Select(state);
        selectState.selectByIndex(0);
        functionLibrary.waitForElementPresent(zipCode);
        zipCode.sendKeys(ZipCode);
        functionLibrary.waitForElementPresent(billing);
        billing.click();
        functionLibrary.waitForElementPresent(defaultAddress);
        defaultAddress.click();
        functionLibrary.waitForElementPresent(addButton);
        addButton.click();
        functionLibrary.waitForElementPresent(customerGroup);
        customerGroup.click();
        functionLibrary.waitForElementPresent(membership);
        Select selectMembership = new Select(membership);
        selectMembership.selectByIndex(2);
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();




    }
    public boolean verifySuccessfully(){
        if (successMessage.isDisplayed()){
            System.out.println("customer successfully added");
            return true;}

        else {
            screenShotUtility.takeScreenShot("testfailed",driver);
            return false;

        }


    }





}
