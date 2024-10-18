package org.example.SeleniumXpath;

import io.qameta.allure.Description;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sel17 {


    // Atomic test cases
    // Test cases who dont have any dependency and they serve single purpose

    EdgeDriver driver;


    @BeforeTest
    public void openBrowser(){
        driver = new EdgeDriver();
    }



    @Test(groups="QA")
    @Description("Tst case description")
    public void testLogin_Positive(){
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();



    }

    @Test(groups = "QA")
    @Description("Tst case description")
    public void testLogin_Negative(){
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
