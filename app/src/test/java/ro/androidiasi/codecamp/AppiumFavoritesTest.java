package ro.androidiasi.codecamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class AppiumFavoritesTest {

    private AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appPath = new File(classpathRoot, "/build/outputs/apk/app-iasi-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", appPath.getAbsolutePath());
        capabilities.setCapability("appPackage", BuildConfig.APPLICATION_ID);
        capabilities.setCapability("appActivity", "ro.androidiasi.codecamp.main.MainActivity_");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testAddFavorite() throws Exception{

        driver.findElement(withExactText("Sessions"))
                .click();
        pullToRefresh();
        driver.findElement(containsText("Registration"))
                .click();
        driver.findElement(By.id("fab"))
                .click();

        driver.pressKeyCode(AndroidKeyCode.BACK);

        driver.findElement(withExactText("Favorites"))
                .click();
        pullToRefresh();

        assertTrue(
                driver.findElement(containsText("Registration"))
                .isDisplayed());
    }

    @Test
    public void testNoFavorites() throws Exception {
        driver.findElement(withExactText("Favorites"))
                .click();
        pullToRefresh();

        assertTrue(
                driver.findElement(containsText("There are no Sessions"))
                        .isDisplayed());
    }

    private void pullToRefresh() throws Exception{
        Thread.sleep(400); //It sometimes cancels clicks
        driver.swipe(300, 300, 300, 600, 1500);
    }

    private By withExactText(String text){
        return By.xpath("//*[@text='"+text+"']");
    }

    private By containsText(String text){
        return By.xpath("//*[contains(@text,'"+text+"')]");
    }
}