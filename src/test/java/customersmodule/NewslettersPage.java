package customersmodule;


import basefunctions.FunctionLibrary;
import com.github.javafaker.Faker;
import cubecartobjects.NewsletterObject;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class NewslettersPage {
    WebDriver driver;
    DashBoardPage dashBoardPage;

    public NewslettersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dashBoardPage = new DashBoardPage(driver);
    }

    Select select;
    Faker faker = new Faker();
    FunctionLibrary functionLibrary = new FunctionLibrary(driver);
    Actions actions;

    String newsletterSubject = faker.commerce().department() + " by Alim";
    NewsletterObject newsletterObject = new NewsletterObject(
            newsletterSubject,
            functionLibrary.generateFakeNames(),
            functionLibrary.generateFakeEmail(),
            functionLibrary.readTextFile("src/test/java/customersmodule/htmlContent.txt"),
            functionLibrary.readTextFile("src/test/java/customersmodule/plainText.txt"),
            functionLibrary.generateFakeEmail()
    );
    @FindBy(xpath = "//a[contains(text(),\"Create Newsletter\")]")
    WebElement createNewsletterButton;
    @FindBy(css = "input#email_subject")
    WebElement newsLetterSubjectInputField;
    @FindBy(css = "input#sender_name")
    WebElement sendersNameInputField;
    @FindBy(css = "input#sender_email")
    WebElement sendersEmailAddressInputField;
    @FindBy(css = "select#template_id")
    WebElement templateDropDown;
    @FindBy(css = "div#tab_email_html a")
    WebElement htmlContentTab;
    @FindBy(css = "div#tab_email_text")
    WebElement plainTextContentTab;
    @FindBy(css = "span#cke_18_label")
    WebElement sourceButton;
    @FindBy(css = "iframe.cke_wysiwyg_frame.cke_reset")
    WebElement iframeInHtmlContentPage;
    @FindBy(css = "textarea.cke_source")
    WebElement htmlContentInputBox;
    @FindBy(css = "textarea#content_text")
    WebElement plainTextInputBox;
    @FindBy(css = "div#tab_send_test a")
    WebElement sendTestEmailTab;
    @FindBy(css = "input#email_test")
    WebElement recipientEmailInputBox;
    @FindBy(css = "input[value='Save & Send']")
    WebElement saveAndSendButtonInSendTestEmail;
    @FindAll(@FindBy(xpath = "//div[@id='newsletter-list']//tbody/tr/td/a"))
    List<WebElement> listOfNewsletters;
    @FindAll(@FindBy(css = "div#gui_message div.success"))
    List<WebElement> successfulMessage;
    @FindAll(@FindBy(xpath = "//table/tbody/tr"))
    List<WebElement> emailLogInformationList;
    @FindBy(xpath = "//input[@value=\"Save\"]")
    WebElement saveButton;


    Random random = new Random();
    String[] newsletterNameAndUrlArray = new String[2];

    public void createDefaultNewsletter() {
        dashBoardPage.clickOnNewsLettersLink();
        createNewsletterButton.click();
        actions = new Actions(driver);
        newsLetterSubjectInputField.sendKeys(newsletterObject.getNewsLetterSubject());
        sendersNameInputField.sendKeys(newsletterObject.getSenderName());
        sendersEmailAddressInputField.sendKeys(newsletterObject.getSenderEmail());
        select = new Select(templateDropDown);
        select.selectByValue("1");
        htmlContentTab.click();
        sourceButton.click();
        htmlContentInputBox.sendKeys(newsletterObject.getHtmlContent());
        plainTextContentTab.click();
        plainTextInputBox.sendKeys(newsletterObject.getPlainTextContent());
        sendTestEmailTab.click();
        recipientEmailInputBox.sendKeys("alimhamut.job@gmail.com");
        saveAndSendButtonInSendTestEmail.click();
    }

    public boolean verifyNewsletterSuccessfullyCreated() {
        boolean resultOfList = false;
        boolean resultOfCompare = false;
        if (!successfulMessage.isEmpty()) {
            resultOfList = true;
        }
        String newsletterName;
        for (WebElement newsletter : listOfNewsletters) {
            newsletterName = newsletter.getText();
            if (newsletterName.equalsIgnoreCase(newsletterSubject)) {
                resultOfCompare = true;
                break;
            }
        }
        if (resultOfList && resultOfCompare) {
            return true;
        } else {
            return false;
        }
    }

    public void sendNewsletter() {
        dashBoardPage.clickOnNewsLettersLink();
        for (WebElement newsletterElement : listOfNewsletters) {
            if (newsletterElement.getText().equalsIgnoreCase(newsletterSubject)) {
                newsletterElement.findElement(By.xpath("parent::td/following-sibling::td/span/a")).click();
                driver.switchTo().alert().accept();
                break;
            }
        }
    }
    public boolean verifyNewsletterSuccessfullySent() {
        dashBoardPage.clickOnNewsLettersLink();
        functionLibrary.sleep(100);
        boolean resultOfMessage = !successfulMessage.isEmpty();
        dashBoardPage.clickOnEmailLogLink();
        int i = 0;
        String emailAddressInEmailLog = null;
        String messageTypeString = null;
        Boolean messageType = false;
        for (WebElement information : emailLogInformationList) {
            if (i % 2 == 0) {
                emailAddressInEmailLog = information.findElement(By.xpath("td[3]/a")).getText();
            } else {
                messageTypeString = information.findElement(By.xpath("td")).getAttribute("class");
            }
            if (messageTypeString.contains("error")) {
                messageType = false;
            } else {
                messageType = true;
            }
            if (emailAddressInEmailLog.equalsIgnoreCase(newsletterObject.getSenderEmail())) {
                break;
            }
            i++;
        }
        if (resultOfMessage && messageType) {
            return true;
        } else {
            return false;
        }
    }

    public void editNewsletter() {
        dashBoardPage.clickOnNewsLettersLink();
        int indexOfNewsLetterToEdit = random.nextInt(listOfNewsletters.size());
        WebElement newsletterSubjectElementToEdit = listOfNewsletters.get(indexOfNewsLetterToEdit);
        newsletterNameAndUrlArray[0]  = newsletterSubjectElementToEdit.getText();
        newsletterNameAndUrlArray[1] = listOfNewsletters.get(indexOfNewsLetterToEdit).getAttribute("href");
                newsletterSubjectElementToEdit.click();
        newsLetterSubjectInputField.clear();
        newsLetterSubjectInputField.sendKeys(newsletterNameAndUrlArray[0] + " !!!updated!!!");
        saveButton.click();
        System.out.println("The name of Newsletter to edit is : "+ newsletterNameAndUrlArray[0]);
        System.out.println("The url of Newsletter to edit is : "+ newsletterNameAndUrlArray[1]);
    }
    public Boolean verifyNewsletterSuccessfullyEdit(){
        return !successfulMessage.isEmpty();
    }

    public void deleteNewsletter() {
        dashBoardPage.clickOnNewsLettersLink();
        int indexOfDeletedNewsLetter = random.nextInt(listOfNewsletters.size());
        newsletterNameAndUrlArray[0] = listOfNewsletters.get(indexOfDeletedNewsLetter).getText();
        newsletterNameAndUrlArray[1] = listOfNewsletters.get(indexOfDeletedNewsLetter).getAttribute("href");
        System.out.println("The name of Newsletter to delete is : "+newsletterNameAndUrlArray[0]);
        System.out.println("The address of Newsletter to delete is : "+newsletterNameAndUrlArray[1]);
        WebElement deleteIconOfNewsletterToDelete = driver.findElement(
                By.xpath(String.format("//div[@id='newsletter-list']//tbody/tr[%d]/td/span/a[last()]", indexOfDeletedNewsLetter + 1)));
        deleteIconOfNewsletterToDelete.click();
        driver.switchTo().alert().accept();
    }

    public boolean verifyNewsletterSuccessfullyDeleted() {
        int i = 1, a = 10;
        for (WebElement deletedNewsletterElement : listOfNewsletters) {
            if (deletedNewsletterElement.getAttribute("href").equalsIgnoreCase(newsletterNameAndUrlArray[1])) {
                a = 0;
                break;
            }
            if (i == listOfNewsletters.size()) {
                a = 1;
                break;
            }
            i++;
        }
        if (a == 1 && !successfulMessage.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
