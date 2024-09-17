package org.examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Set;

public class WebViewiOSReal {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver(Platform.IOS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Or connect using a social account.")).click();
        driver.findElement(AppiumBy.accessibilityId("Google")).click();
        // Thread.sleep(5000);

        Set<String> contextHandles = ((IOSDriver) driver).getContextHandles();
        for (Object contextHandle : contextHandles) {
            System.out.println(contextHandle.toString());
        }
        ((IOSDriver) driver).context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("#headingText > span")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"headingText\"]/span")).getText());

        ((IOSDriver) driver).context("NATIVE_APP");
        driver.quit();
    }
}
