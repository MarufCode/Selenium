    package org.example.Selenium0511;

    import io.qameta.allure.Description;
    import org.openqa.selenium.*;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.testng.Assert;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    import static org.openqa.selenium.support.locators.RelativeLocator.with;

    public class Sel43 {

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

            try {
                driver.manage().window().maximize();
                driver.get("https://www.google.com/");

                WebElement element = driver.findElement(By.xpath("//textarea[@title=\"Search\"]"));
                driver.navigate().refresh();
                WebElement element1 = driver.findElement(By.xpath("//textarea[@title=\"Search\"]"));
                element1.sendKeys("https://github.com/MarufCode" + Keys.ENTER);
                Thread.sleep(3000);


                // driver.switchTo().frame(1);
                //driver.switchTo().alert().accept();

            }catch (StaleElementReferenceException | NoSuchElementException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

