package functionnalAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class DownloadAFile {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;


        ChromeOptions options=new ChromeOptions();
        HashMap<String, Object> chromePerf = new HashMap<String, Object>();
        chromePerf.put("profile.default_content_settings.popups",0);
        String downloadFilepath = System.getProperty("user.dir");
        chromePerf.put("download.default_directory",downloadFilepath);

        options.setExperimentalOption("prefs",chromePerf);

        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/p/page7.html");

        driver.findElement(By.linkText("ZIP file")).click();

        Thread.sleep(5000);

        File file = new File(downloadFilepath+"\\DownloadDemo-master.zip");
        if (file.exists()){
            System.out.println("Download file successfully");
        }else{
            System.out.println("Download file Not successfully");
        }
    }
}
