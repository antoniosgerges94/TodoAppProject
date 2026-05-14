package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.Authenticator;
import java.time.Duration;

@Epic("Todo App")
@Feature("Auth Feature")

public class LoginTest extends BaseTest {

    @Story("Login with Email & Password")
    @Description("Login should happen and user is navigated to the Homepage")
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
