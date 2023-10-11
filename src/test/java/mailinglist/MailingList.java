package mailinglist;

import basefunctions.FunctionLibrary;
import com.github.javafaker.Faker;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class MailingList {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Faker faker = new Faker();
    // Admin shoud be find element for mailing list page
    @FindBy(xpath = "//div[@id=\"general\"]/h3")
    WebElement mailingListDashboard;
    @FindBy(name = "email_filter")
    WebElement emailFilterInputBoxInMailingList;
    @FindBy(xpath = "(//input[@name='submit'])[1]")
    WebElement emailFilterGoButton;
    @FindBy(css = "//td//div[@class=\"custom-checkbox\"]")
    WebElement checkBoxList;
    @FindBy(xpath = "//select[@name=\"multi_subscriber_action\"]")
    WebElement dropDownInMailingList;
    @FindBy(css = "input[name='go']")
    WebElement checkBoxGoButton;
    @FindBy(xpath = "//input[@id='email_history']")
    WebElement sentEmailBoxForSearchSubscriber;
    @FindBy(xpath = "(//input[@type='button'])[1]")
    WebElement sentEmailBoxGoButton;
    @FindBy(xpath = "//div[@id='cboxLoadedContent']/div[1]")
    WebElement logForEmailMessage;
    @FindBy(css = "#cboxClose")
    WebElement closeButtonForLogMessage;

    @FindBy(xpath = "//a[contains(text(),'Import Subscribers')]")
    WebElement importSubscribersTab;
    @FindBy(xpath = "//textarea[@class='textbox']")
    WebElement textBoxInImportSubscribers;
    @FindBy(xpath = "//div[@class=\"form_control\"]/input[@value=\"Go\"]")
    WebElement goButtonInImportSubscribers;
    @FindAll(
            @FindBy(xpath = "//div[@id=\"gui_message\"]/div[@class=\"success\"]"))
    List<WebElement> guiMessages;

    @FindBy(xpath = "//a[contains(text(),'Export Subscribers')]")
    WebElement exportLinks;
    @FindBy(xpath = "//input[@id='format']")
    WebElement formatBox;
    @FindBy(xpath = "//input[@value='Export']")
    WebElement exportButton;
    String emailAddress = faker.internet().emailAddress();

    public MailingList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    // Admin user should be click mailing list button and verify mailing list dashboard should be displayed
    public boolean verifyMailingListDashboard() {
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
        emailFilterInputBoxInMailingList.sendKeys(mailNameToFilter);
        emailFilterGoButton.click();
        //Select select = new Select(dropDownInMailingList);
        List<WebElement> checkCustomBox = driver.findElements(By.xpath("//table//tbody/tr/td//div[@class=\"custom-checkbox\"]"));
        Random random = new Random();
        System.out.println(checkCustomBox);
        WebElement toSelected = checkCustomBox.get(random.nextInt(checkCustomBox.size()));
    }

    //searchSubscribersNewsletter
    public void searchSubscribersNewsletter() {
        sentEmailBoxForSearchSubscriber.sendKeys(emailAddress);
        sentEmailBoxGoButton.click();
        functionLibrary.sleep(1);
        closeButtonForLogMessage.click();
    }

    public boolean verifyNoFoundMessage() {
        functionLibrary.waitForElementPresent(logForEmailMessage);
        if (logForEmailMessage.isDisplayed()) {
            System.out.println("No found email");
        }
        return true;
    }

    // Admin creat method for importSubscribers
    public void importSubscribers() {
        importSubscribersTab.click();
        textBoxInImportSubscribers.sendKeys(emailAddress);
        goButtonInImportSubscribers.click();
        functionLibrary.sleep(2);
    }

    public boolean verifySuccessfullyImportSubscriber() {
        if (!guiMessages.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //Admin should be creat method for exportsubscribers
    public void exportSubscribers() {
        exportLinks.click();
        formatBox.sendKeys(emailAddress);
        functionLibrary.sleep(1);
        exportButton.click();
    }

    public boolean verifyExportButton() {
        functionLibrary.waitForElementPresent(exportButton);
        if (formatBox.isDisplayed())
            if (exportButton.isDisplayed()) {
                System.out.println("No found email");
            }
        return true;
    }

    public void deleteEmail() {
        functionLibrary.waitForElementPresent(mailingListDashboard);
        Select select = new Select(dropDownInMailingList);
        List<WebElement> checkCustomBox = driver.findElements(By.xpath("//table//tbody/tr/td//div[@class=\"custom-checkbox\"]"));
        Random random = new Random();
        WebElement toSelected = checkCustomBox.get(random.nextInt(checkCustomBox.size()));
        toSelected.click();
        select.selectByVisibleText("Remove");
        checkBoxGoButton.click();
    }

    public boolean verifyEmailSuccessfullyDeletedFromMailingList() {
        if (!guiMessages.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}









