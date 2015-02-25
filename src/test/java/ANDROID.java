import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mkaleem on 2/25/15.
 */
public class ANDROID {
    public static AppiumDriver wd;

    public static void main(String[] args) throws MalformedURLException, InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Simulator");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/mkaleem/Desktop/appiumPractice2015/src/test/app/hbogo-release-02.25.15T113854-b0390-g04cee93.apk");


        capabilities.setCapability("automationName", "Appium");

        wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
