package inventory;

import basefunctions.FunctionLibrary;
import com.github.javafaker.Faker;
import cubecartobjects.ProductObjectClass;
import dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;

/**
 * @author : Alim Hamut
 * @created : 2023-10-16,10:08 p.m.
 * @Email : alimhamut.job@gmail.com
 **/
public class ProductsPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='tab']/a[text()='Add Product']")
    WebElement addProductTab;
    @FindBy(xpath = "//input[@id='product_status']")
    WebElement status;
    @FindBy(css = "input#name")
    WebElement productNameInputBox;
    @FindBy(css = "select#manufacturer")
    WebElement brandDropDown;
    @FindAll(@FindBy(css = "select#manufacturer option[value*='1']"))
    List<WebElement> brandsList;
    @FindBy(css = "select#condition")
    WebElement conditionDropDown;
    @FindAll(@FindBy(css = "select#condition option"))
    List<WebElement> conditionsList;
    @FindBy(css = "input#product_code")
    WebElement productCodeInputBox;
    @FindBy(xpath = "//input[@id='product_code_auto']")
    WebElement automaticallyGenerateProductCodeCheckBox;
    @FindBy(css = "input#product_weight")
    WebElement productWeightInputBox;
    @FindBy(css = "select#dimension_unit")
    WebElement dimensionUnitDropDown;
    @FindAll(@FindBy(css = "select#dimension_unit option"))
    List<WebElement> dimensionUnitList;
    @FindBy(css = "input#product_width")
    WebElement productWidthInputBox;
    @FindBy(css = "input#product_height")
    WebElement productHeightInputBox;
    @FindBy(css = "input#product_depth")
    WebElement productDepthInputBox;
    @FindBy(xpath = "//input[@id='product_featured']")
    WebElement includeInFeaturedProductsCheckBox;
    @FindBy(xpath = "//input[@id='product_latest']")
    WebElement includeInLatestProductsCheckBox;
    @FindBy(xpath = "//input[@id='available']")
    WebElement availableForPurchaseCheckBox;
    @FindBy(xpath = "//input[@id='use_stock_level']")
    WebElement useStockLevelCheckBox;
    @FindBy(css = "input#stock_level")
    WebElement stockLevelInputBox;
    @FindBy(css = "input#stock_warning")
    WebElement stockLevelWarningInputBox;
    @FindBy(css = "input#upc")
    WebElement upcCodeInputBox;
    @FindBy(css = "input#ean")
    WebElement eanCodeInputBox;
    @FindBy(css = "input#jan")
    WebElement janCodeInputBox;
    @FindBy(css = "input#isbn")
    WebElement isbnCodeInputBox;
    @FindBy(css = "input#gtin")
    WebElement gtinCodeInputBox;
    @FindBy(css = "input#mpn")
    WebElement mpnCodeInputBox;
    @FindBy(xpath = "//div[@id=\"google_category_chosen\"]")
    WebElement googleCategoryDropDown;
    @FindAll(@FindBy(css = "div.chosen-drop ul li"))
    List<WebElement> googleCategoryList;
    @FindBy(css = "div.chosen-drop div input")
    WebElement googleCategoryInputBox;
    @FindBy(css = "ul.chosen-results li em")
    WebElement googleCategoryElementToSelect;
    //******************DescriptionTab***********************
    @FindBy(css = "div#tab_description")
    WebElement descriptionTab;
    @FindBy(css = "iframe.cke_wysiwyg_frame.cke_reset[title=\"Rich Text Editor, description\"]")
    WebElement descriptionFrame;
    @FindBy(css = "body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders")
    WebElement descriptionInputBox;
    @FindBy(css = "iframe.cke_wysiwyg_frame.cke_reset[title=\"Rich Text Editor, description_short\"]")
    WebElement shortDescriptionFrame;
    //*********************Pricing***************************
    @FindBy(css = "div#tab_pricing")
    WebElement pricingTab;
    @FindBy(css = "div#group_0 input#price")
    WebElement retailPriceInputBox;
    @FindBy(css = "div#group_0 input#sale_price")
    WebElement salePriceInputBox;
    @FindBy(css = "div#group_0 input#cost_price")
    WebElement costPriceInputBox;
    @FindBy(xpath = "//div[@id=\"group_0\"]//input[@id=\"cost_price\"]/parent::span/parent::div/following-sibling::div//select")
    WebElement taxClassDropDown;
    @FindAll(@FindBy(xpath = "//div[@id=\"group_0\"]//input[@id=\"cost_price\"]/parent::span/parent::div/following-sibling::div//select/option"))
    List<WebElement> taxClassList;
    @FindBy(xpath = "//input[@id=\"tax_inclusive\"]")
    WebElement taxIncludedCheckBox;
    @FindBy(xpath = "//input[@id=\"minimum_quantity\"]")
    WebElement minimumQuantityPurchaseInputBox;
    @FindBy(xpath = "//input[@id=\"maximum_quantity\"]")
    WebElement maximumQuantityPurchaseInputBox;
    @FindBy(xpath = "//div[@id=\"group_0\"]//input[@class=\"editable textbox number not-empty\"]")
    WebElement quantityInputBox;
    @FindBy(xpath = "//div[@id=\"group_0\"]//input[@class=\"editable textbox number not-empty\"]/parent::td/following-sibling::td/input")
    WebElement priceOfAQuantityInputBox;
    @FindBy(xpath = "//div[@id=\"group_0\"]//input[@class=\"editable textbox number not-empty\"]/parent::td/following-sibling::td/span/a/i")
    WebElement addButton;
    //*********************Categories***************************
    @FindBy(css = "div#tab_category")
    WebElement categoriesTab;
    @FindBy(xpath = "//td[text()=\"Test Category\"]/preceding-sibling::td/input[@name=\"primary_cat\"]")
    WebElement categoryPrimaryCheckBox;
    //*********************Options***************************
    @FindBy(css = "div#tab_Options")
    WebElement optionsTab;
    //*********************Images***************************
    @FindBy(css = "div#tab_image")
    WebElement imagesTab;
    @FindBy(css = "div#imageset+div input")
    WebElement createFolderForImagesInputBox;
    @FindBy(css = "div#imageset+div button")
    WebElement goButtonForImages;
    @FindBy(xpath = "//span[text()=\"Select File\"]")
    WebElement selectFileButton;
    //*********************Digital***************************
    @FindBy(css = "div#tab_digital")
    WebElement digitalTab;
    @FindBy(css = "div#digital input#fm-icf")
    WebElement createFolderForDigitalInputBox;
    @FindBy(css = "div#digital input#fm-icf+button")
    WebElement goButtonForDigital;
    //*********************search Engines***************************
    @FindBy(css = "div#tab_seo")
    WebElement searchEnginesTab;
    @FindBy(css = "input#seo_meta_title")
    WebElement metaTitleInputBox;
    @FindBy(css = "input#seo_path")
    WebElement seoPathInputBox;
    @FindBy(css = "textarea#seo_meta_description")
    WebElement metaDescriptionInputBox;
    @FindBy(css = "input[value=\"Save\"]")
    WebElement saveButton;
    @FindAll(@FindBy(css = "div#gui_message div.success"))
    List<WebElement> successMessage;
    DashBoardPage dashBoardPage;
    ProductObjectClass productObject;
    FunctionLibrary functionLibrary;
    Select select;
    String disable = "arguments[0].setAttribute('value','0')";
    String enable = "arguments[0].setAttribute('value','1')";
    String checkBoxEnabled = "arguments[0].setAttribute('src','admin_zolscu/skins/default/images/1_checkbox.png')";
    String checkBoxDisabled = "arguments[0].setAttribute('src','admin_zolscu/skins/default/images/0_checkbox.png')";
    String automaticallyGenerateProductCodeCheckBoxDisabled = "src=\"admin_zolscu/skins/default/images/0_checkbox.png\"";
    Faker faker;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dashBoardPage = new DashBoardPage(driver);
        productObject = new ProductObjectClass();
        faker = new Faker(new Locale("de"));
        functionLibrary = new FunctionLibrary(driver);
    }

    public boolean addProduct() {
        dashBoardPage.clickOnProductsLink();
        addProductTab.click();
        //******************************************
        productObject.setStatus(faker.bool().bool());
        if (productObject.isStatus()) {
            ((JavascriptExecutor) driver).executeScript(enable, status);
            ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, status.findElement(By.xpath("following-sibling::img")));
        } else {
            ((JavascriptExecutor) driver).executeScript(disable, status);
            ((JavascriptExecutor) driver).executeScript(checkBoxDisabled, status.findElement(By.xpath("following-sibling::img")));
        }
        //******************************************
        productObject.setProductName(faker.commerce().productName());
        productNameInputBox.sendKeys(productObject.getProductName());
        System.out.println(productObject.getProductName());
        //******************************************
        //productObject.setBrand(brandsList.get(Brand.getBrand()));
        productObject.setBrand(brandsList.get(faker.random().nextInt(brandsList.size())).getText());
        select = new Select(brandDropDown);
        select.selectByVisibleText(productObject.getBrand());
        //******************************************
        select = new Select(conditionDropDown);
        productObject.setCondition(conditionsList.get(faker.random().nextInt(conditionsList.size())).getText());
        select.selectByVisibleText(productObject.getCondition());
        //******************************************+img
        productObject.setProductCode("Prod" + faker.number().numberBetween(1000000, 9999999));
        productCodeInputBox.sendKeys(productObject.getProductCode());
        //******************************************
        ((JavascriptExecutor) driver).executeScript(disable, automaticallyGenerateProductCodeCheckBox);
        ((JavascriptExecutor) driver).executeScript(automaticallyGenerateProductCodeCheckBoxDisabled, automaticallyGenerateProductCodeCheckBox.findElement(By.xpath("following-sibling::img")));
        //******************************************
        int max = 999, min = 100;
        int integerPart = faker.random().nextInt(min, max);
        double decimalPart = (double) min / integerPart;
        productObject.setProductWeight(String.format("%.2f", integerPart + decimalPart));
        productWeightInputBox.sendKeys(productObject.getProductWeight());
        //******************************************
        select = new Select(dimensionUnitDropDown);
        productObject.setDimensionUnit(dimensionUnitList.get(faker.random().nextInt(dimensionUnitList.size())).getText());
        select.selectByVisibleText(productObject.getDimensionUnit());
        //******************************************
        integerPart = faker.random().nextInt(min / 10, max / 9);
        productObject.setProductWidth(String.format("%d", integerPart));
        productWidthInputBox.sendKeys(productObject.getProductWidth());
        //******************************************
        integerPart = faker.random().nextInt(min / 10, max / 9);
        productObject.setProductHeight(String.format("%d", integerPart));
        productHeightInputBox.sendKeys(productObject.getProductHeight());
        //******************************************
        integerPart = faker.random().nextInt(min / 10, max / 9);
        productObject.setProductDepth(String.format("%d", integerPart));
        productDepthInputBox.sendKeys(productObject.getProductDepth());
        //******************************************
        productObject.setIncludeInFeaturedProducts(faker.bool().bool());
        if (productObject.isIncludeInFeaturedProducts()) {
            ((JavascriptExecutor) driver).executeScript(enable, includeInFeaturedProductsCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, includeInFeaturedProductsCheckBox.findElement(By.xpath("following-sibling::img")));
        } else {
            ((JavascriptExecutor) driver).executeScript(disable, includeInFeaturedProductsCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxDisabled, includeInFeaturedProductsCheckBox.findElement(By.xpath("following-sibling::img")));
        }
        //******************************************
        productObject.setIncludeInLatestProducts(faker.bool().bool());
        if (productObject.isIncludeInLatestProducts()) {
            ((JavascriptExecutor) driver).executeScript(enable, includeInLatestProductsCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, includeInLatestProductsCheckBox.findElement(By.xpath("following-sibling::img")));
        } else {
            ((JavascriptExecutor) driver).executeScript(disable, includeInLatestProductsCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxDisabled, includeInLatestProductsCheckBox.findElement(By.xpath("following-sibling::img")));
        }
        //******************************************
        productObject.setAvailableForPurchase(faker.bool().bool());
        if (productObject.isAvailableForPurchase()) {
            ((JavascriptExecutor) driver).executeScript(enable, availableForPurchaseCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, availableForPurchaseCheckBox.findElement(By.xpath("following-sibling::img")));
        } else {
            ((JavascriptExecutor) driver).executeScript(disable, availableForPurchaseCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxDisabled, availableForPurchaseCheckBox.findElement(By.xpath("following-sibling::img")));
        }
        //******************************************
        productObject.setUseStockLevel(faker.bool().bool());
        if (productObject.isUseStockLevel()) {
            ((JavascriptExecutor) driver).executeScript(enable, useStockLevelCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, useStockLevelCheckBox.findElement(By.xpath("following-sibling::img")));
            integerPart = faker.random().nextInt(min, max);
            productObject.setStockLevel(String.format("%d", integerPart));
            stockLevelInputBox.sendKeys(productObject.getStockLevel());
            productObject.setStockLeverWarning(String.format("%d", faker.random().nextInt(1, 10)));
            stockLevelWarningInputBox.sendKeys(productObject.getStockLeverWarning());
        } else {
            ((JavascriptExecutor) driver).executeScript(disable, useStockLevelCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxDisabled, useStockLevelCheckBox.findElement(By.xpath("following-sibling::img")));
        }
        //******************************************
        productObject.setUpcCode("UPC" + faker.random().nextInt(1000000, 9999999));
        upcCodeInputBox.sendKeys(productObject.getUpcCode());
        //******************************************
        productObject.setEanCode("EAN" + faker.random().nextInt(1000000, 9999999));
        eanCodeInputBox.sendKeys(productObject.getEanCode());
        //******************************************
        productObject.setJanCode("JAN" + faker.random().nextInt(1000000, 9999999));
        janCodeInputBox.sendKeys(productObject.getJanCode());
        //******************************************
        productObject.setIsbnCode("ISBN" + faker.random().nextInt(1000000, 9999999));
        isbnCodeInputBox.sendKeys(productObject.getIsbnCode());
        //******************************************
        productObject.setGtinCode("GTIN" + faker.random().nextInt(1000000, 9999999));
        gtinCodeInputBox.sendKeys(productObject.getGtinCode());
        //******************************************
        productObject.setMpnCode("MPN" + faker.random().nextInt(1000000, 9999999));
        mpnCodeInputBox.sendKeys(productObject.getMpnCode());
        //******************************************
        functionLibrary.waitForElementPresent(googleCategoryDropDown);
