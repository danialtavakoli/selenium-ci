package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


import POs.LoginFormPO;
import POs.LoginSuccessPO;

/**
 * Unit test for simple App.
 */
public class LoginTest extends DriverLifeCycle {
 
    private LoginFormPO login;
    private LoginSuccessPO loginSuccess;

    @Test
    public void testLoginOk() {
        login = new LoginFormPO(driver);
        loginSuccess = login.with("user", "user");
        assertTrue(loginSuccess.successBoxIsPresent());
    }

    @Test
    public void testLoginNotOk() {
        login = new LoginFormPO(driver);
        login.with("user", "error");
        System.out.println(driver.getCurrentUrl());
        // we remain in the login page
        assertTrue(login.invalidBoxisPresent()); 
    }

    @Test
    public void testLoginWithEmptyFields() {
        login = new LoginFormPO(driver);
        login.with("", "");
        System.out.println(driver.getCurrentUrl());
        // we remain in the login page
        assertTrue(login.invalidBoxisPresent());
    }

}
