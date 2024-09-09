package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class iOSPredicateString {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);

        /*
        Refer to ::
        https://appium.github.io/appium-xcuitest-driver/7.26/reference/ios-predicate/
        https://github.com/facebookarchive/WebDriverAgent/wiki/Predicate-Queries-Construction-Rules#
        https://developer.apple.com/library/archive/documentation/Cocoa/Conceptual/Predicates/Articles/pSyntax.html
        */

        // iOS Predicate String attribute
        WebElement myElement = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name == \"Activity Indicators\""));
        System.out.println(myElement.getText());


        myElement = driver.findElement(AppiumBy.iOSNsPredicateString("name CONTAINS[c] 'Activity Indicators'"));
        System.out.println(myElement.getText());


        // by xpath - NEVER use xPath locator strategy on iOS
        myElement = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println(myElement.getText());

    }
}
