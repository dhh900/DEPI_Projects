package TestCases;

import Pages.P01_Register;
import Pages.P05_HomePageLocators;
import Pages.P06_AccountPageLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class T01_Register {
    P01_Register registration_loc = new P01_Register();
    P05_HomePageLocators homePage_loc = new P05_HomePageLocators();
    P06_AccountPageLocators accountPage_loc = new P06_AccountPageLocators();
    ReadExcel reader = new ReadExcel();


    @Given("open LUMA website URL")
    public void open_LUMA_website_URL() {
        Hooks.driver.navigate().to("https://magento.softwaretestingboard.com/");
        Hooks.driver.manage().window().maximize();
    }

    @When("click on create an account button")
    public void click_on_create_an_account_button() {
        homePage_loc.registerBtnLoc().click();
    }

    @And("user enter required data but leave confirm password empty")
    public void user_enter_required_data_but_leave_confirm_password_empty() throws IOException, InvalidFormatException {
        String[][] LUMA_credentials = reader.readData();
        String username = LUMA_credentials[0][0];
        String lastname = LUMA_credentials[0][1];
        String email = LUMA_credentials[0][2];
        String password = LUMA_credentials[0][3];
        String passwordConfirm = LUMA_credentials[0][4];
        registration_loc.firstnameLoc().sendKeys(username);
        registration_loc.lastnameLoc().sendKeys(lastname);
        registration_loc.emailLoc().sendKeys(email);
        registration_loc.passwordLoc().sendKeys(password);
        registration_loc.passwordConfirmLoc().sendKeys(passwordConfirm);
    }

    @And("click on create button")
    public void click_on_create_button() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("scroll(0,2000)");
        registration_loc.createBtnLoc().click();
    }

    @Then("user navigated to the same page")
    public void user_navigated_to_the_same_page() {
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/create/", "Not Navigated Right");
    }

    @And("warning message will be displayed under mandatory fields")
    public void warning_message_will_be_displayed_under_mandatory_fields() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(registration_loc.warningMsgLoc().getText());
        Assert.assertEquals(registration_loc.warningMsgLoc().getText(), "This is a required field.", "Warning Message Not display");
    }

    @And("user enter required data but confirm password does not match password")
    public void user_enter_required_data_but_confirm_password_does_not_match_password() throws IOException, InvalidFormatException {
        String[][] LUMA_credentials = reader.readData();
        WebElement[] locators = {
                registration_loc.firstnameLoc(),
                registration_loc.lastnameLoc(),
                registration_loc.emailLoc(),
                registration_loc.passwordLoc(),
                registration_loc.passwordConfirmLoc()
        };
        for (int i = 0; i < LUMA_credentials[0].length; i++) {
            locators[i].sendKeys(LUMA_credentials[1][i]);
        }
    }

    @And("warning message will be displayed under confirm password field")
    public void warning_message_will_be_displayed_under_confirm_password_field() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println(registration_loc.warningMsgLoc().getText());
        Assert.assertEquals(registration_loc.warningMsgLoc().getText(), "Please enter the same value again.", "Warning Message Not display");
    }

    @And("fill all mandatory fields with valid input")
    public void fill_all_mandatory_fields_with_valid_input() throws IOException, InvalidFormatException {
        String[][] LUMA_credentials = reader.readData();
        WebElement[] locators = {
                registration_loc.firstnameLoc(),
                registration_loc.lastnameLoc(),
                registration_loc.emailLoc(),
                registration_loc.passwordLoc(),
                registration_loc.passwordConfirmLoc()
        };
        for (int i = 0; i < LUMA_credentials[0].length; i++) {
            locators[i].sendKeys(LUMA_credentials[2][i]);
        }

    }

    @Then("user navigated to account homepage")
    public void user_navigated_to_account_homepage() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/", "Not HomePage");
        System.out.println(registration_loc.existAccountMsgLoc().getText());
        soft.assertTrue(registration_loc.existAccountMsgLoc().isDisplayed());
        soft.assertAll();
    }

    @And("contact information should be the same as user input during registration")
    public void contact_information_should_be_the_same_as_user_input_during_registration() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(accountPage_loc.contactInfoLoc().getText().contains("Ahmed"));
        Assert.assertTrue(accountPage_loc.contactInfoLoc().getText().contains("Mohamed"));
        Assert.assertTrue(accountPage_loc.contactInfoLoc().getText().contains("pixegi4516@adambra.com"));
    }
}
