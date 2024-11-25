package org.example.Selenium0511;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
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

public class QPUploadTC {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case of File Upload for multiple users request")
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

        for (int i = 1; i <= 50; i++) {
            System.out.println("Starting upload iteration: " + i);

            WebElement uploadQP = driver.findElement(By.xpath("//input[@id=\"QPFile\"]"));
            String dir = System.getProperty("user.dir");
            uploadQP.sendKeys(dir + "\\src\\test\\java\\org\\example\\Selenium0511\\Accommodation_Operations-Semester_III-QPTemplate.docx");

            WebElement uploadSynoptic = driver.findElement(By.xpath("//input[@id=\"SynopticAnswerFile\"]"));
            uploadSynoptic.sendKeys("C:\\Users\\Maruf.sherikar.EXT.SVKMGRP\\IdeaProjects\\Selenium\\src\\test\\java\\org\\example\\Selenium0511\\Accommodation_Operations-Semester_III-SynopticsTemplate.docx");

            Actions actions1 = new Actions(driver);
            actions1.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(1000);
            System.out.println("Scroll Down");
            Thread.sleep(1000);


            WebElement checkbox = driver.findElement(By.xpath("//li[@id='menu-id-21']//input[@type='checkbox']"));
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement clickableCheckbox = wait.until(ExpectedConditions.elementToBeClickable(checkbox));
                clickableCheckbox.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted. Retrying with JavaScript...");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            }


            Actions actions3 = new Actions(driver);
            actions3.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(1000);
            System.out.println("Scroll Down");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement undertaking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Undertaking']/preceding-sibling::input[@type='checkbox']")));


            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", undertaking);
            undertaking = wait.until(ExpectedConditions.elementToBeClickable(undertaking));
            undertaking.click();

            Actions actions2 = new Actions(driver);
            actions2.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(1000);
            System.out.println("Scroll Down");

            WebElement qpUpload = driver.findElement(By.xpath("//button[@class=\"btn btn-danger rounded-0 uploadQuestionPaper\"]"));
            qpUpload.click();
            Thread.sleep(1000);

            WebElement confirm = driver.findElement(By.xpath("//button[@id=\"confirm-btn-yes\"]"));
            confirm.click();

            Thread.sleep(2000); // Wait for the confirmation dialog to close
            WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
            okButton.click();

            System.out.println("Upload iteration " + i + " completed successfully.");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//button[@data-bs-dismiss=\"toast\"]")).click();
            Thread.sleep(5000);

            Actions actions5 = new Actions(driver);
            actions5.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).build().perform();
            Thread.sleep(1000);
            System.out.println("Scroll UP");
        }
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();


    }
}


