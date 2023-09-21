package order;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    @FindAll(@FindBy(xpath="//div/table[last()]/tbody/tr") )
    List<WebElement> orderList;


    // Verify at least one order in list
    public boolean verifyOrder(){
        if (orderList.size()>1)
            System.out.println("There is at leat on order in list");
        System.out.printf("There are %d orders in this list",orderList.size());


        return true;
    }

}
