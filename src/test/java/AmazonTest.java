import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Cart;
import pages.FilterPrint;
import pages.Login;
import pages.ProductSearch;

import javax.net.ssl.HttpsURLConnection;
import javax.print.DocFlavor;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.net.URL;

// learn isEnabled() ,isDisplayed() isSelected(),  submit() , getLocation() , clear(), getDomAttribute() and other function of WebElement element
//identify locators siblings, parents, child and more

public class AmazonTest extends BaseTest {
    String name;
    List<WebElement> productList;
//    WebDriver driver;
    @Test(groups = {"regression"})
    public void amazonLoginAndSearch()
    {
        Login login1=new Login(driver);
        login1.amazon1();
        ProductSearch search=new ProductSearch(driver);
        search.search("Laptops");

        FilterPrint filterPrint=new FilterPrint(driver);
        name=filterPrint.filterandPrint();
        productList=filterPrint.getProductList();

        Cart cart=new Cart(driver);
        cart.OpenCart(productList);

    }
//    @Test(dependsOnMethods = {"amazonLoginAndSearch"},groups = {"regression"})
    public void printingAndFilter()
    {
        FilterPrint filterPrint=new FilterPrint(driver);
        name=filterPrint.filterandPrint();
        productList=filterPrint.getProductList();
    }
//    @Test(dependsOnMethods = {"printingAndFilter"})
    public void OpenAddToCart()
    {
        Cart cart=new Cart(driver);
        cart.OpenCart(productList);
    }
    @Test
    public void NewFlipkartTest()
    {
        driver.get("https://www.udemy.com/");
    }

    @Test
    public void navigation()
    {
        driver.get("https://www.udemy.com/");
        driver.navigate().to("https://www.amazon.in/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
    @Test
    public void manage()
    {
        driver.get("https://www.udemy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().minimize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void BasicGet()
    {
        driver.get("https://www.udemy.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle());
        System.out.println(driver.getClass());
        System.out.println(driver.getWindowHandles());
    }
    @Test
    public void switchTo() throws InterruptedException {

        driver.get("https://www.udemy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.switchTo(
//        driver.switchTo().alert().dismiss();
//        driver.switchTo().alert().accept();
//        driver.switchTo().alert().getText();
//        driver.switchTo().alert().sendKeys("OK");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        Thread.sleep(10);

//        driver.switchTo().window("TestWINDOW");
    }

    @Test
    public void multiWindowUsingSwitchTO() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//        driver.findElement(By.xpath("//a[text()='Click Here']")).getScreenshotAs(OutputType.FILE);
        Set<String> allWIndowHandles=driver.getWindowHandles();
        String parentWindow=driver.getWindowHandle();
        for(String windowHandles:allWIndowHandles)
        {
            if(!parentWindow.equals(windowHandles))
                driver.switchTo().window(windowHandles);
        }
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
    }
    @Test
    public void ActionClass() throws InterruptedException {
        driver.get("https://www.udemy.com/");
        Actions actions1=new Actions(driver);
//        actions1.moveToElement("").sendKeys(Keys.SHIFT).sendKeys("OK")
        actions1.moveToElement(driver.findElement(By.xpath(""))).doubleClick().build().perform();
        actions1.contextClick().build().perform(); //right click
        actions1.keyDown(Keys.CONTROL).build().perform(); //holding down shift or control keys
        actions1.doubleClick();
    }

    @Test
    public void Waits()
    {

        //explicit wait with condition
        //ex 1
//        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//button[text()='Start']")).click();
//        WebElement element1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
//        System.out.println(element1.getText());

        //ex 2
//        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
//        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//button[text()='Start']")).click();
//        WebElement element2=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
//        System.out.println(element2.getText());

        //fluent wait

//        ex-3
        Wait<WebDriver> fluentWait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))  // Maximum time to wait
                .pollingEvery(Duration.ofMillis(500)) // Check every 500 ms
                .ignoring(NoSuchElementException.class);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement element3=fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        System.out.println(element3.getText());
//        ex-4

        Wait<WebDriver> fluentWait2 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))  // Maximum time to wait
                .pollingEvery(Duration.ofMillis(500)) // Check every 500 ms
                .ignoring(NoSuchElementException.class);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement element4=fluentWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
        System.out.println(element4.getText());

    }


//    In Selenium, if you are inside the first child frame, you cannot directly navigate to the second child frame.
//    You must first switch back to the parent frame and then switch to the second child frame.
//    This is because Selenium's driver.switchTo().frame() operates only within the current frame's context or its descendants.

//    Why Can't You Jump Across Sibling Frames?
//    Selenium treats each <frame> or <iframe> as an isolated browsing context.
//    To interact with another sibling frame (e.g., second child frame), you need to return to the parent frame to reset the context and then switch to the desired sibling frame.


    //    Recap
//    To switch between sibling frames, return to the parent frame first, then switch to the desired sibling frame.
//    Use driver.switchTo().parentFrame() to move one level up or driver.switchTo().defaultContent() to reset the context entirely.
    @Test
    public void FrameTest() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0); //indexing start from 0
        Actions actions=new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//div[@id='droppable']"))).release().build().perform();

