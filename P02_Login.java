package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Login {
    public WebElement loginEmailLoc() {
        return Hooks.driver.findElement(By.id("email"));
    }
    public WebElement loginPasswordLoc() {
        return Hooks.driver.findElement(By.id("pass"));
    }
    public WebElement loginBtnLoc() {
        return Hooks.driver.findElement(By.id("send2"));
    }
}
