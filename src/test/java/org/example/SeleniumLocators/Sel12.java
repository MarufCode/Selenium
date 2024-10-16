package org.example.SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Sel12 {

    // Locators
    // 1. ID, ClassName, Name, byTag F(n) -> GetText and GetAttribute (Webelements)

    // 2. LinkText & Partial Text
    // 3.Css Selectors
    // 4. Xpath

    @Test(groups="QA")
    @Description("Verify the current page URl")

    public void Login() {

        WebDriver driver = new EdgeDriver();
        // 1. Open the URL .app.vwo.com/#/login](https://app.vwo.com/#/login)
        driver.get("https://app.vwo.com");

        WebElement anchor_tag = driver.findElement(By.partialLinkText("Start a free"));
        System.out.println(anchor_tag.getAttribute("href"));
        anchor_tag.click();


        driver.close();

    }
}
