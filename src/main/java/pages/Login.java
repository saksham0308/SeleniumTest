package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver1)
    {
        this.driver=driver1;
    }

    public void amazon1()
    {
        driver.get("https://www.amazon.in/");
    }

}
