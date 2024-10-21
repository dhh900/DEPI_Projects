package TestCases;

import Pages.P02_Login;
import Pages.P05_HomePageLocators;
import Pages.P06_AccountPageLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class T02_Login {
    P02_Login loginPage_loc = new P02_Login();
    P06_AccountPageLocators AccountPage_loc = new P06_AccountPageLocators();
    P05_HomePageLocators HomePage_loc = new P05_HomePageLocators();
    @When("click on sign in button")
    public void click_on_sign_in_button() {
        HomePage_loc.loginBtnLoc().click();
    }
    @And("user enter email and password then click on sign in button")
    public void user_enter_email_and_password_then_click_on_sign_in_button() {
        loginPage_loc.loginEmailLoc().sendKeys("pixegi4516@adambra.com");
        loginPage_loc.loginPasswordLoc().sendKeys("ABcd1234//");
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("scroll(0,2000)");
        loginPage_loc.loginBtnLoc().click();
    }
    @Then("user navigated to homepage")
    public void user_navigated_to_homepage() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/");
    }
    @And("welcome message will be displayed contain first name and last name")
    public void welcome_message_will_be_displayed_contain_first_name_and_last_name() {
//        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//        WebElement welcomeMsg = wait.until(ExpectedConditions.visibilityOf(AccountPage_loc.welcomeUserLoc()));
        System.out.println(AccountPage_loc.welcomeUserLoc().getText());
        Assert.assertTrue(AccountPage_loc.welcomeUserLoc().isDisplayed());
    }
}
