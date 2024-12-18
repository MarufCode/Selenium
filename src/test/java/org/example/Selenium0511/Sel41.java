    package org.example.Selenium0511;

    import io.qameta.allure.Description;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.PageLoadStrategy;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    import java.time.Duration;
    import java.util.List;

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

            WebElement searchElement = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
            searchElement.sendKeys("India" + Keys.ENTER);

            Thread.sleep(5000);

            List<WebElement> list_of_states = driver.findElements(By.cssSelector("div[class='content max-w-maxContainer px-body mx-auto w-full my-[8rem] md:my-[15rem] grid gap-[8rem_4rem] grid-cols-1 lg:grid-cols-[0.75fr_0.25fr]']"));



                    for(WebElement li : list_of_states){
                        String s1 = driver.findElement(with(By.tagName("div")).toRightOf(li)).getText();
                        String s2 = driver.findElement(with(By.tagName("div")).toLeftOf(li)).getText();
                        String s3 = driver.findElement(with(By.tagName("div")).below(li)).getText();
                        String s4 = driver.findElement(with(By.tagName("div")).above(li)).getText();

                        System.out.println(li.getText() + " -->" + s1 + "--> " + s2);
                        System.out.println(li.getText() + " -->" + s3 + "--> " + s4);

                    }


                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
                    element.click();





        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

