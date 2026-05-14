package com.qacart.todo.base;

import com.qacart.todo.utils.CookieUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public void setup() {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            getDriver().quit();
        }
    }

    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
       List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie : seleniumCookies) {
            getDriver().manage().addCookie(cookie);
        }
    }
}