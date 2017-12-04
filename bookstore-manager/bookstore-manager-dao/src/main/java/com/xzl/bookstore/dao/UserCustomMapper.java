package com.xzl.bookstore.dao;

import com.xzl.bookstore.pojo.po.User;

public interface UserCustomMapper {

    User login(User user);

    int updateAccount(User user);

}
