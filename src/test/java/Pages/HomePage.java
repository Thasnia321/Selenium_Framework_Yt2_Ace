package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String Hamburger_menu_xpath = "//*[@id=\"menuToggle\"]/input";
    public static String Online_purchase_link_xpath = "//*[@id=\"menu\"]/a[3]";

    public static void click_hamburger(){
        driver.findElement(By.xpath(Hamburger_menu_xpath)).click();

    }
    public static void click_onlinepurchase() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(Online_purchase_link_xpath)).click();

    }

}
