package org.example.Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Sel07 {

    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();


    }
}
