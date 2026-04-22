package testcases.parabank;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class FundTransferTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void transferFundsTest() throws InterruptedException, IOException {
        driver.get("http://parabank.parasoft.com");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Transfer Funds")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("amount")).sendKeys("100");
        // Select accounts from dropdowns
        WebElement fromAccount = driver.findElement(By.id("fromAccountId"));
        Select fromSelect = new Select(fromAccount);
        fromSelect.selectByIndex(1);

        WebElement toAccount = driver.findElement(By.id("toAccountId"));
        Select toSelect = new Select(toAccount);
        toSelect.selectByIndex(1);

        driver.findElement(By.xpath("//input[@value='Transfer']")).click();
        Thread.sleep(2000);

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Transfer Complete"),
          "Transfer did not complete");
        System.out.println("Fund Transfer test PASSED");
        
        TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\jebin\\eclipse-workspace\\ParaBank-Automation\\ScreenShots\\FundTransfer.png");

		FileUtils.copyFile(source, dest);
    }

    @AfterMethod
    public void tearDown() { 
    	driver.quit(); 
    	}
}