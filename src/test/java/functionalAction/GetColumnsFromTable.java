package functionalAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GetColumnsFromTable {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> tableHeaders = table.findElements(By.xpath("//th"));
        List<String> tableHeadingTexts = new ArrayList<String>();

        for (WebElement heading : tableHeaders) {
            String tableHeadingText = heading.getText();
            tableHeadingTexts.add(tableHeadingText);
        }
        String columnName = "Place";

        int columnIndex = tableHeadingTexts.indexOf(columnName);
        System.out.println(columnIndex);
        List<WebElement> columDatas = table.findElements(By.xpath("//td[" + (columnIndex +1)+ "]"));

        for(WebElement columnData:columDatas){
            System.out.println(columnData.getText());
        }

    }

}
