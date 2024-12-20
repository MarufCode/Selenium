package org.example.Selenium0511;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class MultipleWindowHandle {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        Thread.sleep(2000);

        // Stroe the handle of current (parent) window

        String parentWindow = driver.getWindowHandle();

        // Get all thw window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Iterate through the windows
        for (String windowHandle: allWindows){
            driver.switchTo().window(windowHandle);
            driver.close();
        }

        driver.switchTo().window(parentWindow);
        driver.quit();










    }
}
