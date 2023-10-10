package inventory;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**@Description all method which I use:
 * addParentCategory(String categoryName)
 * addSubCategoryToParentCategory(String subCategoryName, String parentCategoryName)
 * listOfProductsOfThisCategory(String categoryName)
 * editCategory(String categoryName)
 * deleteCategory(int itemId)
 * @author sherzat
 * @date   2023/10/9
 * WebElement element = driver.findElement(By.id("uploadhere"));
 * element.sendKeys("C:\\Some_Folder\\MyFile.txt")
 */

public class CategoriesPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }
    @FindBy(linkText = "Categories")
    WebElement categories;
    @FindBy(linkText = "Add Category")
    WebElement addCategory;
    @FindBy(xpath = "//input[@name='cat[status]']/following-sibling::img")
    WebElement status;
    @FindBy(xpath = "//input[@name='cat[visible]']/following-sibling::img")
    WebElement visible;
    @FindBy(id = "name")
    WebElement categoryName;
    @FindBy(id = "parent")
    WebElement parentCategory;
    @FindBy(linkText = "Description")
    WebElement description;
    @FindBy(css = ".cke_editable")
    WebElement input;
    @FindBy(linkText = "Images")
    WebElement image;
    @FindBy(xpath = "//img[@class='checkbox unique fmtoggle']")
    WebElement imageBox;
    @FindBy(id = "fm-icf")
    WebElement createFolder;
    @FindBy(linkText = "Select File")
    WebElement selectFile;
    @FindBy(linkText = "Search Engines")
    WebElement searchEngines;
    @FindBy(id = "seo_meta_title")
    WebElement metaTitle;
    @FindBy(id = "seo_path")
    WebElement seoPath;
    @FindBy(id = "seo_meta_description")
    WebElement metaDescription;
    @FindBy(id="cat_save")
    WebElement saveButton;


}
