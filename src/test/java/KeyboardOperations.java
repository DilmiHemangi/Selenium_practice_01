import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.util.List;

public class KeyboardOperations {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test_01() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement e_01 = driver.findElement(By.id("APjFqb"));
        e_01.sendKeys("Welcome");
        Thread.sleep(3000);

        Actions action_01 = new Actions(driver);
        action_01.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        e_01.sendKeys("Flowers");
        action_01.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public  void Test_02() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        List<WebElement> elementList =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        System.out.println("No of elements in the list = "+elementList.size());

        Actions action_2 = new Actions(driver);
        action_2.keyDown(Keys.CONTROL)
                .sendKeys(elementList.get(0))
                .sendKeys(elementList.get(1))
                .sendKeys(elementList.get(2))
                .sendKeys(elementList.get(3)).perform();

        Thread.sleep(3000);
        driver.quit();
    }
}
