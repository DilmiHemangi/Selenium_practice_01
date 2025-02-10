import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextboxExample {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node01kes4nozmy5nmzopvlcu4lugi8667042.node0");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void Textbox(){
        //Type my name
        driver.findElement(By.id("j_idt88:name")).sendKeys("Dilmi Hemangi");

        //Append Country to this City.
        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Sri Lanka");

        //Verify if text box is disabled
        WebElement e3 = driver.findElement(By.name("j_idt88:j_idt93"));
        Boolean b1 = e3.isEnabled();
        System.out.print("Is text box enabled" + b1);

        //Clear the typed text.
        WebElement e4= driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        e4.clear();

        //Retrieve the typed text.
        WebElement e5= driver.findElement(By.xpath("//*[@id='j_idt88:j_idt97']"));
        String value = e5.getAttribute("value");
        System.out.print(value);

        //Type email and Tab. Confirm control moved to next element.
        WebElement e6 = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt99']"));
        e6.sendKeys("dilmi@gmail.com"+ Keys.TAB +"Confirm control moved to next element.");

        WebElement element_05 = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt98']"));
        int height = element_05.getSize().getHeight();
        int width = element_05.getSize().getWidth();
        System.out.print("Button height is "+height+" and width is "+width);
    }
}
