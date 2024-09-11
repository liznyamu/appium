package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;


// lock, unlock, isDeviceLocked
// set a Emulator --> Settings --> PIN "1111" to the simulator before running the below
public class AndroidLockAndUnlockDevice {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.ANDROID);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        ((AndroidDriver) driver).lockDevice();
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();

        // to automatically unlock the emulator screen with the PIN - add the below desired capabalitiies
        //      PIN: "unlockType" : pin  and "unlockKey" : 1111
        //      Pattern : "unlockType" : pattern  and "unlockKey" : 125478963 - the number of dot on your pattern
        //      Finger-print ? research

    }
}


