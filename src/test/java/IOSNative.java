import com.sun.jdi.connect.spi.TransportService;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.MalformedParametersException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkaleem on 2/23/15.
 */

public class IOSNative{

    /**
     * @param args
     */

    public static AppiumDriver wd;

    public static void main(String[] args) throws MalformedURLException, InterruptedException, MalformedURLException {


       // File appDir = new File(System.getProperty("user.dir"), "/apps/");
        //File app = new File(appDir, "TVTruck.Zip");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/mkaleem/Desktop/appiumPractice2015/src/test/app/TVTruck.zip");


        capabilities.setCapability("automationName", "Appium");
       // capabilities.setCapability("udid","c84c5fd8fb6cd5e842473a1888c511b7cf8d9bef");

        wd = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[9]")).click();
        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[50]")).click();
        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]")).click();

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       wd.close();
        wd.closeApp();

    }
}


//TouchAction action = new TouchAction(wd);
//        wd.swipe(200, 30, 50, 55, 400);
//
//        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();
//        wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]")).click();
//
//        Alert alert = wd.switchTo().alert();
//        alert.sendKeys("Hi Alert");
//        System.out.println(alert.getText());
//
//        alert.accept();







