package inventory;

import basefunctions.FunctionLibrary;
import cubecartobjects.ExcelFileObject;
import cubecartobjects.OptionGroupObject;
import cubecartobjects.SetObject;
import dashboard.DashBoardPage;
import order.CustomerInfoExcelList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductOptionsPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    DashBoardPage dashBoardPage;
    Random random;
    CustomerInfoExcelList writeExcel;
    ExcelFileObject excelFileObject;


    @FindAll(@FindBy(xpath = "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr/td/span[@class='editable']"))
    List<WebElement> editIcons;

    @FindAll(@FindBy(xpath = "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr/td/input[@type='text']"))
    List<WebElement> editNameAndDescField;

    @FindBy(id = "new-group-name")
    WebElement addGroupNameField;

    @FindBy(id = "new-group-description")
    WebElement addDescriptionField;
    @FindBy(id = "new-group-type")
    WebElement selectGroupType;

    @FindBy(xpath = "//label[text()='Required']/following-sibling::span/img[@class='checkbox cbs']")
    WebElement checkBoxRequired;

    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;

    @FindAll(@FindBy(xpath = "//img[@class='checkbox cbs']"))
    List<WebElement> checkBoxes;
    @FindAll(@FindBy(xpath = "//td[@style='text-align:center']/a/i"))
    List<WebElement> deleteIcons;

    @FindBy(id = "select_group_id")
    WebElement selectInAttribute;

    @FindBy(id = "new-value-name")
    WebElement attributeNameField;
    @FindBy(xpath = "//i[@title='Add']")
    WebElement addIcon;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButtonInAttributePage;
    @FindBy(linkText = "Option Attributes")
    WebElement optionAttributeTab;

    @FindAll(@FindBy(xpath = "//tbody[@class='reorder-list ui-sortable']/tr/td[2]/span[@class='editable']"))
    List<WebElement> attributeIcons;

    @FindBy(xpath = "//a[text()='Option Sets']")
    WebElement optionSetsTab;

    @FindBy(id = "new-set-name")
    WebElement setNameField;
    @FindBy(id = "new-set-desc")
    WebElement setDescription;
    @FindBy(xpath = "//div[@class='form_control']/input")
    WebElement setSaveButton;


    @FindBy(name = "set_id")
   WebElement setDropdown;

    @FindAll(@FindBy(xpath = "//select[@name=\"set_id\"]/option"))
    List<WebElement> setList;

    @FindBy(name = "add_to_set[]")
    WebElement attributeToSetDropdown;
    @FindAll(@FindBy(xpath = "//select[@name='add_to_set[]']/option"))
    List<WebElement> optionOfAttribute;

    @FindAll(@FindBy(xpath = "//div/span[@class='actions']"))
    List<WebElement> selectedAttributesOfSets;


    public ProductOptionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
        dashBoardPage = new DashBoardPage(driver);
        random = new Random();
        writeExcel = new CustomerInfoExcelList(driver);
        excelFileObject = new ExcelFileObject();
