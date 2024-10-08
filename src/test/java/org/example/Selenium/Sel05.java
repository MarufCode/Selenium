package org.example.Selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Sel05 {

    public static void main(String[] args) {

        EdgeOptions edgeOptions = new EdgeOptions();
        /*
         * 1. headless
         * 2. start max
         * 3. window
         * 4. add extensions
         * 5. 100 of other options - you can use with it
         * */
//        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--window-size=800,600");
        edgeOptions.addArguments("--incognito");
        EdgeDriver driver = new EdgeDriver(edgeOptions); // Dynamic Dispatch -> Runtime Poly
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());


        //driver.manage().window().maximize();

//        driver.quit();
    }

}
