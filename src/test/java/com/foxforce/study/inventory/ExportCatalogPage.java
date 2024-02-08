package com.foxforce.study.inventory;

import com.foxforce.study.basefunctions.FunctionLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Set;

public class ExportCatalogPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public ExportCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }
    @FindBy(linkText = "1")
    WebElement downloadPartField;
    @FindBy(xpath = "//a[contains(@href,'export&access=')]")
    WebElement exportUrl;
    @FindBy(name = "per_page")
    WebElement amountDropDown;

    public void exportCatalog(String productAmount){
        Select selectAmount=new Select(amountDropDown);
        selectAmount.selectByValue(productAmount);
        String mainPage=driver.getWindowHandle();
        exportUrl.click();
        functionLibrary.sleep(3);
        Set<String> allWindows=driver.getWindowHandles();
        for(String openedWindow:allWindows){
            if (!openedWindow.equalsIgnoreCase(mainPage)){
                driver.switchTo().window(openedWindow);
                functionLibrary.sleep(2);
                try {
                    WebElement verifyText = driver.findElement(By.xpath("//body[contains(text(),'Master Category')]"));
                    if (verifyText.isDisplayed())
                        System.out.println("Export url works fine");
                }catch (Exception e){
                    e.printStackTrace();
                }
                driver.switchTo().window(mainPage);
            }
        }
        downloadPartField.click();
    }
    public boolean verifyExportSuccessful(String fileName){
        functionLibrary.sleep(3);
        File downloads=new File("/Users/user/Downloads");
           File[] allFiles=downloads.listFiles();
           try {
               for (File file : allFiles) {
                   if (file.getName().equalsIgnoreCase(fileName)) {
                       System.out.println("File is downloaded");
                       break;
                   }
               }
               return true;
           }catch (Exception e){
               return false;
           }
    }
}
