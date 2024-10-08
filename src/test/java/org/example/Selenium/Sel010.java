package org.example.Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Sel010 {


        // Open app.vwo.com
        // Print the title and get the Current URL
        // VerIfy the Current URL is app.vwo.com



        @Test(groups = "QA")
        @Description("Verify the current URL, title of VWo app")
         public void testVWOLogin(){

            EdgeDriver driver= new EdgeDriver();
            driver.get("https://app.vwo.com");

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            Assert.assertEquals(driver.getTitle(), "Login - VWO");
            Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        }

}
