package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class Cart {
    @FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
    WebElement addToCart;
    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    WebElement goToCart;
    WebDriver driver;
    WindowManagement windowManagement;
    public Cart(WebDriver driver)
    {
        this.driver=driver;
        windowManagement=new WindowManagement(driver);
        PageFactory.initElements(driver,this);
    }
    public void OpenCart(List<WebElement> productList)
    {
        productList.get(0).click();
        driver=windowManagement.getImmedieteNext();
//        driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
        addToCart.click();
//        driver.findElement(By.xpath("//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")).click();
        goToCart.click();
    }
}
