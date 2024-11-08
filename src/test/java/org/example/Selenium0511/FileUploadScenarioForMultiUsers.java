package org.example.Selenium0511;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileUploadScenarioForMultiUsers {

    private WebDriver driver;
    private final String URL = "https://uat-portal.svkm.ac.in:3005/login";

    @BeforeTest
    public void setup() {
        // This is where we configure the WebDriver options
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }

    public void executeTestForUser(String username, String password) throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();

        // Login steps
        WebElement userName = driver.findElement(By.xpath("//input[@id=\"inp-username\"]"));
        userName.sendKeys(username);

        WebElement pass = driver.findElement(By.xpath("//input[@id=\"inp-password\"]"));
        pass.sendKeys(password);
        Thread.sleep(5000);

        WebElement signIn = driver.findElement(By.xpath("//span[text()=' Sign In ']"));
        signIn.click();

        System.out.println("User " + username + " has been successfully logged in");

        // Navigate to file upload page and select filters
        driver.get("https://uat-portal.svkm.ac.in:3005/template-reviewer/question-paper-offline");

        // Select filters as per your requirements
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@id=\"acadYearFilter\"]")));
        yearSelect.selectByValue("2023");

        Select programSelect = new Select(driver.findElement(By.xpath("//select[@id=\"programFilter\"]")));
        programSelect.selectByValue("");

        Select sessionSelect = new Select(driver.findElement(By.xpath("//select[@id=\"sessionFilter\"]")));
        sessionSelect.selectByValue("");

        Select subjectSelect = new Select(driver.findElement(By.xpath("//select[@id=\"subjectFilter\"]")));
        subjectSelect.selectByVisibleText("");

        Select templateSelect = new Select(driver.findElement(By.xpath("//select[@id=\"templateFilter\"]")));
        templateSelect.selectByVisibleText("");

        // File uploads
        WebElement uploadQP = driver.findElement(By.xpath("//input[@id=\"QPFile\"]"));
        String dir = System.getProperty("user.dir");
        uploadQP.sendKeys(dir + "\\src\\test\\java\\org\\example\\Selenium0511\\toUpload.txt");

        WebElement uploadSynoptic = driver.findElement(By.xpath("//input[@id=\"SynopticAnswerFile\"]"));
        uploadSynoptic.sendKeys("C:\\Users\\Maruf.sherikar.EXT.SVKMGRP\\IdeaProjects\\Selenium\\src\\test\\java\\org\\example\\Selenium0511\\Synoptic");

        System.out.println("Files uploaded successfully for user " + username);
    }

    @Test(groups = "QA")
    @Description("Test Case of File Upload for multiple users")
    public void testConcurrentFileUploads() {

        ExecutorService executor = Executors.newFixedThreadPool(5);


        String[][] users = {
                {"32100837", "pass@123"},
                {"32100838", "pass@123"},
                {"32100839", "pass@123"},
                {"32100840", "pass@123"},
                {"32100841", "pass@123"}
        };

        for (String[] user : users) {
            executor.submit(() -> {
                try {

                    executeTestForUser(user[0], user[1]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        executor.shutdown();
        while (!executor.isTerminated()) {

        }
    }


    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
