package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSuccessPO {
    private final WebDriver driver;
    private final By success = By.id("success");

    public LoginSuccessPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean successBoxIsPresent() {
        return driver.findElement(success).isDisplayed();
    }
}
