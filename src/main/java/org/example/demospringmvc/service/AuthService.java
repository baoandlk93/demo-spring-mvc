package org.example.demospringmvc.service;

import org.example.demospringmvc.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AuthService implements IAuthService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "admin", "admin"));
        users.add(new User(2, "user", "user"));

    }
    @Override
    public void login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    public User register(String username, String password) {
        User user = new User();
        user.setId(users.size() + 1);
        user.setUsername(username);
        user.setPassword(password);
        users.add(user);
        return user;
    }
}
