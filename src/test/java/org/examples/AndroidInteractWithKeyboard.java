package org.examples;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndroidInteractWithKeyboard {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.ANDROID);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // go to text-fields
        By views = AppiumBy.accessibilityId("Views");
        By textFields = AppiumBy.accessibilityId("TextFields");
        By editText = AppiumBy.id("io.appium.android.apis:id/edit");
        driver.findElement(views).click();
        // swipe up
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        // open the keyboard
        driver.findElement(textFields).click();
        driver.findElement(editText).click();
        Thread.sleep(3000);

        // check if keyboard is displayed
        System.out.println(((AndroidDriver) driver).isKeyboardShown());
        // type on the keyboard
        //      Android https://dpgraham.github.io/docs/en/commands/device/keys/press-keycode/
        //      AndroidKey (native) - https://appium.github.io/java-client/io/appium/java_client/android/nativekey/AndroidKey.html
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.A));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
        // go to homescreen
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
        // open the calendar app
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.CALENDAR));
        // hide key board
        Thread.sleep(3000);
        ((AndroidDriver) driver).hideKeyboard();


    }


}
