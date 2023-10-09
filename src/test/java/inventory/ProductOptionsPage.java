package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ProductOptionsPage {
   WebDriver driver;

   @FindAll(@FindBy(xpath ="//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr/td/span" ))
   List<WebElement> editIcons;

   @FindAll(@FindBy(xpath = "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr/td/input[@type='text']"))
   List<WebElement> editNameField;




   public void verifyAtLeastOneOptionGroupOnTable(){
       List<WebElement> optionGroupLocates = driver.findElements(By.xpath(
               "//div/h3[text()='Option Groups']/following-sibling :: table/tbody/tr"));
       if (optionGroupLocates.size()>0){
          System.out.println("There is at least one Option Group on this page");
       }

   }

   public void editOptionGroup(String optionGroupName){

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
     int j = randomCheck.nextInt(editIcons.size());
      for (int i=0;i<editIcons.size();i=i+3){
         editIcons.get(i).click();
         editNameField.get(i).sendKeys();

      }




   }

   public void deleteOptionGroup(String optionGroupName){

   }

   public void addNewOptionGroup(String optionGroupName){

   }
}
