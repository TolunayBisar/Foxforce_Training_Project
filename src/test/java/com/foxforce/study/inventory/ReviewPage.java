package com.foxforce.study.inventory;

import com.foxforce.study.basefunctions.FunctionLibrary;
import com.foxforce.study.cubecartobjects.ProductObjectClass;
import com.foxforce.study.dashboard.DashBoardPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReviewPage {
    WebDriver driver;

    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Faker faker = new Faker();
    ProductObjectClass productObjectClass;
    @FindBy(css = "div[id='reviews'] h3")
    WebElement productReviewsPage;
    @FindBy(linkText = "Add review")
    WebElement addReviewMenuTab;
    @FindBy(xpath = "//input[@id=\"ajax_name\"]")
    WebElement productOfAddReview;
    @FindBy(xpath = "//span[@class=\"jqac-link\"]")
    WebElement productDropDown;
    @FindBy(css = "div.jqac-menu ul li span[name=\"1\"] em")
    WebElement productToSelect;
    @FindBy(css = ".checkbox.cbs")
    WebElement statusOfAddReview;
    @FindBy(css = "#review_name")
    WebElement reviewsName;
    @FindBy(css = "#review_email")
    WebElement reviewsEmail;
    @FindBy(css = "#review_title")
    WebElement reviewsTitle;
    @FindBy(css = "#review_content")
    WebElement reviewsContent;
    @FindAll(
            @FindBy(css = "span.star-rating-control div.star-rating"))
    List<WebElement> stars;
    @FindBy(css = ".submit")
    WebElement submitOFReview;
    @FindAll(
            @FindBy(css = "div#gui_message div.success")
    )
    List<WebElement> successMessage;
    @FindBy(xpath = "//i[@title=\"Edit\"]")
    WebElement editOfReview;
    @FindBy(xpath = "//div[@class=\"note\"]//div[@class=\"custom-checkbox\"]")
    WebElement cheakBoxOfReview;
    @FindBy(xpath = "//input[@name=\"go\"]")
    WebElement goButton;
    @FindBy(xpath = "fa fa-trash")
    WebElement deleteOfReview;
    @FindBy(linkText = "Bulk Delete")
    WebElement bulkDeleteLink;
    @FindBy(name = "delete[email]")
    WebElement emailOFBulkDelete;
    @FindBy(name = "delete[ip_address]")
    WebElement ipAddressOfBulkDelete;
    @FindBy(xpath = "//input[@class=\"submit\"]")
    WebElement submitOfBulkDelete;
    @FindBy(linkText = "Search")
    WebElement searchLink;
    @FindBy(css = "#search-keywords")
    WebElement keywordsOfSearch;
    @FindBy(className = "filter[product_string]")
    WebElement filterByProduct;
    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitOfSearchPage;

    public ReviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
        productObjectClass = new ProductObjectClass();
    }

    public boolean verifyReviewPageDashboard() {
        functionLibrary.waitForElementPresent(productReviewsPage);
        if (productReviewsPage.isDisplayed()) {
            System.out.println("Invalid input");
        }
        return true;
    }

    public boolean addReview() {
        functionLibrary.waitForElementPresent(addReviewMenuTab);
        addReviewMenuTab.click();
        functionLibrary.waitForElementPresent(productOfAddReview);
        //productOfAddReview.sendKeys(productObjectClass.getProductCode());
        productOfAddReview.sendKeys("A1965");
        // productOfAddReview.sendKeys(productObjectClass.getProductName());
        functionLibrary.waitForElementPresent(productDropDown);
        productDropDown.click();
        functionLibrary.sleep(1);
        statusOfAddReview.click();
        functionLibrary.waitForElementPresent(reviewsName);
        reviewsName.sendKeys(functionLibrary.generateFakeNames());
        functionLibrary.waitForElementPresent(reviewsEmail);
        reviewsEmail.sendKeys(functionLibrary.generateFakeEmail());
        functionLibrary.waitForElementPresent(reviewsTitle);
        reviewsTitle.sendKeys("God product");
        reviewsContent.sendKeys("The product  is very useful");
        int i = 1;
        for (WebElement star : stars) {
            if (i > 3) {
                break;
            } else {
                star.click();
            }
            i++;
        }
        functionLibrary.waitForElementPresent(submitOFReview);
        submitOFReview.click();
        if (!successMessage.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean editProductReview() {
        //  driver.findElement(By.xpath(String.format("//a[text()=\"%s\"]/parent::div/preceding-sibling::span/a[@class=\"edit\"]",productObjectClass.getProductName()))).click();
        driver.findElement(By.xpath("//h3[text()='Product Reviews']/following-sibling::div//i[@title='Edit']")).click();

        functionLibrary.waitForElementPresent(reviewsContent);
        reviewsContent.clear();
        reviewsContent.sendKeys("Super product");
        int i = 1;
        for (WebElement star : stars) {
            if (i > 5) {
                break;
            } else {
                star.click();
            }
            // i++;
        }
        functionLibrary.waitForElementPresent(submitOFReview);
        submitOFReview.click();
        if (!successMessage.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void deleteProductReview() {
        functionLibrary.waitForElementPresent(cheakBoxOfReview);
        cheakBoxOfReview.click();
        functionLibrary.waitForElementPresent(goButton);
        goButton.click();
        driver.switchTo().alert().accept();
    }
    public boolean verifyDeleteMessage() {
        if (!successMessage.isEmpty()) {
            System.out.println("Reviews successfully deleted.");
        }
        return true;
    }
    //    public void bulkDelete() {
//        functionLibrary.waitForElementPresent(bulkDeleteLink);
//        bulkDeleteLink.click();
//        functionLibrary.waitForElementPresent(emailOFBulkDelete);
//        emailOFBulkDelete.sendKeys();
//
//    }
    public void searchOfReview() {
        functionLibrary.waitForElementPresent(searchLink);
        searchLink.click();
        functionLibrary.waitForElementPresent(keywordsOfSearch);
        keywordsOfSearch.sendKeys("super product");
        functionLibrary.waitForElementPresent(submitOfSearchPage);
        submitOfSearchPage.click();
    }
    public boolean verifySearchReview() {
        if (productReviewsPage.isDisplayed()) {
            System.out.println("Review product is searched");
        }
        return true;
    }
}


