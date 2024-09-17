package org.examples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;
import java.time.Duration;

public class CreateBrowserSession {

    public static AppiumDriver initializeDriver(Platform platform) throws Exception {

        URL url = new URL("http://0.0.0.0:4723");

        // TODO can use enum
        switch (platform) {
            case ANDROID:
                UiAutomator2Options android_options = new UiAutomator2Options()
                        .setUdid("emulator-5554")
                        .setAppActivity(".ApiDemos")

                        // create chrome driver session
                        .withBrowserName("Chrome")
                        // download and set the compatible chromedriver version for the device's chrome browser version
//                        .setChromedriverExecutable("<path_to_chromedriver/chromedriver>") // single chromedriver
//                        .setChromedriverExecutableDir("<path_to_chromedrivers>") // multiple chromedriver

                        .setAvdLaunchTimeout(Duration.ofMinutes(3))
                        .setNewCommandTimeout(Duration.ofMinutes(5));

                return new AndroidDriver(url, android_options);
            case IOS:
                XCUITestOptions ios_options = new XCUITestOptions()
                        .setUdid("D10B65F0-1D6E-4098-AB99-AAE2B416C443")
                        .withBrowserName("Safari")
                        .setSimulatorStartupTimeout(Duration.ofMinutes(3))
                        .setNewCommandTimeout(Duration.ofMinutes(5));
                return new IOSDriver(url, ios_options);
            default:
                throw new Exception("invalid platform");
        }

    }
}
