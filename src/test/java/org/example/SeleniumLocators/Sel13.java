package org.example.SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Sel13 {

    @Test(groups = "QA")
    @Description("Verify the current URl, title of VWO app")
    public void testVWOLogin13() {
        WebDriver driver = new EdgeDriver();
        // 1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com");

        // Question - Print all the anchor Tags on this vwo.com
        // a tags and print the getText

       List<WebElement> all_tags = driver.findElements(By.tagName("a"));
       all_tags.get(0).click();
       all_tags.get(1).click();
       all_tags.size();
       for (WebElement element : all_tags){
           System.out.println(element.getText());
       }



        driver.close();

    }
}




























