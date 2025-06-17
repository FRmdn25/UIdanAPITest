package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertTrue;

public class UITestSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // otomatis download driver yg cocok
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I open the Sauce Demo website")
    public void i_open_the_sauce_demo_website() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see the product page")
    public void i_should_see_the_product_page() {
        assertTrue("Inventory page is not displayed", loginPage.isOnInventoryPage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
