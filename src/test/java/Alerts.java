import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void AlertTest() throws InterruptedException {
        driver.get("https://www.leafground.com/alert.xhtml");
        //Alert (Simple Dialog)
        WebElement element_01 = driver.findElement(By.id("j_idt88:j_idt91"));
        element_01.click();
        Thread.sleep(3000);
        Alert alert_01 = driver.switchTo().alert();
        alert_01.accept();

        //Alert (Confirm Dialog)
        WebElement element_02 = driver.findElement(By.id("j_idt88:j_idt93"));
        element_02.click();
        Thread.sleep(3000);
        Alert alert_02 = driver.switchTo().alert();
        alert_02.dismiss();

        //Alert (Prompt Dialog)
        WebElement element_03 = driver.findElement(By.id("j_idt88:j_idt104"));
        element_03.click();
        Alert alert_03 = driver.switchTo().alert();
        String test = alert_03.getText();
        System.out.println(test);
        alert_03.sendKeys("My name is Dilmi.");
        Thread.sleep(3000);
        alert_03.accept();
//        alert_03.dismiss();
    }
}
