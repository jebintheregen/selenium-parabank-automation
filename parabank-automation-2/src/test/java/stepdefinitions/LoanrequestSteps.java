package stepdefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoanrequestSteps {

    WebDriver driver;

    @Given("User has logged into ParaBank")
    public void user_has_logged_into_parabank() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @When("User requests a loan")
    public void user_requests_a_loan() {

        driver.findElement(By.linkText("Request Loan")).click();

        driver.findElement(By.id("amount")).sendKeys("1000");

        driver.findElement(By.id("downPayment")).sendKeys("100");

        new Select(driver.findElement(By.id("fromAccountId"))).selectByIndex(0);

        driver.findElement(By.xpath("//input[@value='Apply Now']")).click();

    }

    @Then("Loan request should be submitted")
    public void loan_request_should_be_submitted() {

        System.out.println("Loan Request Successful");

        driver.quit();

    }

}