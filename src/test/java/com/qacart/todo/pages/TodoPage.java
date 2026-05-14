package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class TodoPage extends BasePage {

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-text\"]")   // adjust if your todo text has a different testid
    private WebElement todoText;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodosMessage;

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.Todo_Endpoint);
        return this;
    }

    public boolean isWelcomeMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(welcomeMessage)
        );
        return element.isDisplayed();
    }

    public NewTodoPage clickOnPlusButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addButton))
                .click();
        return new NewTodoPage(driver);
    }

    public String getTodoText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(todoText));
        return todoText.getText();
    }

    public TodoPage clickOnDeleteButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[data-testid='delete']")
        )).click();
        return this;
    }

    public boolean isNoTodosMessageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(noTodosMessage));
        return noTodosMessage.isDisplayed();
    }
}