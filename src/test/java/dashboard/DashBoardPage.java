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

    public void clickONOrderLink() {
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

    public void logout() {
        driver.findElement(By.cssSelector(".fa.fa-sign-out")).click();
    }
}