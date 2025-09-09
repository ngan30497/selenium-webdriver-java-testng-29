import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadAFile {
   /* sendKeys() can be used to upload a file in Selenium WebDriver
        Uploading the files from a workspace folder instead of local
*/
   public static void main(String[] args) {
       WebDriver driver;
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://omayo.blogspot.com/");

       String projectPath =System.getProperty("user.dir");
       System.out.println(projectPath);

       driver.findElement(By.id("uploadfile")).sendKeys(projectPath+"\\dataFile\\auto_test.jpg");

   }

}