//        functionLibrary.sleep(1);
        googleCategoryDropDown.click();
        functionLibrary.sleep(1);
        productObject.setGoogleCategory(googleCategoryList.get(faker.random().nextInt(1, googleCategoryList.size())).getText());
        //functionLibrary.sleep(3);
        googleCategoryInputBox.sendKeys(productObject.getGoogleCategory());
        googleCategoryElementToSelect.click();
        //******************************************
        descriptionTab.click();
        //******************************************
        productObject.setDescription(faker.lorem().sentence(50));
        driver.switchTo().frame(descriptionFrame);
        descriptionInputBox.sendKeys(productObject.getDescription());
        driver.switchTo().defaultContent();
        //******************************************
        productObject.setShortDescription(faker.lorem().sentence(10));
        driver.switchTo().frame(shortDescriptionFrame);
        descriptionInputBox.sendKeys(productObject.getShortDescription());
        driver.switchTo().defaultContent();
        //******************************************
        pricingTab.click();
        //******************************************
        productObject.setRetailPrice(String.format("%.2f", faker.random().nextInt(50, 100) + faker.random().nextDouble()));
        retailPriceInputBox.sendKeys(productObject.getRetailPrice());
        //******************************************
        productObject.setSalePrice(faker.random().nextInt(50, 100) + faker.random().nextDouble());
        salePriceInputBox.sendKeys(String.format("%.2f", productObject.getSalePrice()));
        //******************************************
        productObject.setCostPrice(String.format("%.2f", faker.random().nextInt(50, 100) + faker.random().nextDouble()));
        costPriceInputBox.sendKeys(productObject.getCostPrice());
        //******************************************
        //taxClassDropDown.click();
        productObject.setTaxClass(taxClassList.get(faker.random().nextInt(1, taxClassList.size() - 1)).getText());
        select = new Select(taxClassDropDown);
        select.selectByVisibleText(productObject.getTaxClass());
        //******************************************
        productObject.setTaxIncluded(faker.bool().bool());
        if (productObject.isTaxIncluded()) {
            ((JavascriptExecutor) driver).executeScript(enable, taxIncludedCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, taxIncludedCheckBox.findElement(By.xpath("following-sibling::img")));
        } else {
            ((JavascriptExecutor) driver).executeScript(disable, taxIncludedCheckBox);
            ((JavascriptExecutor) driver).executeScript(checkBoxDisabled, taxIncludedCheckBox.findElement(By.xpath("following-sibling::img")));
        }
        //******************************************
        productObject.setMinimumQuantityPurchase(faker.random().nextInt(1, 10));
        minimumQuantityPurchaseInputBox.clear();
        minimumQuantityPurchaseInputBox.sendKeys(String.format("%d", productObject.getMinimumQuantityPurchase()));
        //******************************************
        productObject.setMaximumQuantityPurchase(String.format("%d", faker.random().nextInt(950, 1000)));
        maximumQuantityPurchaseInputBox.sendKeys(productObject.getMaximumQuantityPurchase());
        //******************************************
        for (int i = 0; i < 5; i++) {
            productObject.setQuantity(productObject.getMinimumQuantityPurchase() + 5 * i);
            quantityInputBox.sendKeys(String.format("%d", productObject.getQuantity()));
            productObject.setPrice(productObject.getSalePrice() - 5 * i);
            priceOfAQuantityInputBox.sendKeys(String.format("%.2f", productObject.getPrice()));
            addButton.click();
        }
        //******************************************
        categoriesTab.click();
        //******************************************
        //driver.findElement(By.xpath(String.format("//td[text()=\"%s\"]/preceding-sibling::td/input[@name=\"primary_cat\"]",categoryObjectClass.getCategoryName))).click();
        categoryPrimaryCheckBox.click();
        //******************************************
        //optionsTab.click();
        //******************************************
        imagesTab.click();
        //******************************************
        productObject.setFolderName("folder_of_" + faker.name().firstName());
        createFolderForImagesInputBox.sendKeys(productObject.getFolderName());
        goButtonForImages.click();
        functionLibrary.sleep(2);
        WebElement folder = driver.findElement(By.xpath(String.format("//a[@rel=\"%s/\"]", productObject.getFolderName())));
        functionLibrary.waitForElementPresent(folder);
        folder.click();
        //******************************************
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectFileButton);
        selectFileButton.click();
        functionLibrary.sleep(1);
        String filePath = "C:\\Users\\ahamu\\IdeaProjects\\foxforce-alimjan\\image\\API-GET-Request-with-Matrix-Parameter.webp";
        // Use the Robot class to handle the file dialog
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_BACK_SLASH);
            // Depending on the file path delimiter
            robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            // Copy the file path to the clipboard
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            // Paste the file path into the file dialog and press Enter
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        functionLibrary.sleep(2);
        //******************************************
        folder = driver.findElement(By.xpath(String.format("//a[@rel=\"%s/\"]", productObject.getFolderName())));
        folder.click();
        //((JavascriptExecutor)driver).executeScript("arguments[0].click();", folder);
        functionLibrary.sleep(2);
        WebElement imageCheckBox = folder.findElement(By.xpath("following-sibling::ul/li/span/img"));
        imageCheckBox.click();
        imageCheckBox.click();
