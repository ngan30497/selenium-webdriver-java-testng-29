import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssert {
    @Test(priority = 0)
    public void testOne() {
        Assert.assertEquals(9, 9);
        Assert.assertTrue(9 > 8);

    }

    @Test(priority = 1)
    public void testTwo() {
        if (9 > 10) {
            Assert.fail("test");
        }
    }

    @Test(priority = 2)
    public void test3() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,"Your Store");
    }
}
