package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    public static List<Cookie> restAssuredCookies;
    public List<Cookie> getCookies() {
        return this.restAssuredCookies;
    }

    private static String accessToken;
    public String getToken() {
        return this.accessToken;
    }

    private static String userId;
    public String getUserId() {
        return this.userId;
    }

    private static String firstName;
    public String getFirstName() {
        return this.firstName;
    }

    public void setAccessToken(String accessToken) {}

    public void register() {
        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                   .baseUri("https://todo.qacart.com")
                   .header("Content-Type", "application/json")
                   .body(user)
                    .log().all()
                .when()
                   .post(EndPoint.API_Register_Endpoint)
                .then()
                    .log().all()
                   .extract().response();

        if (response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}
