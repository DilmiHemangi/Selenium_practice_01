import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class LinkTests {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/link.xhtml");
        driver.manage().window().maximize();
    }
    @Test
    public void Test_1(){
//        driver.findElement(By.linkText("Go to Dashboard")).click();
        WebElement element_1  = driver.findElement(By.linkText("Go to Dashboard"));
        element_1.click();
        driver.navigate().back();
    }
    @Test
    public void Test_2(){
        WebElement element_2  = driver.findElement(By.partialLinkText("Find the URL without"));
        String name = element_2.getAttribute("href");
        System.out.print("This is going to " + name);
    }
    @Test
    public void Test_3(){
        WebElement element_3  = driver.findElement(By.linkText("Broken?"));
        element_3.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.print("This link is broken.");
        }else {
            System.out.print("This link is not broken.");
        }
        driver.navigate().back();

    }
    @Test
    public void Test_4() {
        WebElement element_4  = driver.findElement(By.linkText("Go to Dashboard"));
        element_4.click();
        driver.navigate().back();
    }
    @Test
    public void Test_5() {
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        int count = elements.size();
        System.out.print("Element count = " + count);
        driver.navigate().back();
    }
    @Test
    public void Test_6() {
        WebElement element_5 = driver.findElement(By.className("layout-main-content"));
        List<WebElement> elements_2 = element_5.findElements(By.tagName("a"));
        int n= elements_2.size();
        driver.navigate().back();
        System.out.print("No of links = "+n);
    }
}
