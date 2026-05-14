package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void Login_functionality() {

        LoginPage loginPage = new LoginPage(getDriver());

        boolean textCheck =
                loginPage
                  .load()
                  .login(ConfigUtils.getInstance().getEmail() , ConfigUtils.getInstance().getPassword())
                  .isWelcomeMessageDisplayed();
        Assert.assertTrue(textCheck);

    }
}