//        ((JavascriptExecutor) driver).executeScript(checkBoxEnabled, imageCheckBox);
//        WebElement valueOfImageCheckBox = imageCheckBox.findElement(By.xpath("preceding-sibling::input"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','2')", valueOfImageCheckBox);
        //******************************************
        digitalTab.click();
        createFolderForDigitalInputBox.sendKeys(productObject.getFolderName());
        goButtonForDigital.click();// here is a bug
        //******************************************
        searchEnginesTab.click();
        productObject.setMetaTitle(faker.commerce().productName());
        metaTitleInputBox.sendKeys(productObject.getMetaTitle());
        String randomText = faker.lorem().sentence(5);
// Adjust the word count as needed

// Format the text to be SEO-friendly
        String seoUrl = randomText.replaceAll("\\s+", "-")
// Replace spaces with hyphens
                .replaceAll("[^a-zA-Z0-9-]", "")
// Remove special characters
                .toLowerCase();
// Convert to lowercase
        productObject.setCustomSeoUrlPath(seoUrl);
        seoPathInputBox.sendKeys(productObject.getCustomSeoUrlPath());
        productObject.setMetaDescription(faker.lorem().sentence(25));
        metaDescriptionInputBox.sendKeys(productObject.getMetaDescription());
        saveButton.click();
        return !successMessage.isEmpty();
    }

    public Boolean verifyProductInDateBase(Connection connection, String productName) {
        boolean isProductExist = false;
        Statement statement = null;
        ResultSet resultset = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlScriptForProduct = String.format("select product_id,name,price from cc_CubeCart_inventory where name='%s'", productName);
        try {
            resultset = statement.executeQuery(sqlScriptForProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultset == null) {
            System.out.println("No Records found");
//            return isProductExist;
        } else {
            try {
                cachedRowSet.populate(resultset);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            int rowCount = 0;
            while (true) {
                try {
                    if (!cachedRowSet.next()) {
                        break;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    int product_id = cachedRowSet.getInt("product_id");
                    String name = cachedRowSet.getString("name");
                    double price = cachedRowSet.getDouble("price");
                    System.out.println(String.format("product_id=%d name=%s price=%.2f", product_id, name, price));
                    rowCount = cachedRowSet.getRow();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (rowCount >= 1) {
                    isProductExist = true;
                }
            }
        }
        return isProductExist;
    }

    public void editProduct(String itemId) {

    }

    public void assignToCategory(String productCode, String categoryName) {

    }

    public void assignOptionSetsToProduct(String optionSets, String productName) {

    }
}
