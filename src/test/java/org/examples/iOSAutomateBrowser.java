package org.examples;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class iOSAutomateBrowser {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver(Platform.IOS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // added desired capability - "browserName", "Chrome"
        driver.get("https://tesla.com");

        // TODO resolve the issue with the Select Regions Menu displayed at times before the Main Menu
       /* Check the below element is displayed — then close it
        Region & Language
//*[@id="mega-menu"]/div/dialog/div[1]/h2

        Close Region and Language
//*[@id="mega-menu"]/div/dialog/div[1]/button[1]*/

        // click Menu -> Vehicles -> Model X -> Order Now -> Order with Card
        driver.findElement(By.xpath("//span[normalize-space()='Menu']")).click();
        driver.findElement(By.xpath("//*[@id=\"dx-nav-item--vehicles\"]")).click();
        driver.findElement(By.xpath("//a[@href='/modelx/design']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Order Now']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement orderNowBtn = driver.findElement(By.xpath("//button[normalize-space()='Order with Card']"));
        wait.until(ExpectedConditions.elementToBeClickable(orderNowBtn)).click();

//        driver.findElement(By.xpath("//button[normalize-space()='Order with Card']")).click();

        // Chrome browser uses only WC3 standard supporting css and xpath locator strategies
        WebElement element = driver.findElement(By.xpath("//*[@id=\"FIRST_NAME\"]"));
//        WebElement element = driver.findElement(By.id("FIRST_NAME"));

        // we use scrollIntoView() instead of native scroll or swipe -- as we are interacting with the WebView
        driver.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys("Liz");
    }
}
