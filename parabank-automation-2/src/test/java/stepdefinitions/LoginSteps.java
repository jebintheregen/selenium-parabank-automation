package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    WebDriver driver;

    @Given("User launches Chrome browser")
    public void user_launches_browser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @When("User opens ParaBank website")
    public void user_opens_website() {

        driver.get("http://parabank.parasoft.com");

    }

    @When("User enters username and password")
    public void user_enters_credentials() {

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");

    }

    @When("Clicks Login button")
    public void clicks_login_button() {

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {

        System.out.println("Login Successful");

        driver.quit();
    }

}