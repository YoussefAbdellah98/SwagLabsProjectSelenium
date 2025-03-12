package com.SwagLabs.Utilites.Drivers;

import com.SwagLabs.Utilites.DataDriven.PropertiesFile;
import com.SwagLabs.Utilites.Helpers.LogsUtils;
import com.SwagLabs.Utilites.ScreenShots;
import io.qameta.allure.Step;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;

import java.util.Map;

public class SettingUpWebDriver{


    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                options.addArguments("--remote-allow-origins=*");

                Map<String, Object> prefs = Map.of(
                        "profile.default_content_settings.notifications", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false
                );
                options.setExperimentalOption("prefs", prefs);
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                if (PropertiesFile.getConfigValue("browser", "headlessMode")
                        .equalsIgnoreCase("true")) {
                    options.addArguments("--headless");
                }

                return new ChromeDriver(options);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--disable-infobars");
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                firefoxOptions.setAcceptInsecureCerts(true);

                if (PropertiesFile.getConfigValue("browser", "headlessMode")
                        .equalsIgnoreCase("true")) {
                    firefoxOptions.addArguments("--headless");
                }

                return new FirefoxDriver(firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-infobars");
                edgeOptions.addArguments("--remote-allow-origins=*");

                Map<String, Object> edgePrefs = Map.of(
                        "profile.default_content_settings.notifications", 2,
                        "credentials_enable_service", false,
                        "profile.password_manager_enabled", false,
                        "autofill.profile_enabled", false
                );
                edgeOptions.setExperimentalOption("prefs", edgePrefs);
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                if (PropertiesFile.getConfigValue("browser", "headlessMode")
                        .equalsIgnoreCase("true")) {
                    edgeOptions.addArguments("--headless");
                }

                return new EdgeDriver(edgeOptions);
        }

        throw new IllegalArgumentException("Invalid browser name: " + browserName);
    }


    @Step("Driver Running On")
    public static WebDriver setUpDriver(String browserName) {
        WebDriver driver = getBrowser(browserName);
        LogsUtils.info("Driver Running On: ",browserName);
        setDriver(driver);
        return driver;
    }


    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if(driver==null){
            LogsUtils.error("Driver Is Null");
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }



    @Step("Closing The Browser")
    public static void closeDriver(ITestResult result) {
        LogsUtils.info("Closing The Browser");
        if (!result.isSuccess()) {

            String testClassName = result.getTestClass().getName();
            String testMethodName = result.getMethod().getMethodName();
            ScreenShots.captureScreenShot(getDriver(),  testClassName, testMethodName);
        }

        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
