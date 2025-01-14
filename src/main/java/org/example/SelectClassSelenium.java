package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClassSelenium {
    public static void main(String[] args) throws InterruptedException {
//        The Select class in Selenium is used to interact with dropdown elements
//        in a web page. It is specifically designed to handle <select> HTML tags.
//        With the Select class, you can select or deselect options in a dropdown menu.

//        When to Use the Select Class?

//        Use the Select class if:
//        The dropdown is defined using the <select> tag.
//        The options in the dropdown are inside <option> tags.

        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); // it has internal wait so it will
        // wait untll all elements are loaded then move to next line of code
        WebElement webEle=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDropdown=new Select(webEle);
        staticDropdown.selectByIndex(3);
        Thread.sleep(2000);
//        staticDropdown.deselectByIndex(3);
//        Thread.sleep(2000);
        staticDropdown.selectByValue("INR");
        Thread.sleep(2000);
//        staticDropdown.deselectByValue("INR");
//        Thread.sleep(2000);
        staticDropdown.selectByVisibleText("AED");
//        Thread.sleep(2000);
//        staticDropdown.deselectByVisibleText("AED");
        System.out.println(staticDropdown.isMultiple());
//        staticDropdown.deselectAll();

        // DESELECT ONLY WORKS IF DROPDOWN IS MULTISELECT
        WebElement firstOption=staticDropdown.getFirstSelectedOption();
        System.out.println(firstOption.getText());
        List<WebElement> optionList=staticDropdown.getOptions();
        for( WebElement option:optionList)
        {
            System.out.println(option.getText());
        }
        System.out.println(staticDropdown.getClass());
        List<WebElement> allSELECTEDOPTOn=staticDropdown.getAllSelectedOptions();
        for (WebElement allOption:allSELECTEDOPTOn)
        {
            System.out.println(allOption.getText());
        }
        System.out.println(staticDropdown.getWrappedElement());




    }

}
