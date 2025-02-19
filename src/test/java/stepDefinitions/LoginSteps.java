package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void openLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/login");
    }

    @When("the user enters valid credentials")
    public void enterCredentials() {
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password123");
    }

    @And("clicks on the login button")
    public void clickLoginButton() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void verifyDashboard() {
        boolean isDashboardDisplayed = driver.findElement(By.id("dashboard")).isDisplayed();
        assert isDashboardDisplayed;
        driver.quit();
    }
}
