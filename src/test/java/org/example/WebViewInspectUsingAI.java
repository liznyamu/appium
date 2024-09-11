package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class WebViewInspectUsingAI {

    public static void main(String[] args) throws Exception {
        // change platform
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // -> Scroll code for Android starts here
        /*WebElement andElement = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) andElement).getId(),
                "direction", "up",
                "percent", 0.75
        ));*/
        //-> Scroll code for Android ends here

        // -> Scroll code for iOS starts here
        WebElement iOSElement = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((RemoteWebElement) iOSElement).getId());
        driver.executeScript("mobile: swipe", params);
        // -> Scroll code for iOS ends here


        // Android
        /*driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"This page is a Second Selenium sandbox\"]"));
        System.out.println(element.getText());*/

        // iOS
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        // getText() on iOS returns - value (below returns 1) - instead get attribute label
        WebElement element = driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView ."));
        System.out.println("getText() - returns: " + element.getText());
        System.out.println("label attribute - returns: " + element.getAttribute("label"));


    }
}
