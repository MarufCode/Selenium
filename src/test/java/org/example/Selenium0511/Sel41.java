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

    import static org.openqa.selenium.support.locators.RelativeLocator.with;

    public class Sel41 {

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
            String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
            driver.get(URL);
            driver.manage().window().maximize();
















            Thread.sleep(13000);










        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

