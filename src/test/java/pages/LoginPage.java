package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By inventoryContainer = By.id("inventory_container");

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isOnInventoryPage() {
        return driver.findElement(inventoryContainer).isDisplayed();
    }
}
