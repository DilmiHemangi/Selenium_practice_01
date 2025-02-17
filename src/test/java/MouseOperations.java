import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

public class MouseOperations {

    WebDriver driver;
    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void MouseActionTest_01() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("<<<<<<<<<<<<<< -------- MOVE TO ELEMENTS ---------- >>>>>>>>>>>>>>>>");

        WebElement e1 = driver.findElement(By.id("menuform:j_idt37"));
        WebElement e2 = driver.findElement(By.id("menuform:j_idt38"));
        WebElement e3 = driver.findElement(By.id("menuform:j_idt39"));

        Actions actions = new Actions(driver);
//        actions.moveToElement(e1).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(e2).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(e3).perform();
//        Thread.sleep(3000);

        actions.moveToElement(e1).moveToElement(e2).moveToElement(e3).perform();

        System.out.println("<<<<<<<<<<<<<< -------- DRAG AND DROP ELEMENTS ---------- >>>>>>>>>>>>>>>>");

        WebElement drag_element = driver.findElement(By.id("form:drag_content"));
        WebElement drop_element = driver.findElement(By.id("form:drop"));

//        actions.clickAndHold(drag_element).moveToElement(drop_element).release(drop_element).perform();
        actions.dragAndDrop(drag_element,drop_element).perform();

        WebElement pointer_01 = driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println("First location = "+pointer_01.getLocation());
        actions.dragAndDropBy(pointer_01,50,0).perform();
        System.out.println("Second location = "+pointer_01.getLocation());
    }

    @Test
    public void MouseActionTest_02() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        Actions action2 = new Actions(driver);
        WebElement element_3 = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
        action2.contextClick(element_3).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        String text = alert.getText();
        System.out.println("Alert text = "+text);
        alert.accept();
    }
}
