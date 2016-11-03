package ro.androidiasi.codecamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class AppiumFavoritesTest {

    private AndroidDriver<AndroidElement> mDriver;

    @Before
    public void setUp() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appPath = new File(classpathRoot, "/build/outputs/apk/app-iasi-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", appPath.getAbsolutePath());
        capabilities.setCapability("appPackage", BuildConfig.APPLICATION_ID);
        capabilities.setCapability("appActivity", "ro.androidiasi.codecamp.main.MainActivity_");
        mDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        mDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        mDriver.quit();
    }

    @Test
    public void testAddFavorite() throws Exception {

        mDriver.findElement(withExactText("Sessions"))
                .click();
        pullToRefresh();
        mDriver.findElement(containsText("Registration"))
                .click();
        mDriver.findElement(By.id("fab"))
                .click();

        mDriver.pressKeyCode(AndroidKeyCode.BACK);

        mDriver.findElement(withExactText("Favorites"))
                .click();
        pullToRefresh();

        assertTrue(
                mDriver.findElement(containsText("Registration"))
                .isDisplayed());
    }

    @Test
    public void testNoFavorites() throws Exception {
        mDriver.findElement(withExactText("Favorites"))
                .click();
        pullToRefresh();

        assertTrue(
                mDriver.findElement(containsText("There are no Sessions"))
                        .isDisplayed());
    }

    private void pullToRefresh() throws Exception {
        Thread.sleep(400); //It sometimes cancels clicks
        mDriver.swipe(300, 300, 300, 600, 1500);
    }

    private By withExactText(String text) {
        return By.xpath("//*[@text='" + text + "']");
    }

    private By containsText(String text) {
        return By.xpath("//*[contains(@text,'" + text + "')]");
    }
}