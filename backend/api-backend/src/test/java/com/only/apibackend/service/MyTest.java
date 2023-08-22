package com.only.apibackend.service;

import com.google.gson.Gson;
import com.only.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    void test1() {
        User user = new User("only");
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
        String one = "{username:only}";
        User user1 = gson.fromJson(one, User.class);
        System.out.println(user1);
    }
}
