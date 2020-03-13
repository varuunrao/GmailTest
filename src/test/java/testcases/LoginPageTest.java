package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import config.EmailData;
import pages.DashboardPage;
import pages.LoginPage;
import reports.HtmlReport;
import utils.FrameWorkUtils;

public class LoginPageTest {

    WebDriver driver;
    LoginPage login;
    DashboardPage dash;

    ExtentTest htmlReport = HtmlReport.getReportInstance().createTest("LoginPagetest");

    
    @BeforeMethod
    public void setUp(){
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
    	driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test(dataProvider = "emailDataProvider", dataProviderClass = EmailData.class)
    public synchronized void enterLogin(String email, String password) throws InterruptedException{
        login = new LoginPage(driver);
    	login.login(email, password);
        wait(5000);
        dash = new DashboardPage(driver);
        
        System.out.println(dash.pageheader());
        Assert.assertTrue(dash.pageheader().equalsIgnoreCase("Primary"), "Incorrect page");
        
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			htmlReport.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case FAILED", ExtentColor.RED));
			
			String screenShotLocation = FrameWorkUtils.takeScreenshot(driver);			
			
			htmlReport.fail("Test Case failed check screenshot below"+htmlReport.addScreenCaptureFromPath(screenShotLocation));

		} else if (result.getStatus() == ITestResult.SKIP) {

			htmlReport.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.YELLOW));

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			htmlReport.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
		}
		
		driver.quit();
		HtmlReport.getReportInstance().flush();

	}
    
}
