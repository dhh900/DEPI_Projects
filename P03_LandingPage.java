package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P03_LandingPage {
    public WebElement viewCartProductLoc() {
        return Hooks.driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Breathe-Easy Tank']"));
    }

    public WebElement viewCartNumberLoc() {
        return Hooks.driver.findElement(By.cssSelector(".minicart-wrapper .counter-number"));
    }

}