//
    }

    public boolean verifyAtLeastOneOptionGroupOnTable() {
        dashBoardPage.clickOnProductOptionLink();
        List<WebElement> optionGroupLocates = driver.findElements(By.xpath(
                "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr"));
        if (optionGroupLocates.size() > 0) {
            System.out.println("There is at least one Option Group on this page");
        }
        return true;
    }

    public void editOptionGroup() {

        dashBoardPage.clickOnProductOptionLink();
        //checkbox
        List<WebElement> checkBox = driver.findElements(By.xpath("//img[@class='checkbox cbs']"));
        List<WebElement> checkBoxValue = driver.findElements(By.xpath("//td/input[@class='toggle']"));
        String beforeCheckValue = checkBoxValue.get(0).getAttribute("value");
        System.out.println(beforeCheckValue);
        checkBox.get(0).click();
        String afterCheckValue = checkBoxValue.get(1).getAttribute("value");
        System.out.println(afterCheckValue);
        if (Math.abs((Integer.parseInt(beforeCheckValue) - Integer.parseInt(afterCheckValue))) == 1) {
            System.out.println("Checkbox is working well");

        } else {
            System.out.println("Checkbox is not working");
        }

        // edit icon
        int x = 0;
        int beforeEditGroupQty = editIcons.size();
        functionLibrary.writeJson();
        for (OptionGroupObject s : functionLibrary.readJson()) {
            functionLibrary.sleep(1);
            for (int i = x; i < editIcons.size(); ) {
                editIcons.get(i).click();
                functionLibrary.sleep(1);
                editNameAndDescField.get(i).clear();
                editNameAndDescField.get(i).sendKeys(s.getGroupName());
                functionLibrary.sleep(1);
                editIcons.get(i).click();
                functionLibrary.sleep(1);
                editNameAndDescField.get(i + 1).clear();
                editNameAndDescField.get(i + 1).sendKeys(s.getDescription());
                System.out.println(s.getDescription());
                break;
            }
            x = x + 2;
            functionLibrary.sleep(1);
        }
        saveButton.click();
        int afterEditGroupQty = editIcons.size();
    }

    public boolean verifyEditOptionGroup() {

        for (WebElement name : editNameAndDescField) {
            if (name.getText().contains(functionLibrary.readJson().toString())) {
                return true;
            } else
                return false;
        }
        return true;

    }


    public boolean deleteOptionGroup() {
        dashBoardPage.clickOnProductOptionLink();
        int beforeDelete = deleteIcons.size();
        deleteIcons.get(random.nextInt(deleteIcons.size())).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        saveButton.click();
        int afterDelete = deleteIcons.size();
        if ((beforeDelete - afterDelete) > 0) {
            System.out.println("Successfully deleted");
        }
        return true;
    }


    public int addNewOptionGroup() {
        dashBoardPage.clickOnProductOptionLink();
        // Add new group
        int beforeAdd = editIcons.size();
        System.out.println(beforeAdd);
        for (OptionGroupObject s : functionLibrary.readJson()) {

            addGroupNameField.sendKeys(s.getGroupName() + System.currentTimeMillis());

            break;
        }
        for (OptionGroupObject s : functionLibrary.readJson()) {

            addDescriptionField.sendKeys(s.getDescription() + System.currentTimeMillis());
            break;
        }

        Select select = new Select(selectGroupType);
        select.selectByValue("2");
        checkBoxRequired.click();
        functionLibrary.waitForElementPresent(saveButton);
        saveButton.click();
        functionLibrary.sleep(1);
        int afterAdd = editIcons.size();
        System.out.println(afterAdd);
        int addQuantity = afterAdd - beforeAdd;
        System.out.println(addQuantity);
        return addQuantity;
    }


    public int addNewOptionAttributes() {
        dashBoardPage.clickOnProductOptionLink();
        optionAttributeTab.click();
        int beforeAttrQty = attributeIcons.size();
        Select select = new Select(selectInAttribute);
        List<String> options = Arrays.asList(selectInAttribute.getText());
        List<String> attributesList = Arrays.asList("Fish", "Kitchen", "Textile", "ABC", "Fruit", "book");
        writeExcel.writeToExcel("OptionGroupListFolder/optionGroupList.xlsx", "OptionGroupListFolder", "group1", attributesList);
        excelFileObject.setFile("OptionGroupListFolder/optionGroupList");
        excelFileObject.setSheet("group1");
        functionLibrary.sleep(1);
        select.selectByIndex((random.nextInt(options.size())));
        functionLibrary.sleep(1);
        ExcelFileObject excelFileObject = new ExcelFileObject("OptionGroupListFolder/optionGroupList.xlsx", "group1");
        attributeNameField.sendKeys(functionLibrary.readExcelInfo(excelFileObject.getFile(),
                excelFileObject.getSheet()).get(random.nextInt(5)));

        addIcon.click();

        saveButtonInAttributePage.click();
        int afterAttrQty = attributeIcons.size();

        return afterAttrQty - beforeAttrQty;
    }


    public boolean addNewOptionSets() {
        dashBoardPage.clickOnProductOptionLink();
        boolean theResultOfSet = false;
        SetObject setObject;
        optionSetsTab.click();

        //Create new Set
        int beforeSetQty = setList.size();
        setObject = new SetObject("Promotion1", "Hot sale");
        setNameField.sendKeys(setObject.getSetName());
        setDescription.sendKeys(setObject.getSetDesc());
        setSaveButton.click();
        int afterSetQty = setList.size();

        // add Attribute to Set
        int beforeSelectAttributeToSet = selectedAttributesOfSets.size();

        Select select = new Select(setDropdown);
        select.selectByIndex(random.nextInt(setList.size()));
        functionLibrary.sleep(1);

        Select select1 = new Select(attributeToSetDropdown);
        functionLibrary.sleep(1);
        select1.selectByIndex(random.nextInt(optionOfAttribute.size()));

        setSaveButton.click();
        int afterSelectAttributeToSet = selectedAttributesOfSets.size();
        if (((afterSetQty-beforeSetQty)>0) && ((afterSelectAttributeToSet-beforeSelectAttributeToSet)>0) ){
            return true;
        }

     else return theResultOfSet;
    }


}





