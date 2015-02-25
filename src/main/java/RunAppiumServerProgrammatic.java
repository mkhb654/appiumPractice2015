import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.exec.CommandLine;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkaleem on 2/25/15.
 */
public class RunAppiumServerProgrammatic {
    public static void startAppiumServer() throws Exception {


        CommandLine command = new CommandLine("//usr/local/bin/node");

        command.addArgument("/usr/local/lib/node_modules/appium/bin/appium.js", false);

        command.addArgument("--address", false);

        command.addArgument("127.0.0.1");

        command.addArgument("--port", false);

        command.addArgument("4723");

        command.addArgument("--no-reset", false);

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        DefaultExecutor executor = new DefaultExecutor();

        executor.setExitValue(1);

        executor.execute(command, resultHandler);

        Thread.sleep(7000);

    }


    //Stopping the Appium Server
    public static void stopAppiumServer() throws Exception {

        Runtime.getRuntime().exec("killall node");

    }




    public static void main(String[] args) throws Exception {

        stopAppiumServer();
        startAppiumServer();

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


    }
}
