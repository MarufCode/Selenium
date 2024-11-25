    package org.example.Selenium0511;

    import io.qameta.allure.Description;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.PageLoadStrategy;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.testng.Assert;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    import java.util.List;

    import static org.openqa.selenium.support.locators.RelativeLocator.with;

    public class frameExample {

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
            String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
            driver.get(URL);
            driver.manage().window().maximize();

            Thread.sleep(5000);

            driver.switchTo().frame("result");

            WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
            submit.click();

            WebElement username = driver.findElement(By.id("username"));
            WebElement errElement = driver.findElement(with(By.tagName("small")).below(username));

            String errText = errElement.getText();

            Assert.assertEquals(errText, "Username must be at least 3 characters");
            Thread.sleep(5000);



        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

