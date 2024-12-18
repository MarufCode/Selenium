package org.example.Selenium0511;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class FileUploadScenarioForMultiUsers {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }





    @Test(groups = "QA")
    @Description("Test Case of File Upload for multiple users")
    public void testPositive() throws InterruptedException {
        String URL = "https://uat-portal.svkm.ac.in:3006/login";
        driver.get(URL);
        driver.manage().window().maximize();


        WebElement userName = driver.findElement(By.xpath("//input[@id=\"inp-username\"]"));
        userName.sendKeys("52179060");

        WebElement pass = driver.findElement(By.xpath("//input[@id=\"inp-password\"]"));
        pass.sendKeys("pass@123");

        Thread.sleep(10000);
        WebElement signIn = driver.findElement(By.xpath("//span[text()=' Sign In ']"));
        signIn.click();

        Thread.sleep(40000);
        System.out.println("User has been successfully Logged In");

        driver.get("https://uat-portal.svkm.ac.in:3006/template-reviewer/question-paper-offline");

        WebElement year = driver.findElement(By.xpath("//select[@id=\"acadYearFilter\"]"));
        Select slt = new Select(year);
        slt.selectByValue("2024");

//        WebElement program = driver.findElement(By.xpath("//select[@id=\"programFilter\"]"));
//        Select sel = new Select(program);
//        sel.selectByVisibleText("BACHELOR OF BUSINESS ADMINISTRATION (HOSPITALITY OPERATIONS & MANAGEMENT) || 8801 || School of Hospitality");
        Thread.sleep(10000);

        WebElement session = driver.findElement(By.xpath("//select[@id=\"sessionFilter\"]"));
        Select sl = new Select(session);
        sl.selectByValue("Semester III");
        Thread.sleep(1000);

        WebElement subject = driver.findElement(By.xpath("//select[@id=\"subjectFilter\"]"));
        Select slct = new Select(subject);
        slct.selectByVisibleText("Accommodation Operations");
        Thread.sleep(1000);

        WebElement selectTemplate = driver.findElement(By.xpath("//select[@id=\"templateFilter\"]"));
        Select select = new Select(selectTemplate);
        select.selectByValue("4141");
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        System.out.println("Scroll Down");

        WebElement uploadQP = driver.findElement(By.xpath("//input[@id=\"QPFile\"]"));

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        uploadQP.sendKeys(dir+"\\src\\test\\java\\org\\example\\Selenium0511\\Accommodation_Operations-Semester_III-QPTemplate.docx");

        WebElement uploadSynoptic = driver.findElement(By.xpath("//input[@id=\"SynopticAnswerFile\"]"));

        uploadSynoptic.sendKeys("C:\\Users\\Maruf.sherikar.EXT.SVKMGRP\\IdeaProjects\\Selenium\\src\\test\\java\\org\\example\\Selenium0511\\Accommodation_Operations-Semester_III-SynopticsTemplate.docx");

//        Thread.sleep(20000);
        // C:\Users\Maruf.sherikar.EXT.SVKMGRP\IdeaProjects\Selenium\src\test\java\org\example\Selenium0511\Accommodation_Operations-Semester_III-QPTemplate.docx
        // C:\Users\Maruf.sherikar.EXT.SVKMGRP\IdeaProjects\Selenium\src\test\java\org\example\Selenium0511\Accommodation_Operations-Semester_III-SynopticsTemplate.docx



//        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        WebElement ch1 = checkboxes.get(0);
//        ch1.click();
//
//        WebElement checkbox = driver.findElement(By.xpath("//li[@id='menu-id-21']//input[@type='checkbox']"));
//        checkbox.click();

        Thread.sleep(10000);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement undertaking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"Undertaking\"]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", undertaking);
        undertaking = wait.until(ExpectedConditions.elementToBeClickable(undertaking));
        undertaking.click();

        WebElement qpUpload = driver.findElement(By.xpath("//button[@class=\"btn btn-danger rounded-0 uploadQuestionPaper\"]"));
        qpUpload.click();
        Thread.sleep(10000);

        WebElement confirm = driver.findElement(By.xpath("//button[@id=\"confirm-btn-yes\"]"));
        confirm.click();

        driver.findElement(By.xpath("//button[text()='OK']")).click();


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();


    }
}