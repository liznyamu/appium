package org.examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class iOSFindElements {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);

        // accessibility-id attribute
        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println(myElement.getText());

        // className - type attribute
        myElement = driver.findElements(AppiumBy.className("XCUIElementTypeStaticText")).get(1);
        System.out.println(myElement.getText());

        // name attribute
        myElement = driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println(myElement.getText());

        // id , name and accessibility-id attributes have the same value on iOS
        myElement = driver.findElement(AppiumBy.id("Activity Indicators"));
        System.out.println(myElement.getText());

        // by xpath - NEVER use xPath locator strategy on iOS
        myElement = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println(myElement.getText());

    }
}
