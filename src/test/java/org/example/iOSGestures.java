package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.Map;

public class iOSGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);

        // check AppiumDriver instance
        System.out.println("iOSDriver : " + (driver instanceof IOSDriver)
                + "\nandroidDriver : " + (driver instanceof AndroidDriver));

        swipeGesture(driver);
    }

    private static void swipeGesture(AppiumDriver driver) {
        // Java
        // https://github.com/clarabez/appium-1/blob/master/docs/en/writing-running-appium/ios/ios-xctest-mobile-gestures.md

        // use small screen -- to allow scrolling
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
//        params.put("velocity", 2500);
//        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);
    }
}
