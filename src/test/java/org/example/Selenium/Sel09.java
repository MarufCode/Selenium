package org.example.Selenium;

import org.openqa.selenium.edge.EdgeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Sel09 {

    public static void main(String[] args) throws MalformedURLException {


        EdgeDriver driver = new EdgeDriver();
        driver.get("https://bing.com");

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to(new URL("x"));
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();









    }
}
