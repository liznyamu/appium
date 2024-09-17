package org.examples;

// How to fetch element attributes? and states? -- to perform validations
//      - note the attributes differ at times on iOS and Appium

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttributes {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);

        By accessibility = AppiumBy.accessibilityId("Activity Indicators");

        // getText  and getAttributes - that can be used to validate tests
        System.out.println("label:" + driver.findElement(accessibility).getText());
        System.out.println("label:" + driver.findElement(accessibility).getAttribute("label"));
        System.out.println("value:" + driver.findElement(accessibility).getAttribute("value"));
        System.out.println("enabled:" + driver.findElement(accessibility).getAttribute("enabled"));
        System.out.println("selected:" + driver.findElement(accessibility).getAttribute("selected"));
        System.out.println("visible:" + driver.findElement(accessibility).getAttribute("visible"));

        // check the state
        System.out.println("selected:" + driver.findElement(accessibility).isSelected());
        System.out.println("enabled:" + driver.findElement(accessibility).isEnabled());
        System.out.println("displayed:" + driver.findElement(accessibility).isDisplayed());
    }
}
