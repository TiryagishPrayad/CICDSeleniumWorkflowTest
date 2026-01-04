package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("user enters valid username and password")
    public void user_enters_credentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPssord!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("user should be logged in successfully")
    public void user_logged_in_successfully() {
        String successMsg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(successMsg.contains("You logged into a secure area"));
        DriverFactory.quitDriver();
    }
}
