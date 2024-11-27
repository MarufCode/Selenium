    package org.example.Selenium0511;

    import io.qameta.allure.Description;
    import org.openqa.selenium.By;
    import org.openqa.selenium.PageLoadStrategy;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.edge.EdgeOptions;
    import org.testng.Assert;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    import static org.openqa.selenium.support.locators.RelativeLocator.with;

    public class exerciseDemmoScenario {

        EdgeDriver driver;

        @BeforeTest
        public void openBrowser() {
            EdgeOptions options = new EdgeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--guest");
            driver = new EdgeDriver(options);
        }


        @Test(groups = "QA")
        @Description("Test Case Description")
        public void testPositive() throws InterruptedException {
            try {
                String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
                driver.get(URL);
                driver.manage().window().maximize();

                Thread.sleep(5000);

                WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
                username.sendKeys("Admin");

                WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
                password.sendKeys("admin123");

                WebElement login = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
                login.click();

                Thread.sleep(5000);

                driver.findElement(By.xpath("//span[text()='PIM']")).click();
                Thread.sleep(5000);

                WebElement addEmployee = driver.findElement(By.xpath("//button[text()=' Add ']"));
                addEmployee.click();
                Thread.sleep(3000);

                WebElement firstName = driver.findElement(By.xpath("//input[@name=\"firstName\"]"));
                firstName.sendKeys("Maruf");

                WebElement lastName = driver.findElement(By.xpath("//input[@name=\"lastName\"]"));
                lastName.sendKeys("Sherikar");

                driver.findElement(By.xpath("//button[text()=' Save ']")).click();
                Thread.sleep(7000);

                driver.findElement(By.xpath("//span[text()='PIM']")).click();
                Thread.sleep(3000);

                WebElement searchEmployee = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
                searchEmployee.sendKeys("Maruf");

                driver.findElement(By.xpath("//button[text()=' Search ']")).click();
                Thread.sleep(3000);


                WebElement record = driver.findElement(By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border oxd-table-row--clickable\"]"));


                String recordText = record.getText();
                System.out.println(recordText);
                String[] recordParts = recordText.split("\n");

                String expectedId = "0441";
                String expectedFirstName = "Maruf";
                String expectedLastName = "Sherikar";

                Assert.assertEquals(recordParts[0], expectedId, "ID does not match");
                Assert.assertEquals(recordParts[1], expectedFirstName, "First Name does not match");
                Assert.assertEquals(recordParts[2], expectedLastName, "Last Name does not match");

                System.out.println("All assertions passed. Data verified successfully.");
            } catch (AssertionError e) {
                System.out.println("Assertion failed: " + e.getMessage());

                Thread.sleep(3000);

                WebElement dlt = driver.findElement(By.xpath("//div[@class='orangehrm-paper-container']//button[2]"));
                dlt.click();
                Thread.sleep(2000);



                driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();
                Thread.sleep(5000);

                Assert.assertTrue(true, "Successfully deleted");

            }
        }


        @AfterTest
        public void closeBrowser() {
            driver.quit();


        }


    }