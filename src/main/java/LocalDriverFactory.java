import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class LocalDriverFactory {
    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
    private static String chromeDriverDir = ".\\src\\main\\resources\\drivers\\chromedriver.exe";
    private String firefoxDriverDir = ".\\src\\main\\resources\\drivers\\geckodriver.exe";

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "Chrome":
                if (driver == null) {
                    driver = drivers.get("Chrome");
                    System.setProperty("webdriver.chrome.driver", chromeDriverDir);
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
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
