package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_HomePageLocators {
    public WebElement registerBtnLoc(){
        return Hooks.driver.findElement(By.linkText("Create an Account"));
    }
    public WebElement loginBtnLoc(){
        return Hooks.driver.findElement(By.linkText("Sign In"));
    }
    public WebElement hotSellersLoc(){
        return Hooks.driver.findElement(By.xpath("//h2[normalize-space()='Hot Sellers']"));
    }
    public WebElement hotSellersProductLoc(){
        return Hooks.driver.findElement(By.cssSelector("img[alt='Fusion Backpack']"));
    }
    public WebElement wishlistIconLoc(){
        return Hooks.driver.findElement(By.xpath("//a[@title='Fusion Backpack']/following::a[@class='action towishlist']"));
    }
    public List<WebElement> cardsLoc(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"product-item-info\"]"));
    }
    public WebElement breathEasyTankProductLoc(){
        return Hooks.driver.findElement(By.cssSelector("img[alt='Breathe-Easy Tank']"));
    }
    public WebElement mediumSizeLoc(){
        return Hooks.driver.findElement(By.xpath("//div[@class='swatch-opt-1812']//div[@id='option-label-size-143-item-168']"));
    }
    public WebElement colorLoc(){
        return Hooks.driver.findElement(By.xpath("//div[@class='swatch-opt-1812']//div[@id='option-label-color-93-item-57']"));
    }
    public WebElement addToCartLoc(){
        return Hooks.driver.findElement(By.xpath("//a[@title='Breathe-Easy Tank']/ancestor::li//button[@title='Add to Cart']"));
    }
    public WebElement viewCartWindowLoc(){
        return Hooks.driver.findElement(By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/checkout/cart/\"]"));
    }
    public WebElement cartLoc(){
        return Hooks.driver.findElement(By.cssSelector("span[data-bind=\"i18n: 'View and Edit Cart'\"]"));
    }
}
