package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilterPrint {
    @FindBy(xpath = "//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]//h2/span")
    List<WebElement> productList;
    @FindBy(xpath = "//div[@id='p_36/range-slider_slider-item']//div[1]/input")
    WebElement lowerbound;
    @FindBy(xpath = "//div[@id='p_36/range-slider_slider-item']//div[2]/input")
    WebElement upperbound;
    WebDriver driver;
    public FilterPrint(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String filterandPrint()
    {
//        List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]//h2/span"));
        for(WebElement element:productList)
        {
//                String name=element.findElement(By.xpath("//h2/span")).getText();
            System.out.println(element.getText());
//            element

        }
//        WebElement lowerbound=driver.findElement(By.xpath("//div[@id='p_36/range-slider_slider-item']//div[1]/input"));
//        WebElement upperbound=driver.findElement(By.xpath("//div[@id='p_36/range-slider_slider-item']//div[2]/input"));
//        while(lowerbound.getDomAttribute("aria-valuetext")<upperbound.getDomAttribute("aria-valuetext"))
//        {
//
//        }
        for(int i=0;i<10;i++)
        {

            lowerbound.sendKeys(Keys.ARROW_RIGHT);
            upperbound.sendKeys(Keys.ARROW_LEFT);
        }
        String productName=productList.get(0).getText();
        return productName;
    }
    public List<WebElement> getProductList()
    {
        return productList;
    }

}
