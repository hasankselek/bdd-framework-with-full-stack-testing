package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Driver {


    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private static Map<String, Object> prefs = new HashMap<String, Object>();

    private Driver() {

    }

    public static WebDriver getDriver() {
        // if this thread doesn't have a web driver yet - create it and add to pool
        if (driverPool.get() == null) {
            log.info("TRYING TO CREATE DRIVER");
            // this line will tell which browser should open based on the value from
            // properties file

            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigurationReader.get("browser") : browserParamFromEnv;
            switch (browser) {

                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    ChromeOptions opt = new ChromeOptions();
                    // Bu seçenek, Chrome’da “Tarayıcı otomasyon yazılımı tarafından
                    // kontrol ediliyor” bildirimini devre dışı bırakır.
                    opt.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
                    // Bu, Chrome’da yüklü olan tüm eklentileri devre dışı bırakır.
                    opt.addArguments("--disable-extensions");
                    // Bu, Chrome bildirimlerini devre dışı bırakır, böylece testler
                    // sırasında bildirimler testlerin akışını bozmaz.
                    opt.addArguments("disable-notifications");
                    // “Sandbox” Chrome’un güvenlik özelliğidir, ancak belirli CI/CD
                    // sistemlerinde Chrome’un ek izinlere ihtiyaç duyduğu durumlarda bu
                    // ayarı devre dışı bırakmak faydalı olabilir.
                    opt.addArguments("no-sandbox");
                    // Bu seçenek, uzak hata ayıklama sırasında tüm kökenlerden (origin)
                    // gelen isteklere izin verir, özellikle uzaktan WebDriver kullanımı
                    // ya da çapraz kökenli kaynakları test ederken işe yarar.
                    opt.addArguments("--remote-allow-origins=*");
                    opt.addArguments("--disable-search-engine-choice-screen");
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    opt.setExperimentalOption("prefs", prefs);
                    opt.setAcceptInsecureCerts(true);
                    driverPool.set(new ChromeDriver(opt));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;

                case "remote_chrome":
                    try {
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        desiredCapabilities.setCapability("platform", Platform.ANY);
                        driverPool
                                .set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote_firefox":
                    try {
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        desiredCapabilities.setCapability("platform", Platform.ANY);
                        driverPool
                                .set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        try {
            log.info("DRIVER CLOSING");
            driverPool.get().quit();
            driverPool.remove();
        }
        catch (Exception e) {
            log.error("DRIVER CLOSING ERROR = " , e.getCause());
        }
        finally {
            if (driverPool.get() != null) {
                driverPool.get().quit();
                driverPool.remove();
            }
        }

    }

}
