package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO {
    private final WebDriver driver;
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By button = By.tagName("button");
    private final By invalid = By.id("invalid");

    public LoginFormPO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginSuccessPO with(String username, String pwd) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(button).click();
        return new LoginSuccessPO(driver);
    }

    public boolean invalidBoxisPresent() {
        return driver.findElement(invalid).isDisplayed();
    }
}
