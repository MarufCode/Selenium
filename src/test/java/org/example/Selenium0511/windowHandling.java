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

    import java.util.Set;

    public class windowHandling {

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
            String URL = "https://the-internet.herokuapp.com/windows";
            driver.get(URL);
            driver.manage().window().maximize();


            String mainWindowHandle = driver.getWindowHandle();
            System.out.println("Before Click" + mainWindowHandle);
            WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
            link.click();

            Set<String> windowHandles = driver.getWindowHandles();

            for (String handle: windowHandles){
                driver.switchTo().window(handle);

                System.out.println(handle);
                if (driver.getPageSource().contains("New Window")){
                    System.out.println("Test Case Passed");
                }
            }

            Thread.sleep(3000);


            driver.switchTo().window(mainWindowHandle);




            String mainWindow1 = driver.getWindowHandle();
            System.out.println("Before Click" + mainWindow1);

            WebElement lin = driver.findElement(By.xpath(""));
            lin.click();

            Set<String> childWindow = driver.getWindowHandles();
            for (String handle: childWindow){
                driver.switchTo().window(handle);
                if (driver.getPageSource().contains("new Window")){
                    System.out.println("Test CAse is Passed");
                }
            }

            driver.switchTo().window(mainWindow1);









            Thread.sleep(3000);










        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

