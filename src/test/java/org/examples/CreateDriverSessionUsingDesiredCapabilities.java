package org.examples;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingDesiredCapabilities {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 13 Pro Max");
        caps.setCapability("appium:automationName", "XCUITest");

        // get iOS udid on "xcrun simctl list" or "xcrun simctl list"
        caps.setCapability("appium:udid", "D10B65F0-1D6E-4098-AB99-AAE2B416C443");


        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "examples_app/UIKitCatalog-iphonesimulator.app";
        caps.setCapability("appium:app", appUrl);

        URL url = new URL("http://0.0.0.0:4723");



/*         AppiumDriver driver = new IOSDriver(url, caps);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Medium_Phone_API_35");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:udid", "emulator-5554");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        caps.setCapability("appium:app", appUrl);

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url, caps);*/
    }
}