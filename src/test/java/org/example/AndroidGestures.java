package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.ANDROID);

        // check AppiumDriver instance
        System.out.println("iOSDriver : " + (driver instanceof IOSDriver)
                + "\nandroidDriver : " + (driver instanceof AndroidDriver));

        scrollDown(driver);
//        swipeGestureLeft(driver);
//        swipeGestureUp(driver);
        // dragAnddropGesture(driver);
        // clickGesture(driver);
        // longClickGesture(driver);

    }

    private static void scrollDown(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //scroll by 1 item on the list view - ie screen size
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));

        //scroll by the curretn length of the displayed list view - ie screen size
//        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        // Java
        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
//                "left", 100, "top", 100, "width", 200, "height", 200, // scroll by bounding area
                "direction", "down",
                "percent", 1.0
        ));

        System.out.println("can scroll more: " + canScrollMore);
    }

    private static void swipeGestureLeft(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        By firstImage =
                AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]");
        WebElement element = driver.findElement(firstImage);
        // Java
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    private static void swipeGestureUp(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        // Java
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100, "top", 100, "width", 200, "height", 200,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

    }

    private static void dragAnddropGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 618,
                "endY", 556
        ));
    }

    private static void clickGesture(AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        // Java
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));

    }

    private static void longClickGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        // Java - https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        // set either element -- Best practice
        // or absolute (x-offset, y-offset : device- co-ordinates) -- may be affected by resolution of device
        // or element + relative to the element % co-ordinates (using dimension method/class on Selenium -get width and height)
        //      then find the x and y co-cordinates relative to the width and height  -- elementId
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                // "elementId", ((RemoteWebElement) element).getId(),
                "x", 201,
                "y", 556,
                "duration", 1000
        ));
    }


}
