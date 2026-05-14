package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {

    public static User generateRandomUser() {

        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = "fzapsKUZIXentTM";
        User user = new User(lastName,lastName,email,password);
        return user;
    }
}
