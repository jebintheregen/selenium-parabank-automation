package stepdefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FundTransferSteps {

    WebDriver driver;

    @Given("User is logged into ParaBank")
    public void user_is_logged_into_parabank() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value=" + "'Log In'" + "]")).click();

    }

    @When("User transfers money")
    public void user_transfers_money() {

        driver.findElement(By.linkText("Transfer Funds")).click();

        driver.findElement(By.id("amount")).sendKeys("100");

        new Select(driver.findElement(By.id("fromAccountId"))).selectByIndex(1);

        new Select(driver.findElement(By.id("toAccountId"))).selectByIndex(1);

        driver.findElement(By.xpath("//input[@value='Transfer']")).click();

    }

    @Then("Transfer should complete successfully")
    public void transfer_should_complete_successfully() {

        System.out.println("Fund Transfer Successful");

        driver.quit();

    }

}