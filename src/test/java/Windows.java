import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Set;

public class Windows {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Windowtest() throws InterruptedException {
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);

        String oldwindow = driver.getWindowHandle();
        System.out.println("Parent window = "+oldwindow);

        //Click and Confirm new Window Opens
        WebElement element_01 = driver.findElement(By.xpath("//*[@id=\"j_idt88:new\"]"));
        element_01.click();
        Thread.sleep(3000);

        Set<String> newwindowlist = driver.getWindowHandles();
        System.out.println("No of opened windows = "+newwindowlist.size());

        for (String newWindow:newwindowlist){
            System.out.println("New window name = "+newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page titile is = "+driver.getTitle());
        }
        driver.close();

        driver.switchTo().window(oldwindow);//make the focus to parent window again

        //Find the no of opened tabs
        WebElement multiTabs_01 = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]"));
        multiTabs_01.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int count = multiWindows.size();
        System.out.println(count);

        WebElement multiTabs_02 = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt93\"]"));
        multiTabs_02.click();
        Thread.sleep(3000);

        Set<String> nextMultiWindows = driver.getWindowHandles();
        for (String allwindows:nextMultiWindows){
            if(!allwindows.equals(oldwindow)){
                driver.switchTo().window(allwindows);
                driver.close();
            }
        }

//        driver.switchTo().window(oldwindow); -> before close you have to switch the parent window
//        driver.close();

        driver.quit();//close all browser windows

        //driver.close(); -> close a single browser window that has the current focus
        //driver.quit(); -> close all opened  browser windows
    }
}
