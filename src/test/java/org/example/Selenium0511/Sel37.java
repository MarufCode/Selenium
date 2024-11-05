    package org.example.Selenium0511;

    import io.qameta.allure.Description;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.PageLoadStrategy;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.openqa.selenium.interactions.Actions;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    public class Sel37 {

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
            String URL = "https://the-internet.herokuapp.com/drag_and_drop";
            driver.get(URL);
            driver.manage().window().maximize();

            Actions actions = new Actions(driver);

            WebElement from = driver.findElement(By.id("column-a"));
            WebElement to = driver.findElement(By.id("column-b"));

//            actions.dragAndDrop(from,to).perform();

            actions.clickAndHold(from).moveToElement(to).release(to).build().perform();


            driver.get("https://awesomeqa.com/selenium/upload.html");

            WebElement upload = driver.findElement(By.id("fileToUpload"));
            String dir = System.getProperty("user.dir");
            System.out.println(dir);
            upload.sendKeys(dir+"\\src\\test\\java\\org\\example\\Selenium0511\\toUpload.txt");


            WebElement submit = driver.findElement(By.name("submit"));
            submit.click();















            Thread.sleep(13000);










        }

            @AfterTest
            public void closeBrowser(){
                driver.quit();


            }
        }

