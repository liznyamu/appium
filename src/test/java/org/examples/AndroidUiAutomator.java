package org.examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.ANDROID);

        // Refer to : https://developer.android.com/training/testing/other-components/ui-automator
        WebElement myElement = driver.findElement(AppiumBy.androidUIAutomator("text(\"Accessibility\")"));
        System.out.println(myElement.getText());

        // by className
        myElement = driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.TextView\")")).get(2);
        System.out.println(myElement.getText());

        // by content-desc or accessibility-id
        myElement = driver.findElement(AppiumBy.androidUIAutomator("description(\"Accessibility\")"));
        System.out.println(myElement.getText());

        // by resource-id ie id
        myElement = driver.findElements(AppiumBy.androidUIAutomator("resourceId(\"android:id/text1\")")).get(1);
        System.out.println(myElement.getText());
    }
}
