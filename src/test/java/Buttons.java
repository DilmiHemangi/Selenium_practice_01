import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Buttons {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        driver = new ChromeDriver();
        Dimension newsize = new Dimension(600,800);       driver.get("https://www.leafground.com/button.xhtml");
        driver.manage().window().setSize(newsize);
    }

    @Test
    public  void ButtonTest(){
        //Click and Confirm title.
        driver.findElement(By.xpath("//*[@id='j_idt88:j_idt90']")).click();
        String actual = "Dashboard";
        String expected = driver.getTitle();
        if (actual.equals(expected)){
            System.out.print("Actual title equals to expected title.");
        }else {
            System.out.print("Actual title is not matched with expected title.");
        }

        //Assert.assertEquals(actual,expected,"Actual title is not matched with expected title.");

        //Confirm if the button is disabled.
        driver.navigate().back();
        WebElement element_01 = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt92']"));
        element_01.isDisplayed();
        if (element_01.isDisplayed()){
            System.out.print("Button is disabled.");
        }else {
            System.out.print("Button is enabled.");
        }

        //Find the position of the Submit button
        WebElement element_02 = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt94']"));
        Point point = element_02.getLocation();
        int x = point.getX();
        int y = point.getY();
        System.out.print("X point is "+x+" and Y point is "+y);
        //Find the Save button color
        WebElement buttoncolor = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt96']"));
        String color = buttoncolor.getCssValue("background");
        System.out.println("Button color is " +color);
//Find the height and width of this button
        WebElement element_05 = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt98']"));
        int height = element_05.getSize().getHeight();
        int width = element_05.getSize().getWidth();
        System.out.println("Button height is "+height+" and width is "+width);
}
}