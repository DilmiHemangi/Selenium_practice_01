import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class ElementDownloading {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void DownloadingTest_01(){
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();

        File file = new File("C:\\Users\\yasir\\Downloads");
        File[] allFiles = file.listFiles();

        for (File file_01:allFiles){
            if(file_01.getName().equals("TestLeaf Logo.png")){
                System.out.println("File has been downloaded");
                break;
            }
        }
    }

    @Test
    public void DownloadingTest_02() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
//        driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt89\"]")).click();
//
//        String img = "C:\\Users\\yasir\\OneDrive\\Documents\\lotus.jpeg";
//        StringSelection selector = new StringSelection(img);
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selector,null);
//
//        Thread.sleep(4000);// Run too much fast
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(3000);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);


        WebElement button = driver.findElement(By.id("j_idt88:j_idt89_input"));
        String img = "C:\\Users\\yasir\\OneDrive\\Documents\\lotus.jpeg";
        button.sendKeys(img);

    }
}
