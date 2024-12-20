package org.example.Selenium0511;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class dropdown {


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
    public void testPositive() throws InterruptedException, IOException {
        String URL = "https://www.kapruka.com/online/samedaydelivery";
        driver.get(URL);
        driver.manage().window().maximize();


        List<WebElement> table = driver.findElements(By.xpath("//div[@class=\"Rebrand_table space-bot\"]"));

        for (WebElement ele: table){
            System.out.println(ele.getText());

        }



















    }
}
