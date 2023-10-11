package inventory;

import basefunctions.FunctionLibrary;
import com.github.javafaker.Faker;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReviewPage {
    WebDriver driver;

    public ReviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }

    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Faker faker = new Faker();
    @FindBy (xpath = "//h3[normalize-space()='Product Reviews']")
    WebElement productReviewsPage;
    @FindBy(xpath = "//a[normalize-space()='Add review']")
    WebElement addReviewMenuTab;
    @FindBy(className= "textbox ajax not-empty")
    WebElement productOfAddReview;
    @FindBy(className = "checkbox cbs")
    WebElement statusOfAddReview;
    @FindBy(css = "#review_name")
    WebElement reviewName;
    @FindBy(css = "#review_email")
    WebElement reviewEmail;
    @FindBy(css = "#review_title")
    WebElement reviewTitle;
    @FindBy(css = "#review_content")
    WebElement reviewContent;
    @FindAll(
            @FindBy(xpath = "span.star-rating-control div.star-rating"))
    List<WebElement> stars;
    @FindBy(css = ".submit")
    WebElement submitOFReview;
    @FindBy(xpath = "//i[@title=\"Edit\"]")
    WebElement editOfReview;
    @FindBy(xpath = "fa fa-trash")
    WebElement deleteOfReview;
    @FindBy(linkText = "Bulk Delete")
    WebElement bulkDeleteLink;
    @FindBy(name ="delete[email]" )
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


    public boolean verifyMailingListDashboard() {
        functionLibrary.waitForElementPresent(productReviewsPage);
        if (productReviewsPage.isDisplayed()) {
            System.out.println("Invalid input");
        }
        return true;
    }

    public void addReview(String productName){
        functionLibrary.waitForElementPresent(addReviewMenuTab);
        addReviewMenuTab.click();
        productOfAddReview.sendKeys("C#");
        statusOfAddReview.click();
        reviewName.sendKeys("Anar");
        reviewEmail.sendKeys("simruh3699@gmail.com");
        reviewTitle.sendKeys("Super god");
        reviewContent.sendKeys("The C # bok is very usefully");
        List<WebElement> starsButton = driver.findElements(By.xpath(stars.toString()));
        for (int  i=0; i < 3; i++) {
            break;
        }
        }


    public void editProductReview(){

    }
    public void deleteProductReview(){

    }
    public void bulkDelete(){

    }
    public void Search(String keyword){

    }
}


