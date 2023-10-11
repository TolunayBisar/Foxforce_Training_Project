package inventory;

import basefunctions.FunctionLibrary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
    WebElement categoryName1;
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
    @FindBy(linkText = "Go")
    WebElement goButton;
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
    public void addCategory(String categoryName){
        functionLibrary.waitForElementPresent(categories);
        categories.click();
        functionLibrary.waitForElementPresent(addCategory);
        addCategory.click();
        functionLibrary.waitForElementPresent(visible);
        visible.click();
        functionLibrary.waitForElementPresent(categoryName1);
        categoryName1.sendKeys(categoryName);
        Select selectParentCategory = new Select(parentCategory);
        selectParentCategory.selectByIndex(1);
        functionLibrary.waitForElementPresent(description);
        description.click();
        functionLibrary.waitForElementPresent(input);
        input.sendKeys();
        functionLibrary.waitForElementPresent(image);
        image.click();
        functionLibrary.waitForElementPresent(selectFile);
        createFolder.sendKeys("C:\\new.png");
        functionLibrary.waitForElementPresent(createFolder);
        createFolder.sendKeys();
        functionLibrary.waitForElementPresent(goButton);
        goButton.click();
        functionLibrary.waitForElementPresent(searchEngines);
        searchEngines.click();
        functionLibrary.waitForElementPresent(metaTitle);
        metaTitle.sendKeys();
        functionLibrary.waitForElementPresent(seoPath);
        seoPath.sendKeys();
        functionLibrary.waitForElementPresent(metaDescription);
        metaDescription.sendKeys();
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }
    public void addSubCategoryToParentCategory(String subCategoryName, String parentCategoryName){
        functionLibrary.waitForElementPresent(categories);
        categories.click();
        functionLibrary.waitForElementPresent(addCategory);
        addCategory.click();
        functionLibrary.waitForElementPresent(visible);
        visible.click();
        functionLibrary.waitForElementPresent(categoryName1);
        categoryName1.sendKeys(subCategoryName);
        Select selectParentCategory = new Select(parentCategory);
        selectParentCategory.selectByVisibleText(parentCategoryName);
        functionLibrary.waitForElementPresent(description);
        description.click();
        functionLibrary.waitForElementPresent(input);
        input.sendKeys();
        functionLibrary.waitForElementPresent(image);
        image.click();
        functionLibrary.waitForElementPresent(selectFile);
        createFolder.sendKeys("C:\\new.png");
        functionLibrary.waitForElementPresent(createFolder);
        createFolder.sendKeys();
        functionLibrary.waitForElementPresent(goButton);
        goButton.click();
        functionLibrary.waitForElementPresent(searchEngines);
        searchEngines.click();
        functionLibrary.waitForElementPresent(metaTitle);
        metaTitle.sendKeys();
        functionLibrary.waitForElementPresent(seoPath);
        seoPath.sendKeys();
        functionLibrary.waitForElementPresent(metaDescription);
        metaDescription.sendKeys();
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
    }


}
