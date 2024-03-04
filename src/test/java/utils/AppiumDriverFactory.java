package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        if(driver == null) {
            System.out.println("----------APPIUM_DRIVER_RUNNING----------");
            URL appiumURL = new URL("http://127.0.0.1:4723");
            UiAutomator2Options options = getAndroidOptions();
            driver = new AndroidDriver(appiumURL, options);
        }
        return driver;
    }

    private static UiAutomator2Options getAndroidOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        //options.setDeviceName("MertsEmulator");
        options.setDeviceName("R9TMC02BP8J");
        options.setPlatformName("Android");
        //options.setApp("//Users//user//Desktop//Personal//Appium-Project//src//test//resources//Apps//Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        //options.setAppWaitActivity("com.swaglabsmobileapp.MainActivity");

        options.setAppPackage("com.samsung.android.dialer");
        options.setAppActivity("com.samsung.android.dialer.DialtactsActivity");
        options.setNoReset(true);
        options.getAppPackage();
        options.setUnlockType("pin");
        options.setUnlockKey("123456");
        options.setAutoGrantPermissions(true);
        return options;
    }

    @Before
    public void activateApp() {
        if(driver != null){
            //driver.activateApp("com.swaglabsmobileapp");
            System.out.println("----------APP_ACTIVATED----------");
        }
    }

    @After
    public void terminateApp() {
        if(driver != null) {
            //driver.terminateApp("com.swaglabsmobileapp");
            System.out.println("----------APP_TERMINATED----------");
        }
    }

}
