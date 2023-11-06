package basefunctions;

import dashboard.DashBoardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    public  WebDriver driver;
    public  void openBrowser(String url){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }
    public void closeBrowser(){
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.logout();
        driver.close();
        driver.quit();
    }
}
