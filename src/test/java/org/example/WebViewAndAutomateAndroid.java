package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Set;

public class WebViewAndAutomateAndroid {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.ANDROID);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        Thread.sleep(5000);

        // get context::  0: NATIVE_APP ,  1: WEBVIEW_io.appium.android.apis
        Set<String> contextHandles = ((AndroidDriver) driver).getContextHandles();
        for (String contextHandle : contextHandles) {
            System.out.println(contextHandle);
        }

        // switch context option 1: statically ie hardcoded
//        ((AndroidDriver) driver).context("WEBVIEW");

        // switch context option 2: dynamically
        // getContextHandles() order is always 0: NATIVE_APP ,  1: WEBVIEW_io.appium.android.apis
        ((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());

        // perform actions on the WEBVIEW context
        // css_selector: body > h1  and id=i_am_a_textbox
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        driver.findElement(By.id("i_am_a_textbox")).sendKeys("hello");

    }
}
