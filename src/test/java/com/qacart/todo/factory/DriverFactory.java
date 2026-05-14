package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

  public WebDriver initializeDriver() {

      String browser = System.getProperty("browser","EDGE");

      WebDriver driver;

      switch (browser) {

        case "EDGE":
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        break;

        case "CHROME":
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          break;

        case "FIREFOX":
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;

        case "SAFARI":
          driver = new SafariDriver();
          break;

          default:
            throw new RuntimeException("This is not a valid browser");
      }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.manage().window().maximize();
    return driver;
  }
}
