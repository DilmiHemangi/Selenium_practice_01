import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Frames {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/frame.xhtml");
        driver.manage().window().maximize();
    }

    @Test
    public void FrameTest(){

        driver.switchTo().frame(0);

        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"Click\"]"));
        e1.click();

        String text1 = driver.findElement(By.xpath("//*[@id=\"Click\"]")).getText();
        System.out.println("After click on button frame, the text is  = "+text1);

        //Click Me (Inside Nested frame)
        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement e2 = driver.findElement(By.xpath("//*[@id=\"Click\"]"));
        e2.click();
        System.out.println("Button text = "+e2.getText());

        //How many frames in this page?
        driver.switchTo().defaultContent();
        List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
        int count = frameList.size();
        System.out.println("No of frames = "+count);

        for(WebElement elements :frameList){
            String srcLink = elements.getAttribute("src");
            System.out.println("Frame links = "+srcLink);
        }

        driver.quit();
    }
}
