package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Register {
    public WebElement firstnameLoc() {
        return Hooks.driver.findElement(By.id("firstname"));
    }
    public WebElement lastnameLoc() {
        return Hooks.driver.findElement(By.id("lastname"));
    }
    public WebElement emailLoc() {
        return Hooks.driver.findElement(By.id("email_address"));
    }
    public WebElement passwordLoc() {
        return Hooks.driver.findElement(By.id("password"));
    }
    public WebElement passwordConfirmLoc() {
        return Hooks.driver.findElement(By.id("password-confirmation"));
    }
    public WebElement createBtnLoc() {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"action submit primary\"]"));
    }
    public WebElement warningMsgLoc() {
        return Hooks.driver.findElement(By.xpath("//div[@id='password-confirmation-error']\n"));
    }
    public WebElement existAccountMsgLoc() {
        return Hooks.driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
    }
}