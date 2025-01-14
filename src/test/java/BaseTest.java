import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Set;

public class BaseTest {
    WebDriver driver;
     WebDriverWait wait;
    String currentHandle;
    Set<String> allWindowHandles;
    @BeforeMethod(alwaysRun = true)
    public void baseTest()
    {
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        currentHandle=driver.getWindowHandle();
        allWindowHandles=driver.getWindowHandles();
        ChromeOptions options=new ChromeOptions();

    }
    @AfterMethod(alwaysRun = true)
    public void last()
    {
//        driver.close();
//        driver.quit();
//        driver.switchTo().window(currentHandle);
//        System.out.println(driver.getCurrentUrl());
//        driver.findElement()
    }

}
