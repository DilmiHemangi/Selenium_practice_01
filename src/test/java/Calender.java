import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Calender {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test_01() throws InterruptedException {
        driver.get("https://jqueryui.com/datepicker");
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        WebElement e1 = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        e1.sendKeys("02/07/2025");

        e1.click();

        while (true){
            String year = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
            String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();

            if(year.equals("2020") && month.equals("May")){
                break;
            }else {
                driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]")).click();
            }
        }

        List<WebElement> NumberList = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement date:NumberList){
            if(date.getText().equals("3")){
                date.click();
                break;
            }
        }
    }
}
