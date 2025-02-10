import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class Dropdowns {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void DropdownTest_01() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node019lqs7548r5a6dtuebuhc2rmt8678785.node0");
        WebElement element_01 = driver.findElement(By.xpath("//*[@id='j_idt87']/div/div[1]/div[1]/div/div/select"));
        Select select = new Select(element_01);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //Get no of options
        List<WebElement> options = select.getOptions();
        int size = options.size();
        System.out.println("No of options = "+size);

        for (WebElement element:options){
            System.out.println(element.getText());
        }

        //Using sendkeys slection dropdown values
        element_01.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //Select a value from a boostrap dropdown
        WebElement element_02 = driver.findElement(By.xpath("//*[@id='j_idt87:country']"));
        element_02.click();
        List<WebElement> dropdown_list = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for(WebElement element:dropdown_list){
            String dropdownValue = element.getText();
            if (dropdownValue.equals("USA")){
                element.click();
                break;
            }

        }



    }

    @Test
    public void googleSearchDropdown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("Palitha");
        Thread.sleep(3000);
        List<WebElement> googledropdown = Collections.singletonList(driver.findElement(By.xpath("//ul[@role='listbox']/li//div/[@class='sbct PZPZlf']")));
        System.out.println("List size is "+googledropdown.size());
        for(WebElement element:googledropdown){
            System.out.println(element.getText());
        }
    }

//    Handle middle auto suggestions drop down and search using DOM debugger trick
//
//    Sources-> Snippets ->write the following command and run
//    setTimeout(function(){
//        debugger;
//    },3000);
}
