package Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utils {

    public static String formattedDate(){

        Date currentdate = new Date();
        return currentdate.toString().replace(" ", "-").replace(":", "-");
    }

    public static void disableChromeFunctions(){

        //Disabling chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-save-password"); // Disable password saving
        options.addArguments("--disable-infobars"); // Disable infobars
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-popup-blocking"); // Disable pop-up blocking
        options.addArguments("--disable-default-apps"); // Disable default apps
        options.addArguments("--disable-background-networking"); // Disable background networking
        options.addArguments("--disable-background-timer-throttling"); // Disable background timer throttling
        options.addArguments("--disable-backgrounding-occluded-windows"); // Disable backgrounding of occluded windows
        options.addArguments("--disable-breakpad"); // Disable crash reporting
        options.addArguments("--disable-component-extensions-with-background-pages"); // Disable extensions with background pages
        options.addArguments("--disable-default-apps"); // Disable default apps
        options.addArguments("--disable-dev-shm-usage"); // Disable /dev/shm usage
        options.addArguments("--disable-features=site-per-process"); // Disable site isolation
        options.addArguments("--disable-ipc-flooding-protection"); // Disable IPC flooding protection
        options.addArguments("--disable-renderer-backgrounding"); // Disable renderer backgrounding
        options.addArguments("--disable-sync"); // Disable syncing
        options.addArguments("--force-fieldtrials=*BackgroundTracing/default/");
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Disable the sandbox
        options.addArguments("--mute-audio"); // Mute audio


    }

    public static String screenshot() throws IOException {

        //Taking screenshot
        File screenshotFile = ((TakesScreenshot) PostLogin.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".\\screenshot\sscreenshot.png"));
        System.out.println("Screenshot taken");
        return null;

    }

}
