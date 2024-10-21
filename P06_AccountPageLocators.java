package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P06_AccountPageLocators {
    public WebElement contactInfoLoc(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"box-content\"]"));
    }
    public WebElement welcomeUserLoc(){
        return Hooks.driver.findElement(By.cssSelector("div[class='panel header'] span[class='logged-in']"));
    }
}
