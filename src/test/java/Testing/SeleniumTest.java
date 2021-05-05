package Testing;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class SeleniumTest {

    SoftAssert softAssert= new SoftAssert();

    @Test
    public void openWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anna\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver( );
        driver.get("https://www.selenium.dev/");
        driver.manage( ).window( ).maximize( );
        Thread.sleep(3000);
        System.out.println("Found the web page");

        WebElement downloads = driver.findElement(By.xpath("//a[text()='Downloads']"));
        downloads.click( );
        Thread.sleep(3000);
        System.out.println("to Downloads");

        WebElement Str = driver.findElement(By.xpath("//p[contains(text(), 'Latest stable version')]"));
        WebElement Number = driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[1]/a"));
        //couldn't find in other ways
        System.out.println(Number.getText( ));
        String Actual = Number.getText( );
        String Wanted = "3.141.59";

        Assert.assertEquals(Actual, Wanted);
        System.out.println("Assertion is succeeded");

        WebElement target = driver.findElement(By.cssSelector("[id=gsc-i-id1]"));
        Thread.sleep(3000);
        System.out.println("Hovered to SeachLine");

        target.click( );
        target.sendKeys("Selenium" + Keys.ENTER);
        Thread.sleep(4000);

        List<WebElement> rows = driver.findElements(By.xpath("//*[ translate( text()," +
                "" + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='selenium']"));
        //couldn't find selector within found links

        for (WebElement elem : rows) {
            String str = elem.getText( );
            String wanted = "selenium";

            Assert.assertTrue(str.contains(wanted), "Absence in some links ");
            System.out.println("Assertion2 is succeeded");

            softAssert.assertAll();

            driver.close( );
        }
    }
}
//Thank You!





