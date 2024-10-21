package TestCases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Hooks {
    public static ChromeDriver driver;

    @Before
    public void setUp() {
        ChromeOptions opt = new ChromeOptions();
        File extensionFile = new File("./TestExtensions/uBlock Origin.crx");
        opt.addExtensions(extensionFile);
        driver = new ChromeDriver(opt);
//------------------------------------------------------------------------------------
//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("--disable-popup-blocking");
//        opt.addArguments("--disable-notifications");
//        driver = new ChromeDriver(opt);
//------------------------------------------------------------------------------------
//        driver = new ChromeDriver();
//        driver.get("chrome://settings/advanced");
//        driver.findElement(By.cssSelector("a[data-selection-index=\"2\"]")).click();
//        driver.findElement(By.cssSelector("div[aria-hidden=\"true\"]")).click();
//        driver.findElement(By.cssSelector("div[class=\"disc\"]")).click();
    }

    @After
    public void close() {
        driver.quit();
    }
}
