package org.example.Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Sel06 {

    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("524.5465.466: 1050");
        edgeOptions.setCapability("proxy", proxy);


        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();


        // NONE -> 0.5 ms
        // EAGER - 1
        // NORMAL  - 5-7 Seconds


    }
}
