import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSExecutorExample {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void Test_01(){
        jsExecutor = (JavascriptExecutor) driver;
        //Get alert box
        jsExecutor.executeScript("alert('I am Dilmi')");
        driver.switchTo().alert().accept();

        //Set an input value in a textbox
        WebElement e1 = driver.findElement(By.xpath("//*[@id='name']"));
        jsExecutor.executeScript("arguments[0].value='Dilmi';", e1);

    }

    @Test
    public void Test_02() throws InterruptedException {
        jsExecutor = (JavascriptExecutor) driver;
        //Highlight an element
        WebElement e1 = driver.findElement(By.xpath("//*[@id='name']"));
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", e1);

        Thread.sleep(3000);

        //Click an element
        WebElement e2 = driver.findElement(By.xpath("//*[@id='female']"));
        jsExecutor.executeScript("arguments[0].click();", e2);

        //Scrolling the page
        scrollPage();


    }

    public void scrollPage() throws InterruptedException {
        jsExecutor.executeScript("window.scrollTO(0,1000);");
        System.out.println("Page offset = "+jsExecutor.executeScript("return.window.pageYOffset;"));
        jsExecutor.executeScript("window.scrollTO(0,-1000);");
        Thread.sleep(3000);

        //scroll bottom of the page
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(3000);

        //scroll to top of the page
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(3000);

        //scroll the page till element is visible
        WebElement e3 = driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[3]/label"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", e3);
    }
}
