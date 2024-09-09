package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionUsingOptions {

    public static void main(String[] args) throws MalformedURLException {
//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
        XCUITestOptions options = new XCUITestOptions().

                // get iOS udid on "xcrun simctl list" or "xcrun simctl list"
                        setUdid("D10B65F0-1D6E-4098-AB99-AAE2B416C443").
                // re-install - use app instead of bundleId
//                        setApp(appUrl);
                // re-use - use bundleId instead of app
                        setBundleId("com.example.apple-samplecode.UICatalog");

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new IOSDriver(url, options);

       /* String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setApp(appUrl)
                // launch without installing app
                .setAppPackage("io.appium.android.apis")
                .setAppActivity(".ApiDemos")
                // wait for next command - for debugging
                .setNewCommandTimeout(Duration.ofMinutes(5));


        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url, options);*/
        System.out.println(driver.getSessionId());

    }
}
