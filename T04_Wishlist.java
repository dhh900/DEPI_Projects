package TestCases;

import Pages.P04_Wishlist;
import Pages.P05_HomePageLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class T04_Wishlist {

    P05_HomePageLocators hotSellers_loc = new P05_HomePageLocators();
    P04_Wishlist wishlist_loc = new P04_Wishlist();

    @When("scroll down to hot sellers section")
    public void scroll_down_to_hot_sellers_section() {
        JavascriptExecutor js = Hooks.driver;
        js.executeScript("scrollBy(200, 1700)");
        Assert.assertTrue(hotSellers_loc.hotSellersLoc().isDisplayed());
    }

    @And("hover on any card and click on add to wishlist button")
    public void hover_on_any_card_and_click_on_add_to_wishlist_button() {
        Hooks.driver.findElement(By.cssSelector("path[d=\"m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z\"]")).click();
        Actions act = new Actions(Hooks.driver);
        act.moveToElement(hotSellers_loc.hotSellersProductLoc()).perform();
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        hotSellers_loc.wishlistIconLoc().click();
    }

    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() {
        System.out.println(Hooks.driver.getCurrentUrl());
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS93aXNobGlzdC9pbmRleC9hZGQv/"));
    }

    @Then("User should be navigated to My Wishlist page with the same product added to Wishlist from")
    public void User_should_be_navigated_to_My_Wishlist_page_with_the_same_product_added_to_Wishlist_from() {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/wishlist/index/index/wishlist_id/"));
        Assert.assertTrue(wishlist_loc.wishlistItemLoc().isDisplayed());
    }
}
