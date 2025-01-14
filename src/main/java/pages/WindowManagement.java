package pages;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManagement {
    WebDriver driver;
    Set<String> windowHandles;
    String currentWindow;
    WindowManagement(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebDriver getImmedieteNext()
    {
        windowHandles=driver.getWindowHandles();
        currentWindow=driver.getWindowHandle();

        for(String WindowHandles:windowHandles){
            if(WindowHandles!=driver.getWindowHandle())
                driver.switchTo().window(WindowHandles);

        }
        return driver;
    }
}
