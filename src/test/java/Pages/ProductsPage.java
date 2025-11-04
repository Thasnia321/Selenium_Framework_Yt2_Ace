package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;


public class ProductsPage {

    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formalDropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsDropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakersDropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoe_Firstshoexpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoe_Firstshoexpath = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakers_Firstshoexpath = "/html/body/div[4]/table/tbody/tr[1]/td[1]";




    public static void VerifyFormalshoes_Title() throws Exception {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        Assert.assertEquals(actualTitleFS,expectedTitleFS);
        if (expectedTitleFS.equals(actualTitleFS)) {
            test.log(Status.PASS, "Formal shoes title got verified");
            test.log(Status.PASS,test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        }
        else{
            test.log(Status.FAIL, "Title was not verified, failed TC");
                    }  //if else is not given, then the previuos passed result will be shown in the reports

    }
    public static void VerifySportsshoe_Title() {
        String expectedTitleSS= "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(actualTitleSS,expectedTitleSS);
        if (expectedTitleSS.equals(actualTitleSS)) {
            test.log(Status.PASS,"Sport shoe title got verified");
        }



    }
    public static void VerifySneakers_Title(){
        String expectedTitleSneakers = "Sneakers";
        String actualTitleSneakers = driver.findElement(By.xpath(sneakers_xpath)).getText();
        if (expectedTitleSneakers.equals(actualTitleSneakers)) {
            test.log(Status.PASS,"Sneakers title got verfied");
        }
        else{
            test.log(Status.FAIL,"Failed");
        }

    }


    public static void VerifyFirstFSname() {

        driver.findElement(By.xpath(formalDropdown_xpath)).click();
        String expctdFSname = "Classic Cheltenham";
        String actualFSname = driver.findElement(By.xpath(formalShoe_Firstshoexpath)).getText();
        Assert.assertEquals(actualFSname.trim(),expctdFSname);
        System.out.println(actualFSname);
        if (expctdFSname.equals(actualFSname.trim())) {
            test.log(Status.PASS,"Expected shoe name Classic cheltenham matched with actual");
        }
        else{
            test.log(Status.FAIL, "Expected FirstFS name is incorrect");
        }


    }
    public static void verifyFirstSportsShoeName() {
        driver.findElement(By.xpath(sportsDropdown_xpath)).click();
        String expctdSS = "Ultimate";
        String actualSS = driver.findElement(By.xpath(sportsShoe_Firstshoexpath)).getText();
        Assert.assertEquals(actualSS.trim(),expctdSS);

    }
    public static void verifyFirstSneakerName() {
        driver.findElement(By.xpath(sneakersDropdown_xpath)).click();
        String expctdSneakers = "Archivo";
        String actualSneakers = driver.findElement(By.xpath(sneakers_Firstshoexpath)).getText();
        Assert.assertEquals(actualSneakers.trim(),expctdSneakers);

    }

}
