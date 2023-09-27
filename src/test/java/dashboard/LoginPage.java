package dashboard;

import basefunctions.FunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    public WebDriver driver;
    FunctionLibrary functionLibrary;
    // define element by@
    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement userPasswordField;
    @FindBy(css = "#login")
    WebElement loginButton;
    @FindBy(css = ".error")
    WebElement invalidVeriFy;
    @FindBy(css = "#login-box")
    WebElement cubeCartLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        functionLibrary = new FunctionLibrary(driver);
    }

    public boolean verifyCubeCartLogo() {
        functionLibrary.waitForElementPresent(cubeCartLogo);
        if (cubeCartLogo.isDisplayed()) {
            System.out.println("CubeCart succesfully loginAndLogOut");
        }
        return true;
    }

    public boolean verifyInvalid() {
        functionLibrary.waitForElementPresent(loginButton);
        if (invalidVeriFy.isDisplayed()) {
            System.out.println("Invalid input");
        }
        return true;
    }

    // write login action
    public void enterUserName(String userName) {
        functionLibrary.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);
    }
    public void enterPassword(String password) {
        functionLibrary.waitForElementPresent(userPasswordField);
        userPasswordField.sendKeys(password);
    }
    public void clickLoginButton() {
        functionLibrary.waitForElementPresent(loginButton);
        loginButton.click();
    }
    public void logIn(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }

    public void loginAndLogOut(String userName, String password) {
        logIn(userName, password);
        DashBoardPage dashBoardPag = new DashBoardPage(driver);
        dashBoardPag.logout();

    }
}



