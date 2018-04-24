import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LocalDriverFactory {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
    private static String chromeDriverDir = ".\\src\\main\\resources\\drivers\\chromedriver.exe";
    private static String firefoxDriverDir = ".\\src\\main\\resources\\drivers\\geckodriver.exe";
    private static String ieDriverDir = ".\\src\\main\\resources\\drivers\\MicrosoftWebDriver.exe";
    private static int timeoutSec = 30;


    /**
     * It will create a new browser session for testing,
     * We added some driver options in this method:
     * <p>- Browser will be executed in the maximize mode (browser will be maximized)
     * <p>- Added implicitly wait, timeout is for 30 seconds
     * @param browserName name of browser which you want to run it, for parameter you should use: chrome,firefox,edge
     * @return
     *   driver for selected browser
     *
     */
    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName.toLowerCase()) {
            case "chrome":
                if (driver == null) {
                    driver = drivers.get("Chrome");
                    System.setProperty("webdriver.chrome.driver", chromeDriverDir);
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(timeoutSec, TimeUnit.SECONDS);
                }
                break;
            case "firefox":
                if (driver == null) {
                    driver = drivers.get("Firefox");
                    System.setProperty("webdriver.gecko.driver",firefoxDriverDir );
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(timeoutSec,TimeUnit.SECONDS);
                }
                break;
            case "edge":
                if (driver == null) {
                    driver = drivers.get("Edge");
                    System.setProperty("webdriver.edge.driver",ieDriverDir );
                    driver = new EdgeDriver();
                    drivers.put("Edge", driver);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(timeoutSec,TimeUnit.SECONDS);

                }
                break;

        }
        return driver;
    }

    public static void closeAllDrivers(){
        for (String key : drivers.keySet()){
            drivers.get(key).close();
            drivers.get(key).quit();
        }
    }
}
