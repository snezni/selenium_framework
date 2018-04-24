import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void sampleTest(){
        WebDriver driver = LocalDriverFactory.getBrowser("Chrome");
        driver.get("http://toolsqa.wpengine.com");
    }
}
