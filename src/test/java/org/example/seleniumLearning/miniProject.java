package org.example.seleniumLearning;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class miniProject {
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
        String URL = "https://katalon-demo-cura.herokuapp.com";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        WebElement element_select= driver.findElement(By.id("combo_facility"));
        Select sel = new Select(element_select);
        sel.selectByVisibleText("Seoul CURA Healthcare Center");

        driver.findElement(By.id("chk_hospotal_readmission")).click();

        WebElement health_care_Program = driver.findElement(By.xpath("//input[@id=\"radio_program_none\"]"));
        health_care_Program.click();

        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys("22-10-2024");

        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Hello Automation");

        driver.findElement(By.id("btn-book-appointment")).click();

        String result = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]")).getText();
        Assert.assertEquals(result,"Appointment Confirmation" );
        System.out.println(result);

        String comment_msg = driver.findElement(By.id("comment")).getText();
        Assert.assertEquals(comment_msg, "Hello Automation");
        System.out.println(comment_msg);

        Thread.sleep(2000);
}







    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
