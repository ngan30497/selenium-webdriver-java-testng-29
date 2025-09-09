package functionalAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenElement {
    public static void main(String[] args) {
        WebDriver driver;
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.id("hide-textbox")).click();
        driver.findElement(By.id("hide-textbox")).sendKeys("Automation test");

        JavascriptExecutor js = (JavascriptExecutor) driver;
//        input text
        js.executeScript("document.querySelector(\"#displayed-text\").value='Test';");
    }

}
