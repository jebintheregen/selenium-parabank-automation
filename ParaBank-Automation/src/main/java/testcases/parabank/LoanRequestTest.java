package testcases.parabank;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class LoanRequestTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void requestLoanTest() throws InterruptedException, IOException {
        driver.get("http://parabank.parasoft.com");
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Request Loan")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("downPayment")).sendKeys("100");

        WebElement fromAccount = driver.findElement(By.id("fromAccountId"));
        new Select(fromAccount).selectByIndex(0);

        driver.findElement(By.xpath("//input[@value='Apply Now']")).click();
        Thread.sleep(2000);

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(
          bodyText.contains("Approved") || bodyText.contains("loan"),"Loan page response not found");
        System.out.println("Loan Request test PASSED");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\jebin\\eclipse-workspace\\ParaBank-Automation\\ScreenShots\\LoanRequest.png");

		FileUtils.copyFile(source, dest);
    }

    @AfterMethod
    public void tearDown() { 
    	driver.quit(); 
    	}
}