package dashboard;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    @FindBy(xpath = "//a[@href=\"#dashboard\"]")
    WebElement dashBoardLink;
    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(xpath = "//a[(text()=\"Orders\")]")
    WebElement orderLink;
    @FindBy(linkText = "Transaction Logs")
    WebElement TransactionLogsLink;
    @FindBy(linkText = "Newsletters")
    WebElement newsLettersLink;
    @FindBy(linkText = "Mailing List")
    WebElement mailingListLink;
    @FindBy(linkText = "Import Catalogue")
    WebElement importCatalogLink;
    @FindBy(linkText = "Export Catalogue")
    WebElement exportCatalogLink;
    @FindBy(xpath = "//a[text()=\"Email Log\"]")
    WebElement emailLogLink;
    @FindBy(xpath = "//ul[@id='menu_Inventory']/li/a[text()='Product Options']")
    WebElement productOptionLink;

    @FindBy(xpath = "//a[text()='Manufacturers']")
    WebElement manufactureLink;


    @FindBy(xpath = "//*[@id=\"menu_Inventory\"]/li[5]/a")
    WebElement promotionalCodes;
    @FindBy(linkText= "Reviews")
    WebElement reviewLink;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }


    public boolean verifyDashboardPage() {
        functionLibrary.waitForElementPresent(dashBoardLink);
        if (dashBoardLink.isDisplayed() && dashBoardLink.getText().contains("Dashboard")) {
            System.out.println("Dashboard page open...");
            return true;
        } else {
            System.out.println("Dashboard page filed to open...");
        }
        return false;
    }

    public void clickOnCustomerListLink() {
        functionLibrary.waitForElementPresent(customerListLink);
        customerListLink.click();
    }

    public void clickOnOrdersLink() {
        functionLibrary.waitForElementPresent(orderLink);
        orderLink.click();
    }

    public void clickOnTransactionLogsLink() {
        functionLibrary.waitForElementPresent(TransactionLogsLink);
        TransactionLogsLink.click();
    }

    public void clickOnNewsLettersLink() {
        functionLibrary.waitForElementPresent(newsLettersLink);
        newsLettersLink.click();
    }

    public void clickOnMailingListLink() {
        functionLibrary.waitForElementPresent(mailingListLink);
        mailingListLink.click();
    }
    public void clickOnImportCatalog(){
        functionLibrary.waitForElementPresent(importCatalogLink);
        importCatalogLink.click();
    }
    public void clickOnExportCatalog(){
        functionLibrary.waitForElementPresent(exportCatalogLink);
        exportCatalogLink.click();
    }

    public void clickOnEmailLogLink() {
        functionLibrary.waitForElementPresent(emailLogLink);
        emailLogLink.click();
    }
    public void clickOnProductOptionLink(){
        functionLibrary.waitForElementPresent(productOptionLink);
        productOptionLink.click();
    public void clickOnReviewLink(){
        functionLibrary.waitForElementPresent(reviewLink);
        reviewLink.click();
    }


    public void clickOnManufactureLink() {
        functionLibrary.waitForElementPresent(manufactureLink);
        manufactureLink.click();
    }



    public void clickOnPromotionalCodes() {
        functionLibrary.waitForElementPresent(promotionalCodes);
        promotionalCodes.click();
    }


    public void logout() {
        driver.findElement(By.cssSelector(".fa.fa-sign-out")).click();
    }

    public void clickOnProductOptionLink() {
    }

    public void clickOnProductsLink() {
    }

    public void clickOnPromotionalCodes() {
    }

    public void clickOnExportCatalog() {
    }

    public void clickOnImportCatalog() {
    }

    public void clickOnManufactureLink() {
    }
}