package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Todo App")
@Feature("Todo Feature")

public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test

    public void AddNewTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = newTodoPage
                .load()
                .addNewTask("Learn Selenium")
                .getTodoText();
        Assert.assertEquals(actualResult, "Learn Selenium");
    }

    @Story("Delete Todo")
    @Test

    public void DeleteTodo() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean isNoTodosMessageDisplayed = todoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodosMessageDisplayed();
        Assert.assertTrue(isNoTodosMessageDisplayed);
    }
}