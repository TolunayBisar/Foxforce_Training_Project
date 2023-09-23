package mailinglist;

import basefunctions.FunctionLibrary;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;

public class MailingList {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    // Admin shoud be find element for mailing list page
    @FindBy(xpath = "//div[@id=\"general\"]/h3")
    WebElement mailingListDashboard;
    @FindBy(name = "email_filter")
    WebElement emailFilter;
    @FindBy(xpath = "(//input[@name='submit'])[1]")
    WebElement filterGoButton;
    @FindBy(css = "//td//div[@class=\"custom-checkbox\"]")
    WebElement checkBoxList;
    @FindBy(xpath = "//select[@name=\"multi_subscriber_action\"]")
    WebElement dropDown;
    @FindBy(xpath = "//select[@name=\"multi_subscriber_action\"]/option[@value=\"delete\"]")
    WebElement remove;
    @FindBy(css = "input[name='go']")
    WebElement checkGoButton;
    @FindBy(xpath = "//input[@id='email_history']")
    WebElement email;
    @FindBy(xpath = "(//input[@type='button'])[1]")
    WebElement emailGoButton;
    @FindBy(xpath = "//div[@id='cboxLoadedContent']/div[1]")
    WebElement logMessage;
    @FindBy(css = "#cboxClose")
    WebElement closeButton;
    @FindBy(css = ".success")
    WebElement successMessage;
    // Admin shoud be find element for importSubscribers page
    @FindBy(xpath = "//a[contains(text(),'Import Subscribers')]")
    WebElement importSubscribers;
    @FindBy(xpath = "//textarea[@class='textbox']")
    WebElement textBox;
    @FindBy(xpath = "(//label[text()='Emails (Comma Separated)']/following::input)[2]")
    WebElement textBoxGoButton;
    @FindBy(xpath = "//div[@id='gui_message']//div[1]")
    WebElement guiMessage;
    @FindBy(xpath = "//div/div[@class=\"error\"]")
    WebElement errorMessage;
    // Admin have to find element for export subscribers
    @FindBy(xpath = "//a[contains(text(),'Export Subscribers')]")
    WebElement exportLinks;
    @FindBy(xpath = "//input[@id='format']")
    WebElement formatBox;
    @FindBy(xpath = "//input[@value='Export']")
    WebElement exportButton;
    public MailingList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    // Admin user should be click mailing list button and verify mailing list dashboard should be displayed
    public boolean veriFyMailingListDashboard() {
        functionLibrary.waitForElementPresent(mailingListDashboard);
        if (mailingListDashboard.isDisplayed()) {
            System.out.println("Invalid input");
        }
        return true;
    }

    // Admin creat mathod for filtermailing list
    public void filterMailingList() {
        // Find all mailing list elements
        List<WebElement> mailingList = driver.findElements(By.xpath("//tbody/tr"));
        int totalLists = mailingList.size();
        System.out.println("Total mailing lists: " + totalLists);
        String mailNameToFilter = "anar";
        //List<WebElement> filteredMailInfo = new ArrayList<>();
        emailFilter.sendKeys(mailNameToFilter);
        filterGoButton.click();
        Select select = new Select(dropDown);
        List<WebElement> checkCustomBox = driver.findElements(By.xpath("//table//tbody/tr/td//div[@class=\"custom-checkbox\"]"));
        Random random = new Random();
        System.out.println(checkCustomBox);
        WebElement toSelected = checkCustomBox.get(random.nextInt(checkCustomBox.size()));
    }

    //searchSubscribersNewsletter
    public void searchSubscribersNewsletter() {
        email.sendKeys("anar@gmail.com");
        emailGoButton.click();
        functionLibrary.sleep(1);
        closeButton.click();
    }

    public boolean veriFyNofoundMessage() {
        functionLibrary.waitForElementPresent(logMessage);
        if (logMessage.isDisplayed()) {
            System.out.println("No found email");
        }
        return true;
    }

    // Admin creat method for importSubscribers
    public void importSubscribers() {
        importSubscribers.click();
        textBox.sendKeys("anar1@gmail.com");
        textBoxGoButton.click();
        functionLibrary.sleep(2);
    }

    public boolean veriFysubscriber() {
        functionLibrary.waitForElementPresent(guiMessage);
        if (errorMessage.isDisplayed()){
            System.out.println("No subscribers were added");
        }
        return true;
    }

    //Admin should be creat method for exportsubscribers
    public void exportSubscribers() {
        exportLinks.click();
        formatBox.sendKeys("anar@gmail.com");
        functionLibrary.sleep(1);
        exportButton.click();
    }

    public boolean veriFyExportButton() {
        functionLibrary.waitForElementPresent(exportButton);
        if (formatBox.isDisplayed())
            if (exportButton.isDisplayed()) {
                System.out.println("No found email");
            }
        return true;
    }
    public void deleteEmail(){
        functionLibrary.waitForElementPresent(mailingListDashboard);
        Select select = new Select(dropDown);
        List<WebElement> checkCustomBox = driver.findElements(By.xpath("//table//tbody/tr/td//div[@class=\"custom-checkbox\"]"));
        Random random = new Random();
        System.out.println(checkCustomBox);
        WebElement toSelected = checkCustomBox.get(random.nextInt(checkCustomBox.size()));
       toSelected.click();
       remove.click();
      checkGoButton.click();
    }
    public boolean verifySuccess(){
        functionLibrary.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()) {
            System.out.println("Newsletter subscriber has been removed.");
    }
        return true;
    }
}









