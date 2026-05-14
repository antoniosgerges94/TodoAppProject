package com.qacart.todo.base;

import com.qacart.todo.utils.CookieUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--inprivate");
        WebDriver webDriver = new EdgeDriver(options);
        webDriver.manage().window().maximize();
        setDriver(webDriver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            String testCaseName = result.getMethod().getMethodName();
            File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
            takesScreenshot(destFile);
            getDriver().quit();
        }
    }

    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
       List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie : seleniumCookies) {
            getDriver().manage().addCookie(cookie);
        }
    }

    public void takesScreenshot(File destFile) {

        File file= ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destFile);
            InputStream inputStream = new FileInputStream(destFile);
            Allure.addAttachment("Screenshot",inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}