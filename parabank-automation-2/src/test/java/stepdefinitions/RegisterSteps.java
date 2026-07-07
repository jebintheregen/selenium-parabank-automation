package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterSteps {

    WebDriver driver;

    String username = "testuser" + System.currentTimeMillis();

    @Given("User opens Register page")
    public void user_opens_register_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://parabank.parasoft.com");

        driver.findElement(By.linkText("Register")).click();
    }

    @When("User enters registration details")
    public void user_enters_registration_details() {

        driver.findElement(By.id("customer.firstName")).sendKeys("Test");
        driver.findElement(By.id("customer.lastName")).sendKeys("User");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
        driver.findElement(By.id("customer.address.city")).sendKeys("Anytown");
        driver.findElement(By.id("customer.address.state")).sendKeys("CA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("5551234567");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys("Test@1234");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Test@1234");

    }

    @When("User clicks Register button")
    public void user_clicks_register_button() {

        driver.findElement(By.xpath("//input[@value='Register']")).click();

    }

    @Then("Registration should be successful")
    public void registration_should_be_successful() {

        System.out.println("Registration Successful");

        driver.quit();
    }

}