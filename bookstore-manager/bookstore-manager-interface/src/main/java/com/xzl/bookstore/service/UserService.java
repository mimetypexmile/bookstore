package com.xzl.bookstore.service;

import com.xzl.bookstore.pojo.po.User;

public interface UserService {
    int saveUser(User user);

    boolean login(User user);
}
