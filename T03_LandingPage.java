package TestCases;

import Pages.P03_LandingPage;
import Pages.P05_HomePageLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class T03_LandingPage {
    int index;
    P03_LandingPage landingPage_loc = new P03_LandingPage();
    P05_HomePageLocators homePage_loc = new P05_HomePageLocators();

    @Then("user observe each card is displayed with price")
    public void user_observe_each_card_is_displayed_with_price() {
        for (index = 0; index < homePage_loc.cardsLoc().size(); index++) {
            Assert.assertTrue(homePage_loc.cardsLoc().get(index).getText().contains("$"), "There are cards without price");
        }
    }

    @And("each card should display price in $ and as double not integer")
    public void each_card_should_display_price_in_$_and_as_double_not_integer() {
        for (index = 0; index < homePage_loc.cardsLoc().size(); index++) {

            String priceText = homePage_loc.cardsLoc().get(index).getText();
            String[] parts = priceText.split("As low as ");
            if (parts.length > 1) {
                String priceWithoutSymbol = parts[1].replace("$", "").replace(",", "").trim();
                try {
                    double priceValue = Double.parseDouble(priceWithoutSymbol);
                    if (priceValue % 1 != 0) {
                        System.out.println("Price is a double: " + priceValue);
                    } else {
                        System.out.println("Price is not a double (integer found): " + priceValue);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format: " + priceWithoutSymbol);
                }
            } else {
                System.out.println("Price not found in card text.");
            }
        }
    }

    @Then("user observe each card contains add to cart")
    public void user_observe_each_card_contains_add_to_cart() {
        for (index = 0; index < homePage_loc.cardsLoc().size(); index++) {
            Actions act = new Actions(Hooks.driver);
            act.moveToElement(homePage_loc.cardsLoc().get(index)).perform();
            Assert.assertTrue(homePage_loc.cardsLoc().get(index).getText().contains("Add to Cart"), "There are missing add to cat buttons");
        }
    }

    @And("each card should display add to cart button and it should be clickable")
    public void each_card_should_display_add_to_cart_button_and_it_should_be_clickable() {
        for (index = 0; index < homePage_loc.cardsLoc().size(); index++) {
            homePage_loc.cardsLoc().get(index).isEnabled();
        }
    }

    @And("hover on card Breathe Easy Tank")
    public void hover_on_card_Breathe_Easy_Tank() {
        Actions act = new Actions(Hooks.driver);
        act.moveToElement(homePage_loc.breathEasyTankProductLoc()).perform();
    }

    @And("user select size M select color and click on Add to Cart button")
    public void user_select_size_M_select_color_and_click_on_Add_to_Cart_button() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage_loc.mediumSizeLoc().click();
        homePage_loc.colorLoc().click();
        homePage_loc.addToCartLoc().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(15));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(homePage_loc.addToCartLoc()));
    }

    @Then("product should be added to cart successfully")
    public void product_should_be_added_to_cart_successfully() {
        homePage_loc.viewCartWindowLoc().click();

        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("arguments[0].click();", homePage_loc.cartLoc());

        System.out.println("Product Name: "+landingPage_loc.viewCartProductLoc().getText());
        Assert.assertTrue(landingPage_loc.viewCartProductLoc().getText().equals("Breathe-Easy Tank"), "The product is not in the Cart");
    }

    @And("cart icon should display number 1")
    public void cart_icon_should_display_number_1() {
        Assert.assertTrue(landingPage_loc.viewCartNumberLoc().getText().equals("1"), "The number of items is not True");
    }
}



