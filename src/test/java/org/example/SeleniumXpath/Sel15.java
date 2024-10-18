package org.example.SeleniumXpath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sel15 {

    @Test(groups= "QA")
    @Description("verify the URL of katalon Page")

    public void login() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();


        WebElement btnElement = driver.findElement(By.id("btn-make-appointment"));
        btnElement.click();

        Thread.sleep(2000);
        // Assert the current URl

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username = driver.findElement(By.id ("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement logIn = driver.findElement(By.id("btn-login"));
        logIn.click();

        driver.quit();


    }
}
