package com.HonestFoods.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.rmi.UnexpectedException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public WebDriverWait wait;
    public static Properties prop;

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public WebDriver initialize_driver()
            throws MalformedURLException, UnexpectedException {

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        driver.manage().deleteAllCookies();
        driver.manage().window().fullscreen();
        return driver;
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    public static Properties initializeProperties() {
        //	action= new Actions(driver);
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/testsettings.properties");
            prop.load( new InputStreamReader(ip, Charset.forName("UTF-8")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public void closeBrowser() throws Exception {
        driver.quit();
    }

}
