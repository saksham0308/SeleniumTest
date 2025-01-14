package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;


// selenium web driver performs action such as clicking typing selecting and other actions, so locators are a way to identify elements
// on a web page , selenium web driver uses any of the below locator to identify the elements and perform various action.

// id
// name
// className
// tagName
// linkText
// css Selector
// xpath

public class Locators {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver=new ChromeDriver();
//        WebDriver driver=new FirefoxDriver();
//        WebDriver driver=new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getPageSource());
//        System.out.println(driver.getClass());
//        System.out.println(driver.getWindowHandle());
//        driver.close(); // closes current window/tab where driver focuses is
//        driver.quit();  // closes all window/tab opened by driver

        //locators are acts like an address for selenium driver to find the particular element and take action on it
        //ID , XPATH, CSS SELECTOR, NAME, CLASS NAME, TAG NAME, LINK TEXT, PARTIAL LINK TEXT

        //ID
        driver.findElement(By.id("inputUsername")).sendKeys("saksham");

        //name
        driver.findElement(By.name("inputPassword")).sendKeys("MERA PASSWORD");
//       String test=driver.findElement(By.name("inputPassword"));
//       System.out.println(test);

        //Class Name
        driver.findElement(By.className("submit")).click();
        String errorMessage=driver.findElement(By.className("error")).getText();
        System.out.println(errorMessage);

        //GENERIC CSS SELECTOR tagName[attribute='value']
        driver.findElement(By.cssSelector("p[class='error']"));

        //LINK TEXT , give text of  a link need to click
        driver.findElement(By.linkText("Forgot your password?")).click();


        // XPATH- mostly same as css selector -> //tagName[@attribute='value']

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("AGAIN EMAIL");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("saksham@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear(); // clearing using css

        //xpath using index when no uniqueness is found in locators , indexes start at 1 not 0
        driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("7898989898");
//        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7898989898");



        //write xpath from parent to child, only using tags
        driver.findElement(By.xpath("//form/input[2]")).sendKeys("1234567");
        Thread.sleep(2000); //better use explicit wait
        driver.findElement(By.xpath("//div/button[2]")).click();
        String resetClicked=driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        System.out.println(resetClicked);
        String myPas=GetPassword(resetClicked);
        driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form/input[1]")).clear();
        driver.findElement(By.id("inputUsername")).sendKeys("okOkOkO");
        driver.findElement(By.name("inputPassword")).sendKeys(myPas);
        driver.findElement(By.className("submit")).click();
        Thread.sleep(2000);
        String loggedIn=driver.findElement(By.xpath("//div/p")).getText();
        System.out.println(loggedIn);
//        Assert.assertEquals(loggedIn,"You are successfully logged in.","Incorrect loggedIn text");
//        Assert.assertEquals(loggedIn,"You are successfully logged in","Incorrect loggedIn text " + loggedIn );


        // generating xpath using button text
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();



        // generating xpath from siblings

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String str=driver.findElement(By.xpath("//header/div/button[1]")).getText();
        System.out.println(str);
        String str2=driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(str2);
        String str3=driver.findElement(By.xpath("//div/button[1]/following-sibling::button[2]")).getText();
        System.out.println(str3);

        // generating xpath from child to parent
        String ss =driver.findElement(By.xpath("//button[1]//parent::div")).getText();
        System.out.println(ss);
        String ss1 =driver.findElement(By.xpath("//div/a/button")).getText();
        System.out.println(ss1);
    }

    private  static String GetPassword(String str)
    {
        String[] s1=str.split("'");
        System.out.println(s1[0]+" okay "+s1[1]);
        return s1[1];
    }


}
