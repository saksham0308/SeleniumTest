package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearch {
    @FindBy(xpath = "//input[@type='text']")
    WebElement productSe;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;
    WebDriver driver;
    public ProductSearch(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void search(String name)
    {
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(name);
        productSe.sendKeys(name);

//        driver.findElement(By.xpath("//input[@type='submit']")).click();
        submit.click();
    }
}
