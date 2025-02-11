import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class RadiobuttonAndCheckboxes {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTest(){
        //Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml;jsessionid=node0ewybdmps8x0b1g9km1ln99qvp8682463.node0");

        Boolean Chromeradiobutton = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        Boolean Firefoxradiobutton = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        Boolean Safariradiobutton = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        Boolean Edgeradiobutton = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (Chromeradiobutton){
            String ChromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println(ChromeText);
        }else if (Firefoxradiobutton){
            String FirefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println(FirefoxText);
        }else if (Safariradiobutton){
            String SafariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println(SafariText);
        }else{
            String EdgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println(EdgeText);
        }

        //Select the age group(Only if not selected)
        Boolean IsChecked = driver.findElement(By.id("j_idt87:age:0")).isSelected();
        if (!IsChecked){
            driver.findElement(By.xpath("//*[@id=\"j_idt87:age\"]/div/div[1]/div")).click();
        }
    }

    @Test
    public void checkboxTest(){
        //Select most favourite checkboxes and verify the selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> checkboxlist = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element:checkboxlist){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i = 1; i<=checkboxlist.size();i++){
            boolean CheckboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+i+"]")).isSelected();
            System.out.println("Checkbox "+ i + " selected status is " +CheckboxStatus);
        }
    }
}
