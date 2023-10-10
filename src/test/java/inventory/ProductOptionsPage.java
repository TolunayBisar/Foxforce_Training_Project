package inventory;

import basefunctions.FunctionLibrary;
import basefunctions.ScreenShotUtility;
import cubecartobjects.OptionGroupObject;
import dashboard.DashBoardPage;
import order.ReadCustomerInfoList;
import order.ReadOrderInfoList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

import java.util.List;
import java.util.Random;

public class ProductOptionsPage {
   WebDriver driver;
   FunctionLibrary functionLibrary;

   @FindAll(@FindBy(xpath ="//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr/td/span" ))
   List<WebElement> editIcons;

   @FindAll(@FindBy(xpath = "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr/td/input[@type='text']"))
   List<WebElement> editNameAndDescField;

@FindBy(id="new-group-name")
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


    public ProductOptionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);



    }

   public void verifyAtLeastOneOptionGroupOnTable(){
       List<WebElement> optionGroupLocates = driver.findElements(By.xpath(
               "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr"));
       if (optionGroupLocates.size()>0){
          System.out.println("There is at least one Option Group on this page");
       }

   }

   public void editOptionGroup(){


      //checkbox
      List<WebElement> checkBox = driver.findElements(By.xpath("//img[@class='checkbox cbs']"));
      WebElement checkBoxValue= driver.findElement(By.xpath("//td/input[@id='status_16']"));
      String beforeCheckValue= checkBoxValue.getAttribute("value");
      Random randomCheck = new Random();
      checkBox.get(randomCheck.nextInt(9)).click();
      String afterCheckValue= checkBoxValue.getAttribute("value");
      if (Math.abs((Integer.parseInt(beforeCheckValue)-Integer.parseInt(afterCheckValue)))==1){
         System.out.println("Checkbox is working well");
      }else {
         System.out.println("Checkbox is not warking");
      }

      // edit icon
       int j = 0;

       functionLibrary.writeJson();
       for (OptionGroupObject s : functionLibrary.readJson()) {

           for (int i = 0; i < editIcons.size(); i = i + 3) {
               editIcons.get(i).click();

                   editNameAndDescField.get(j).clear();
                   editNameAndDescField.get(j).sendKeys(s.getGroupName());
               editIcons.get(i+2).click();
               editNameAndDescField.get(j+1).clear();
               editNameAndDescField.get(j+1).sendKeys(s.getDescription());
               } j++;




           }

       saveButton.click();

      // Add new group
       for (OptionGroupObject s : functionLibrary.readJson()) {
           addGroupNameField.sendKeys(s.getGroupName());
           break;
       }
       for (OptionGroupObject s : functionLibrary.readJson()) {
           addDescriptionField.sendKeys(s.getDescription());
           break;
       }

       Select select = new Select(selectGroupType);
       select.selectByValue("2");

       checkBoxRequired.click();
       saveButton.click();


   }

   public void deleteOptionGroup(String optionGroupName){

   }

   public void addNewOptionGroup(String optionGroupName){

   }


}
