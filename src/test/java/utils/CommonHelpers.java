package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonHelpers {

    private AndroidDriver driver;

    public CommonHelpers(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitElementExistence(WebElement locatorElement){
        Duration duration= Duration.ofSeconds(10000);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(locatorElement));
        //wait.until(ExpectedConditions.presenceOfElementLocated((AppiumBy.accessibilityId(String.valueOf(locatorElement)))));

    }

    public void dragElement(WebElement locatorElement, Integer endX, Integer endY){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) locatorElement).getId(),
                "endX", endX,
                "endY", endY
        ));
    }


}
