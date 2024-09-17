package org.examples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;
import java.time.Duration;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(Platform platform) throws Exception {

        URL url = new URL("http://0.0.0.0:4723");

        // TODO can use enum
        switch (platform) {
            case ANDROID:
//                String android_appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                        + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                UiAutomator2Options android_options = new UiAutomator2Options()
                        .setUdid("emulator-5554")
//                        .setApp(android_appUrl)
                        .setAppPackage("io.appium.android.apis")
                        .setAppActivity(".ApiDemos")

                        // set desiredCapability: chromedriverExecutable
//                        .setChromedriverExecutable("<path_to_chrome_driver>")

                        // Test: AndroidLockAndUnlockDevice
//                        .setUnlockType("pattern") // set desiredCapability:  unlockType - pin, pattern
//                        .setUnlockKey("12548963") // set desiredCapability:  unlockKey of pin or pattern
//
                        .setAvdLaunchTimeout(Duration.ofMinutes(3))
                        .setNewCommandTimeout(Duration.ofMinutes(5));

                return new AndroidDriver(url, android_options);
            case IOS:
//                String ios_appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                        + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
                XCUITestOptions ios_options = new XCUITestOptions()
                        .setUdid("D10B65F0-1D6E-4098-AB99-AAE2B416C443")
//                        .setApp(ios_appUrl);
                        .setBundleId("com.example.apple-samplecode.UICatalog")
                        .setSimulatorStartupTimeout(Duration.ofMinutes(3))
                        .setNewCommandTimeout(Duration.ofMinutes(5));
                return new IOSDriver(url, ios_options);
            default:
                throw new Exception("invalid platform");
        }

    }
}
