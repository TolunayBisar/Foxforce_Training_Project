package inventory;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ManufacturersPage{
    WebDriver driver;
    FunctionLibrary functionLibrary;
    Random random;

    @FindAll(@FindBy(className = "fa fa-pencil-square-o"))
    List<WebElement> manufactureEditIcons;
@FindBy(id = "manu_name")
WebElement manufactureName;

    @FindBy(id = "manu_site")
    WebElement manufactureSite;

@FindBy(className = "submit")
WebElement submitButton;
    @FindAll(@FindBy(className = "fa fa-trash"))
    List<WebElement> manufactureDeleteIcons;

    public ManufacturersPage(WebDriver driver, FunctionLibrary functionLibrary) {
        this.driver = driver;
        this.functionLibrary = functionLibrary;
        PageFactory.initElements(driver,this);
        random = new Random();

    }

    public void editManufacture(){
        manufactureEditIcons.get(random.nextInt(manufactureEditIcons.size())).click();
    }
}
