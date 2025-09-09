package orangHRMdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/auth/login");
    }
    @Test
    public void loginTestCaseFailed(){
        WebElement useName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        useName.sendKeys("Admin");

        WebElement passWord=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passWord.sendKeys("test");
        driver.findElement(By.tagName("button")).click();
        WebElement invalidMess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Invalid credentials']")));
        boolean isInvalidMessVisible=invalidMess.isDisplayed();
        Assert.assertTrue(isInvalidMessVisible);
    }

    @Test
    public void loginTestCaseSuccessful(){
        WebElement useName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        useName.sendKeys("Admin");

        WebElement passWord=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passWord.sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();
        WebElement dashBoardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("//h6")));
        String text=dashBoardElement.getText();
        Assert.assertEquals(text,"Dashboard");

        driver.findElement(By.xpath("//span[text()='My Info']")).click();

        driver.findElement(By.xpath("//label[text()='Date of Birth']//parent::div//following-sibling::div//i")).click();
    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
