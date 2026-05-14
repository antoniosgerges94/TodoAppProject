package com.qacart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSeleniumCookies(
            List<io.restassured.http.Cookie> restAssuredCookies) {

        List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>();

        for (io.restassured.http.Cookie cookie : restAssuredCookies) {
            seleniumCookies.add(
                    new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue())
            );
        }

        return seleniumCookies;
    }
}