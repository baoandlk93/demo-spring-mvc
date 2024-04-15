package org.example.demospringmvc.service;

import org.example.demospringmvc.entity.User;

public interface IAuthService {
    void login(String username, String password);
    User register(String username, String password);


}
