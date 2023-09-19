package customersmodule;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement PasswordField;
    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public void logIn(){
        functionLibrary.waitForElementPresent(userNameField);
        userNameField.sendKeys(functionLibrary.readFromConfig("config.properties", "username1"));
        PasswordField.sendKeys(functionLibrary.readFromConfig("config.properties","password"));
        loginButton.click();
    }
}
