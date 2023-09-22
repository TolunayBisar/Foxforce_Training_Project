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

    public MailingList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }
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
    @FindBy(css = ".success")
    WebElement successMessage;

    // Admin shoud be find element for importSubscribers page
    @FindBy(xpath= "//a[contains(text(),'Import Subscribers')]")
    WebElement importSubscribers;
    @FindBy(xpath = "//textarea[@class='textbox']")
    WebElement textBox;
    @FindBy(xpath = "((//input[@name='previous-tab']/following-sibling::input)[1]")
    WebElement textBoxGoButton;
    @FindBy(xpath = "//div[@id='gui_message']//div[1]")
    WebElement guiMessage;

    // Admin have to find element for export subscribers
    @FindBy(linkText = "Export Subscribers")
    WebElement exportLinks;
    @FindBy(xpath = "//input[@id='format']")
    WebElement formatBox;
    @FindBy(xpath = "//input[@value='Export']")
    WebElement exportButton;

    //Newsletter subscriber has been removed.
    // Admin user should be click mailing list button and verify mailing list dashboard should be displayed
    public boolean veriFyMailingListDashboard() {
        functionLibrary.waitForElementPresent(mailingListDashboard);
        if (mailingListDashboard.isDisplayed() && mailingListDashboard.getText().contains("mailing List")) {
            System.out.println("Mailing list Dashboard page open...");
            return true;
        } else {
            System.out.println("Mailing list Dashboard page not  open...");
        }
        return false;
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
//    public void searchSubscribersNewsletter() {
//        email.sendKeys("Anar@gmail.com");
//        exportButton.click();
//    }
//    public boolean veriFyNoLogsFound() {
//        functionLibrary.waitForElementPresent(logMessage);
//        if (logMessage.isDisplayed() && logMessage.getText().contains("No logs found")) {
//            System.out.println("No logs found");
//            return true;
//        } else {
//            System.out.println("No logs found not dislpley ");
//        }
//        return false;
//    }

//    //  Admin creat method for importSubscribers
//    public void importSubscribers(){
//        textBox.sendKeys("Anar1@gmail.com");
//        textBoxGoButton.click();
//    }
//    public boolean subscriberAdded() {
//        functionLibrary.waitForElementPresent(guiMessage);
//        if (guiMessage.isDisplayed() && guiMessage.getText().contains("subscriber has been added")) {
//            System.out.println("subscriber has been added");
//            return true;
//        } else {
//            System.out.println("subscriber has been not added");
//        }
//        return false;
//    }
//    //Admin should be creat method for exportsubscribers
//public void exportSubscribers(){
//       formatBox.sendKeys("Anar@gmail.com");
//       exportButton.click();
//}
//

}








