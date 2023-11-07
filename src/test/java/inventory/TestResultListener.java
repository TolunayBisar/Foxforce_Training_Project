package inventory;

import basefunctions.ScreenShotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

    public class TestResultListener implements ITestListener {
        ScreenShotUtility screenShotUtility=new ScreenShotUtility();
        static List<ITestNGMethod> passedTest=new ArrayList<>();
        static List<ITestNGMethod> failedTest=new ArrayList<>();
        static List<ITestNGMethod> skippedTest=new ArrayList<>();
        public void onTestStart(ITestResult result) {
        }
        public void onTestSuccess(ITestResult result) {
            passedTest.add(result.getMethod());
            screenShotUtility.takeScreenShot(result.getMethod().getMethodName().trim()+"_Passed",
                    (WebDriver) result.getTestContext().getAttribute("driver"));
        }
        public void onTestFailure(ITestResult result) {
            failedTest.add(result.getMethod());
            screenShotUtility.takeScreenShot(result.getMethod().getMethodName().trim()+"_Failed",
                    (WebDriver) result.getTestContext().getAttribute("driver"));
        }
        public void onTestSkipped(ITestResult result) {
            skippedTest.add(result.getMethod());
        }
        public void onTestFailedWithTimeout(ITestResult result) {
            this.onTestFailure(result);
        }
        public void onStart(ITestContext context) {
        }
        public void onFinish(ITestContext context) {
        }
}
