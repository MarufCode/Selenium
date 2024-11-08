    package org.example.Selenium0511;

    import io.qameta.allure.Description;
    import org.openqa.selenium.By;
    import org.openqa.selenium.PageLoadStrategy;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;
    import static org.openqa.selenium.support.locators.RelativeLocator.*;

    public class RelativeLocators {

        EdgeDriver driver;
        @BeforeTest
        public void openBrowser(){
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--guest");
            driver = new EdgeDriver(options);
        }





        @Test(groups = "QA")
        @Description("Test Case Description")
        public void testPositive() throws InterruptedException {
            String URL = "https://awesomeqa.com/practice.html";
            driver.get(URL);
            driver.manage().window().maximize();

        WebElement span = driver.findElement(By.xpath("//span[contains(text(),'Years of Experience')]"));

        driver.findElement(with(By.id("exp-2")).toRightOf(span)).click();

        Thread.sleep(5000);














            Thread.sleep(13000);










        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

