package org.examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSInteractsWithApps {
    public static void main(String[] args) throws Exception {
        IOSDriver driver = (IOSDriver) CreateDriverSession.initializeDriver(Platform.IOS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // some action on the app
        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");
        driver.findElement(activityIndicators).click();

        // Note select which action to perform

        // terminate the iOS app -- move the app the to the “Background process”
//        Thread.sleep(5000);
//        driver.terminateApp("com.example.apple-samplecode.UICatalog");

        // (re-)install the iOS app
//        String ios_appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
//        Thread.sleep(5000);
//        driver.installApp(ios_appUrl);

        // run the app in the background for 5sec --> bring to foreground
        // observe the app state is retained ie app returns to foreground with page with "Activity Indicators" displayed
//        Thread.sleep(5000);
//        driver.runAppInBackground(Duration.ofSeconds(5));


        // activate the App-Under-Test (AUT)
        // steps : de-activate/terminate AUT --> activate settings app (or other app) --> activate AUT
//        Thread.sleep(5000);
//        driver.terminateApp("com.example.apple-samplecode.UICatalog");
//        driver.activateApp("com.apple.Preferences");
//        Thread.sleep(5000);
//        driver.activateApp("com.example.apple-samplecode.UICatalog");

        // query for the app state : RUNNING_IN_FOREGROUND, NOT_RUNNING
        // steps: query for AUT state (foreground) --> terminate AUT --> query for AUT state (background)
//        Thread.sleep(5000);
//        System.out.println("State before terminate: " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));
//        Thread.sleep(5000);
//        driver.terminateApp("com.example.apple-samplecode.UICatalog");
//        Thread.sleep(5000);
//        System.out.println("State after terminate: " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));


        // using appium js methods directly (ie without wrapper functions)
        //      - Advanced Applications Management Commands For iOS With WebDriverAgent/XCTest Backend
        // https://appium.readthedocs.io/en/latest/en/writing-running-appium/ios/ios-xctest-mobile-apps-management/
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.example.apple-samplecode.UICatalog");
        final boolean isInstalled = (Boolean) driver.executeScript("mobile: isAppInstalled", params);
        System.out.println("mobile: isAppInstalled :: " + isInstalled);

    }
}
