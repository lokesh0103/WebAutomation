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

        driver.findElement(By.xpath("data:image/png;base64,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")).click();



    }

}
