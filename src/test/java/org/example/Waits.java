package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver(Platform.IOS);

        // implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));

        By alertView = AppiumBy.accessibilityId("Alert Views"); // change to "Alert Views 1" - for ElementNotFoundException
        By okayCancel = AppiumBy.accessibilityId("Okay / Cancel");

        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertView)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayCancel)).click();

        // No need for this  -- clicking the element after the above has been achieved
//        driver.findElement(alertView).click();
//        driver.findElement(okayCancel).click();

    }
}
