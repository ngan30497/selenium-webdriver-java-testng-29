import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Duration;

public class TestSelenium {
    @Test
    public void TC01() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://id.opswat.com/register");

        driver.findElement(By.name("firstName")).sendKeys("An");
        driver.findElement(By.name("lastName")).sendKeys("Tran");
        driver.findElement(By.name("email")).sendKeys("Hoin67341@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Hoin67341@gmail.com");
        driver.findElement(By.name("passwordConfirmation")).sendKeys("Hoin67341@gmail.com");
        driver.findElement(By.name("companyName")).sendKeys("Opswat");

        WebElement countryElement = driver.findElement(By.xpath("//label[@id='country']/following-sibling::div/descendant::input[@class='customSelect__input']"));
        countryElement.sendKeys("Vietnam");
        countryElement.sendKeys(Keys.ENTER);

        WebElement referenceElement = driver.findElement(By.xpath("//label[@id='referralSources']/following-sibling::div/descendant::input[@class='customSelect__input']"));
        referenceElement.sendKeys("Email");
        referenceElement.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//span[contains(text(),'I agree')]/preceding::input[@type='checkbox']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        // cần phải dùng api, dịch vụ bên ngoài để giải quyết captcha.


    }


}
