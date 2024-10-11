package org.example.SeleniumXpath;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Sel14 {

    @Test(groups= "QA")
    @Description("verify the URL of VWo Page")
    public void login(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");



    }
}
