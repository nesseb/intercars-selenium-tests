package pl.intercars;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverUtils {

    private static WebDriverUtils webDriverUtils;
    private static WebDriver webDriver;
    private final static int TIMEOUT = 10;

    private WebDriverUtils() {
        String browser = System.getProperty("browser");
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                break;
        }
    }
//    git remote set-url origin https://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@github.com/nesseb/
    public static void openPage(String url) {
        webDriver.get(url);
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void setUpDriver() {
        if (webDriverUtils == null) {
            webDriverUtils = new WebDriverUtils();
        }
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
        webDriverUtils = null;
    }
}
