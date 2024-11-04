package org.example.SVG;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class Sel32 {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement frstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(frstName, "Maruf")
                .keyUp(Keys.SHIFT).build().perform();

        Thread.sleep(3000);

        WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'Click here to Download File')]"));
        actions.contextClick(link).build().perform();


        Thread.sleep(3000);













    }

        @AfterTest
        public void closeBrowser(){
            driver.quit();


        }
    }

