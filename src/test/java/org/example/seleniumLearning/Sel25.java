package org.example.seleniumLearning;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sel25 {

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
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

//        WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Alert')]"));
//        WebElement elementConfirm = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Confirm')]"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]"));
//        element.click();
//        elementConfirm.click();
        elementPrompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Maruf");
//        alert.accept();
        alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result, "You successfully clicked an alert");
//        Assert.assertEquals(result, "You entered: Maruf");
        Assert.assertEquals(result, "You entered: null");


        Thread.sleep(3000);











    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
