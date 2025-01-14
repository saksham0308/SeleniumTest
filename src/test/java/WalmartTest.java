import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WalmartTest {
//    @Test
    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in/");
        WebDriverWait webDriverWait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Laptops");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]//h2/span"));
        for(WebElement element:list)
        {
//                String name=element.findElement(By.xpath("//h2/span")).getText();
                System.out.println(element.getText());

        }
        WebElement lowerbound=driver.findElement(By.xpath("//div[@id='p_36/range-slider_slider-item']//div[1]/input"));
        WebElement upperbound=driver.findElement(By.xpath("//div[@id='p_36/range-slider_slider-item']//div[2]/input"));
//        while(lowerbound.getDomAttribute("aria-valuetext")<upperbound.getDomAttribute("aria-valuetext"))
//        {
//
//        }
        for(int i=0;i<10;i++)
        {
            lowerbound.sendKeys(Keys.ARROW_RIGHT);
            upperbound.sendKeys(Keys.ARROW_LEFT);
        }
        String productName=list.get(0).getText();
        list.get(0).click();
        Set<String> windowHandles=driver.getWindowHandles();
        String currentWindow=driver.getWindowHandle();
        for(String WindowHandles:windowHandles){
            if(WindowHandles!=driver.getWindowHandle())
                driver.switchTo().window(WindowHandles);

        }
        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
//        System.out.println(lowerbound.getDomAttribute("aria-valuetext"));
//        System.out.println(upperbound.getDomAttribute("aria-valuetext"));
        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
        //div[@data-name='Active Items']/div[@data-csa-c-type='item']//span[contains(@class,'a-truncate-cut')]
        System.out.println("Proudct Name is "+ productName);
        System.out.println("Product Found is "+driver.findElement(By.xpath("//div[@data-name='Active Items']/div[@data-csa-c-type='item']//span[contains(@class,'a-truncate-cut')]")).getText());
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-name='Active Items']/div[@data-csa-c-type='item']//span[contains(@class,'a-truncate-cut')]")).getText().contains(productName));

    }
}

