package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PostLogin {

    public static WebDriver driver;

    public static void Login() throws InterruptedException {

        Properties properties;
        try {
            properties = PropLoader.loadProperties();

            /*Disabling Chrome-functions*/
            Utils.disableChromeFunctions();

            if (properties.getProperty("browser").equalsIgnoreCase(Constants.CHROME)) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (properties.getProperty("browser").equalsIgnoreCase(Constants.Edge)) {

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            } else if (properties.getProperty("browser").equalsIgnoreCase(Constants.FIREFOX)) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println(Utils.formattedDate());

        /* Opens the website */
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Website loaded successfully");


        driver.findElement(By.xpath("//div[@class= 'header_logIn___ctid block']")).click();
        driver.findElement(By.id("email")).sendKeys(properties.getProperty(Constants.EMAIL));
        driver.findElement(By.name("pwd")).sendKeys(properties.getProperty(Constants.PASSWORD));
        driver.findElement(By.xpath("//div[text()= 'Login']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("dobOrpan")).sendKeys(properties.getProperty(Constants.DOB));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //JavascriptExecutor js  = (JavascriptExecutor)driver;
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Authenticate')]")).click();
        System.out.println("Log-in Successful");

        /*WebElement closeButton = null;
        try {
             closeButton = driver.findElement(By.xpath("//div[@class= 'close-icon ng-star-inserted']"));

            if(closeButton != null && closeButton.isDisplayed()){

                closeButton.click();
                System.out.println("close button is clicked");

            } else {
                System.out.println("close button is not clicked");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {

            WebElement closeButton = driver.findElement(By.xpath("//div[@class= 'close-icon ng-star-inserted']"));
            closeButton.click();
            System.out.println("Clicked on close button");

        } catch (org.openqa.selenium.NoSuchElementException e) {

            System.out.println("Close button element not found or not visible.");
        }


    }

}
