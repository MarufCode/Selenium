package org.example.seleniumLearning;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class checkBox {


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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement ch1 = checkboxes.get(0);
        ch1.click();

        String text = driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]")).getText();
        Assert.assertEquals(text, "Elemental Selenium");
        System.out.println(text);

    }










    @AfterTest
    public void closeBrowser(){
    driver.quit();
    }
}
