package org.example.SeleniumXpathandCSS;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class practice {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups="QA")
    @Description("Verify the dashboard of VWO Page")
    public void pageVerify(){
    driver.get("https://app.vwo.com");
    driver.manage().window().maximize();

        driver.findElement(By.id("login-username")).sendKeys("marufsherikar32@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Maruf@2033");
        driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='page-heading']")));
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-qa='page-heading']")).isDisplayed());
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
