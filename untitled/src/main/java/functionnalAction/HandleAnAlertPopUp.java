package functionnalAction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAnAlertPopUp {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        driver.findElement(By.id("alert1")).click();

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.dismiss();

        driver.findElement(By.id("ta1")).sendKeys("Co len");
    }
}
