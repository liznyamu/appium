package org.examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSInteractWithKeyboard {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // scroll on the table of elements - to find "Text Field"
        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);

        // click on first editable text field
        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell [1]/XCUIElementTypeTextField")).click();
        Thread.sleep(3000);

        // click keys on the keyboard
        driver.findElement(AppiumBy.accessibilityId("c")).click();
        driver.findElement(AppiumBy.accessibilityId("a")).click();
        driver.findElement(AppiumBy.accessibilityId("d")).click();

        // close the keyboard -- option 1 using keyboard
        System.out.println("On Open keyboard - isKeyboardShown: " + ((IOSDriver) driver).isKeyboardShown());
        driver.findElement(AppiumBy.accessibilityId("Done")).click();
        System.out.println("On Close keyboard - isKeyboardShown: " + ((IOSDriver) driver).isKeyboardShown());

        // close the keyboard -- option 2 using app methods
//        System.out.println("On Open keyboard - isKeyboardShown: " + ((IOSDriver) driver).isKeyboardShown());
//        ((IOSDriver) driver).hideKeyboard();
//        System.out.println("On Close keyboard - isKeyboardShown: " + ((IOSDriver) driver).isKeyboardShown());
    }
}