        //assignments
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        //one way
//        driver.switchTo().frame(0);
//        driver.switchTo().frame(1);
//        System.out.println(driver.findElement(By.xpath("//div")).getText());

        //2nd way
        WebElement elements=driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(elements);
        List<WebElement> allframes=driver.findElements(By.xpath(".//frame[contains(@src,'frame')]"));
        for(WebElement element:allframes)
        {
            driver.switchTo().frame(element);
            System.out.println(driver.findElement(By.xpath(".//body")).getText());
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
    }
    @Test
    public void Alert() throws InterruptedException {


        driver.get("https://demo.automationtesting.in/Alerts.html");


        //Ok
        driver.findElement(By.xpath("//button[@onClick='alertbox()']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();


        //ok and cancel
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@onClick='confirmbox()']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//button[@onClick='confirmbox()']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();


        // alert with textbox
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@onClick='promptbox()']")).click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(5000);
        alert.sendKeys("Bhai bahu");
        alert.accept();
        driver.findElement(By.xpath("//button[@onClick='promptbox()']")).click();
        alert=driver.switchTo().alert();
        Thread.sleep(5000);
        alert.sendKeys("Bhai bahu");
        alert.dismiss();
//        alert.sendKeys("Bhai bahu");

    }
    @Test
    public void flipkartAchintya()  throws InterruptedException {

        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("van heusen jacket");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath(" //div[text()='Color']")).click();
        driver.findElement(By.xpath("//div[@title='Blue']")).click();
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Popularity']")));
//        driver.findElement(By.xpath("//div[text()='Popularity']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Popularity']"))).click();
        Thread.sleep(10000);
        List<WebElement> productList=driver.findElements(By.xpath("//div[@style='width: 25%;']"));
        for(WebElement product:productList)
        {
            try {
                WebElement productName = product.findElement(By.xpath(".//div[@class='syl9yP']"));
                System.out.print("Product Brand is " + productName.getText() + " | ");
            }
            catch (Exception e){}
            try {
                WebElement productName2 = product.findElement(By.xpath(".//a[contains(@class,'WKTcLC')]"));
                System.out.print("Product Name is " + productName2.getText() +" | ");
            }
              catch (Exception e){}
            try {
                WebElement productFinalPrice = product.findElement(By.xpath(".//div[contains(@class,'Nx9bqj')]"));
                System.out.print("Product Final Price is " + productFinalPrice.getText() + " | ");
            }
              catch (Exception e){}
            try {
                WebElement productOriginalPrice = product.findElement(By.xpath(".//div[contains(@class,'yRaY8j')]"));
                System.out.print("Product Original Price is " + productOriginalPrice.getText() + " | ");
            }  catch (Exception e){}
            try {
            WebElement discountgiven=product.findElement(By.xpath(".//div[contains(@class,'UkUFwK')]"));
            System.out.print("Discount Given "+discountgiven.getText()+" | ");
        }  catch (Exception e){}

                System.out.println();


        }

    }


    @Test
    public void Practice1() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        String name=driver.findElement(By.xpath("//label[@for='benz']")).getText();
        driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
        System.out.println(name);
        List<WebElement> list=driver.findElements(By.xpath("//select/option"));
        for (WebElement element:list)
        {
            System.out.println("ELemet text is = "+element.getText());
            if(name.contains(element.getText()))
            {
                element.click();
                System.out.println("Found");
            }
            else System.out.println("Not found yet");
        }
        driver.findElement(By.xpath("//input[@class='inputs']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@value='Alert']")).click();
//        driver.switchTo().parentFrame();
        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();
        alert.accept();
        Assert.assertTrue(alertText.contains(name));
    }


    @Test
    public void CheckBrokenLink() throws IOException {
       URL url=new URL("String");
        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.connect();
        if(httpURLConnection.getResponseCode()==200)
        {
            //checking valid or not
        }
    }

    @Test
    public void SoftAssert() throws IOException {
       SoftAssert softAssert=new SoftAssert();
       softAssert.assertEquals("","");
       softAssert.assertAll();

    }




}
