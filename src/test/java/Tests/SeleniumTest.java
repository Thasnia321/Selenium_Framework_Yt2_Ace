package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class SeleniumTest {
    public static WebDriver driver;
    static ExtentReports extent = new ExtentReports();
    public static ExtentTest test;
    static ExtentReports report;

    @BeforeSuite
    public void setupReport() throws InterruptedException {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        HomePage.click_hamburger();
        HomePage.click_onlinepurchase();
    }


    public static String capture(WebDriver driver) throws IOException{
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("scr/../ExecImages/"+System.currentTimeMillis()+".png");
        String errflPath = dest.getAbsolutePath();
        FileUtils.copyFile(srcFile,dest);
        return errflPath;
    }



    @Test
    void validate_Titles() throws IOException {
        test = extent.createTest("Verify the Titles of the shoes");
        ProductsPage.VerifyFormalshoes_Title();
        ProductsPage.VerifySportsshoe_Title();
        ProductsPage.VerifySneakers_Title();

    }

    @Test
    void validateFirstFS()  {
        ProductsPage.VerifyFirstFSname();
        test = extent.createTest("Verifies the First formal shoe name", "This test verifies the first formal shoe name is as expected or not");

    }
    @Test
    void validateFirstSports(){
        ProductsPage.verifyFirstSportsShoeName();
        test = extent.createTest("Verifies the First sports shoe name", "This test verifies the first sports shoe name is as expected or not");
    }

    @Test
    void validateFirstSneakers(){
        ProductsPage.verifyFirstSneakerName();
        test = extent.createTest("Verifies the First sneakers shoe name", "This test verifies the first sneakers shoe name is as expected or not");
    }

    @AfterSuite
    public static void cleanup(){
        driver.close();
        extent.flush();
    }
}
