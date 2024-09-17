package org.examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class AndroidInteractsWithApps {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.ANDROID);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        Thread.sleep(5000);// simulate some action occurring

        // Terminate app: Terminates an existing app —> ie moves the app the to the “Background process”
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

        // Install app: Tests app upgrades PLUS
        // AndroidInstallApplicationOptions
        //      .withReplaceEnabled() - allows upgrades
        //      .withReplaceDisabled() - does not allow upgrades
        //      .withGrantPermissionsEnabled() - allows all the required permissions for application
//        String android_appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
//                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
//        ((AndroidDriver) driver).installApp(android_appUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());


        // Is app installed? - Checks if an app is already installed
//        System.out.println(((AndroidDriver) driver).isAppInstalled("io.appium.android.apis"));


        // Run app is background  - Sends app to background for specified time and then brings back to foreground
        //      - note the app under test shows a diffent page - after bringing back to foreground
        //              - could be an issue with returning the app state -- it's either the app OR the runAppInBackground()
        //              method --> will need checking with a app requiring login ie return same user session
//        ((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(5));


        // Query app state - Returns current app state
        //      - RUNNING_IN_FOREGROUND, NOT_RUNNING
        System.out.println("Query state :: before terminate "
                + ((AndroidDriver) driver).queryAppState("io.appium.android.apis"));


        // Activate app - Activates an app and moves it to foreground (the app should be already running)
        //      - activate another application eg the "Settings" application
        //          ie to switch the 2 applications on Android
        ((AndroidDriver) driver).terminateApp("io.appium.android.apis");
        System.out.println("Query state :: after terminate "
                + ((AndroidDriver) driver).queryAppState("io.appium.android.apis"));
        Thread.sleep(5000); // simulate some action occuring
        ((AndroidDriver) driver).activateApp("com.android.settings");
        Thread.sleep(5000); // simulate some action occuring
        ((AndroidDriver) driver).activateApp("io.appium.android.apis");
        Thread.sleep(5000); // simulate some action occuring
        System.out.println("Query state :: after activate "
                + ((AndroidDriver) driver).queryAppState("io.appium.android.apis"));

    }


}
