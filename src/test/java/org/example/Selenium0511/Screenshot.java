package org.example.Selenium0511;

import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot {


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
        String URL = "https://app.vwo.com/#/login";
        driver.get(URL);
        driver.manage().window().maximize();


        // Take screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define destination to save the screenshot
        File destinationFile = new File("screenshot.png");

        // Copy screenshot to the desired location
        FileUtils.copyFile(sourceFile, destinationFile);

        System.out.println("Screenshot saved successfully!");

        System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());





    }
}
