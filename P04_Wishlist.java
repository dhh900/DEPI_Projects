package Pages;

import TestCases.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P04_Wishlist {

    public WebElement wishlistItemLoc(){
        return Hooks.driver.findElement(By.cssSelector("img[alt=\"Fusion Backpack\"]"));
    }











}
