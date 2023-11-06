package inventory;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ImportCatalogPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public ImportCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(xpath = "//label[text()='Source (Max: 32M)']")
    WebElement uploadField;
    @FindBy(xpath = "//input[@type='file']")
    WebElement chooseFileField;

    @FindBy(id = "import_format")
    WebElement importFormatDropDown;
    @FindBy(id = "opt_delimiter")
    WebElement delimiterDropDown;
    @FindBy(css = "input[value='Save']")
    WebElement saveButton;
    @FindBy(name = "map[0]")
    WebElement productNameDropDown;
    @FindBy(name = "map[1]")
    WebElement statusDropDown;

    @FindBy(name = "map[2]")
    WebElement isFeaturedProduct;

    @FindBy(name = "map[3]")
    WebElement isLatestProduct;

    @FindBy(name = "map[4]")
    WebElement productCodeDropDown;

    @FindBy(name = "map[5]")
    WebElement weightDropDown;

    @FindBy(name = "map[6]")
    WebElement descriptionDropDown;
    @FindBy(name = "map[7]")
    WebElement shortDescriptionDropDown;
    @FindBy(name = "map[8]")
    WebElement priceDropDown;
    @FindBy(name = "map[9]")
    WebElement salePriceDropDown;
    @FindBy(name = "map[10]")
    WebElement costPriceDropDown;
    @FindBy(name = "map[11]")
    WebElement taxClassDropDown;
    @FindBy(name = "map[12]")
    WebElement taxInclusiveDropDown;
    @FindBy(name = "map[13]")
    WebElement imagesDropDown;
    @FindBy(name = "map[14]")
    WebElement stockLevelDropDown;
    @FindBy(name = "map[15]")
    WebElement useStockLevelDropDown;
    @FindBy(name = "map[16]")
    WebElement stockLevelWarningDropDown;
    @FindBy(name = "map[17]")
    WebElement categoryDropDown;
    @FindBy(name = "map[18]")
    WebElement manufacturerDropDown;
    @FindBy(name = "map[19]")
    WebElement upcCodeDropDown;
    @FindBy(name = "map[20]")
    WebElement eanCodeDropDown;
    @FindBy(name = "map[21]")
    WebElement janCodeDropDown;
    @FindBy(name = "map[22]")
    WebElement isbnCodeDropDown;
    @FindBy(name = "map[23]")
    WebElement brandDropDown;
    @FindBy(name = "map[24]")
    WebElement mpnCodeDropDown;
    @FindBy(name = "map[25]")
    WebElement gtinCodeDropDown;
    @FindBy(name = "map[26]")
    WebElement metaTitleDropDown;
    @FindBy(name = "map[27]")
    WebElement metaDescriptionDropDown;

    @FindBy(name = "map[28]")
    WebElement conditionDropDown;

    @FindBy(name = "map[29]")
    WebElement digitalDropDown;

    @FindBy(name = "map[30]")
    WebElement digitalPathDropDown;

    @FindBy(name = "map[31]")
    WebElement widthDropDown;
    @FindBy(name = "map[32]")
    WebElement heightDropDown;
    @FindBy(name = "map[33]")
    WebElement depthDropDown;
    @FindBy(name = "map[34]")
    WebElement dimensionUnitDropDown;
    @FindBy(linkText = "Remove Previous Import")
    WebElement removeLink;
    @FindBy(id = "opt_headers")
    WebElement optionHeadersBox;
    @FindAll(
            @FindBy(className = "custom-checkbox")
    )
    List<WebElement> allCheckboxes;
    @FindAll(
            @FindBy(css = ".success")
    )
    List<WebElement> removeSuccessMessage;
    public void importCatalog(String filePath){
        Actions actions=new Actions(driver);
        functionLibrary.waitForElementPresent(chooseFileField);
        chooseFileField.sendKeys(filePath);
        Select selectFormat=new Select(importFormatDropDown);
        selectFormat.selectByVisibleText("Comma-Separated Values (CSV)");
        Select selectDelimiter=new Select(delimiterDropDown);
        selectDelimiter.selectByValue(",");
        saveButton.click();

        Select selectName=new Select(productNameDropDown);
        selectName.selectByValue("name");
        Select selectStatus=new Select(statusDropDown);
        selectStatus.selectByValue("status");
        Select selectFeatured=new Select(isFeaturedProduct);
        selectFeatured.selectByValue("featured");
        Select selectLatest=new Select(isLatestProduct);
        selectLatest.selectByValue("latest");
        Select selectCode=new Select(productCodeDropDown);
        selectCode.selectByValue("product_code");
        Select selectWeight=new Select(weightDropDown);
        selectWeight.selectByVisibleText("Weight");
        Select selectDescription=new Select(descriptionDropDown);
        selectDescription.selectByValue("description");
        Select selectShortDesc=new Select(shortDescriptionDropDown);
        selectShortDesc.selectByValue("description_short");
        Select selectPrice=new Select(priceDropDown);
        selectPrice.selectByValue("price");
        Select selectSalePrice=new Select(salePriceDropDown);
        selectSalePrice.selectByValue("sale_price");
        Select selectCostPrice=new Select(costPriceDropDown);
        selectCostPrice.selectByValue("cost_price");
        Select selectTaxClass=new Select(taxClassDropDown);
        selectTaxClass.selectByVisibleText("Tax Class");
        Select selectTaxInclusive=new Select(taxInclusiveDropDown);
        selectTaxInclusive.selectByValue("tax_inclusive");
        Select selectImage=new Select(imagesDropDown);
        selectImage.selectByValue("image");
        Select selectStockLevel=new Select(stockLevelDropDown);
        selectStockLevel.selectByValue("stock_level");
        Select selectUseStockL=new Select(useStockLevelDropDown);
        selectUseStockL.selectByValue("use_stock_level");
        Select selectStockWarning=new Select(stockLevelWarningDropDown);
        selectStockWarning.selectByValue("stock_warning");
        Select selectCatId=new Select(categoryDropDown);
        selectCatId.selectByValue("cat_id");
        Select selectManufacturer=new Select(manufacturerDropDown);
        selectManufacturer.selectByValue("manufacturer");
        Select selectUpc=new Select(upcCodeDropDown);
        selectUpc.selectByValue("upc");
        Select selectEan=new Select(eanCodeDropDown);
        selectEan.selectByValue("ean");
        Select selectJan=new Select(janCodeDropDown);
        selectJan.selectByValue("jan");
        Select selectIsbn=new Select(isbnCodeDropDown);
        selectIsbn.selectByValue("isbn");
        Select selectBrand=new Select(brandDropDown);
        selectBrand.selectByValue("brand");
        Select selectMpn=new Select(mpnCodeDropDown);
        selectMpn.selectByValue("mpn");
        Select selectGtin=new Select(gtinCodeDropDown);
        selectGtin.selectByValue("gtin");
        Select selectMetaTitle=new Select(metaTitleDropDown);
        selectMetaTitle.selectByVisibleText("Meta Title");
        Select selectMetaDescription=new Select(metaDescriptionDropDown);
        selectMetaDescription.selectByVisibleText("Meta Description");
        Select selectCondition=new Select(conditionDropDown);
        selectCondition.selectByValue("condition");
        Select selectSDigital=new Select(digitalDropDown);
        selectSDigital.selectByValue("digital");
        Select selectDigitalPath=new Select(digitalPathDropDown);
        selectDigitalPath.selectByValue("digital_path");
        Select selectWidth=new Select(widthDropDown);
        selectWidth.selectByValue("product_width");
        Select selectHeight=new Select(heightDropDown);
        selectHeight.selectByValue("product_height");
        Select selectDepth=new Select(depthDropDown);
        selectDepth.selectByValue("product_depth");
        Select selectDimension=new Select(dimensionUnitDropDown);
        selectDimension.selectByValue("dimension_unit");

        actions.scrollToElement(optionHeadersBox).perform();
        optionHeadersBox.click();
        saveButton.click();
    }
    public void importCatalogDetail(String filePath){
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        uploadField.click();
        try {
            StringSelection str=new StringSelection(filePath);
            //Copy to clipboard
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);

            // Cmd + Tab is needed since it launches a Java app and the browser looses focus
            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_META);robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_META);robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(500);

            //Open Goto window
            robot.keyPress(KeyEvent.VK_META);robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);robot.keyRelease(KeyEvent.VK_SHIFT);robot.keyRelease(KeyEvent.VK_G);

            //Paste the clipboard value
            robot.keyPress(KeyEvent.VK_META);robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);robot.keyRelease(KeyEvent.VK_V);

            //Press Enter key to close the Goto window and Upload window
            robot.keyPress(KeyEvent.VK_ENTER);robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        Select selectFormat=new Select(importFormatDropDown);
        selectFormat.selectByVisibleText("Comma-Separated Values (CSV)");
        Select selectDelimiter=new Select(delimiterDropDown);
        selectDelimiter.selectByValue(",");
        saveButton.click();

        jse.executeScript("window.scrollBy(0,700)","");
        jse.executeScript("arguments[0].click();",optionHeadersBox);
        saveButton.click();
    }
    public boolean verifyImportSuccess(){
        try{
            WebElement successMessage=driver.findElement(By.xpath("//div[contains(text(),'Product import complete.')]"));
            if (successMessage.isDisplayed())
            System.out.println("Import Successful.");
            return true;
        }catch (NoSuchElementException e){
            System.out.println("import failed!!!");
            return false;
        }
    }
    public boolean removePreviousImports(){
    removeLink.click();
    for(WebElement eachBox:allCheckboxes){
        eachBox.click();
    }
    saveButton.click();
    if (removeSuccessMessage.size()>=1){
        return true;
    }else
        return false;
    }
}
