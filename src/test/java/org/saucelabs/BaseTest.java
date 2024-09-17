package org.saucelabs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static AppiumDriver driver;
    protected Properties props;

    protected InputStream inputStream;

    @BeforeTest
    public void beforeTest() throws IOException {

        props = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        props.load(inputStream);
        System.out.println(props.getProperty("appiumURL"));




       /* String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "saucelabs_app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
     */
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
//                .setApp(appUrl)
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity(".MainActivity")
                .setNewCommandTimeout(Duration.ofMinutes(5));

        URL url = new URL(props.getProperty("appiumURL"));

        driver = new AndroidDriver(url, options);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void invalidUserName() {
        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("invalid_user");
        passwordTxtFld.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement errorTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String actualResult = errorTxt.getText();
        Assert.assertEquals(actualResult, "Username and password do not match any user in this service.");
    }

    @Test
    public void invalidPassword() {
        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("standard_user");
        passwordTxtFld.sendKeys("invalid_password");
        loginBtn.click();

        WebElement errorTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String actualResult = errorTxt.getText();
        Assert.assertEquals(actualResult, "Username and password do not match any user in this service.");
    }

    @Test
    public void validLogin() {
        WebElement usernameTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        WebElement passwordTxtFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

        usernameTxtFld.sendKeys("standard_user");
        passwordTxtFld.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement productTitleTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/preceding-sibling::*[1]"));
        String actualResult = productTitleTxt.getText();
        Assert.assertEquals(actualResult, "PRODUCTS");
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
