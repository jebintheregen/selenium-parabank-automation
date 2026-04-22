package testcases.parabank;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class RegiaterTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://parabank.parasoft.com");
    }

    @Test
    public void registerNewUserTest() throws IOException {
        driver.findElement(By.linkText("Register")).click();

        String uniqueUser = "testuser" + System.currentTimeMillis();

        driver.findElement(By.id("customer.firstName")).sendKeys("Test");
        driver.findElement(By.id("customer.lastName")).sendKeys("User");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
        driver.findElement(By.id("customer.address.city")).sendKeys("Anytown");
        driver.findElement(By.id("customer.address.state")).sendKeys("CA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("5551234567");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys(uniqueUser);
        driver.findElement(By.id("customer.password")).sendKeys("Test@1234");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

       System.out.println("Successfully registered");
       
       TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\jebin\\eclipse-workspace\\ParaBank-Automation\\ScreenShots\\RegisterTest.png");

		FileUtils.copyFile(source, dest);
    }

    @AfterMethod
    public void tearDown() { driver.quit(); }
}