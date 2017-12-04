package com.xzl.bookstore.service.impl;

import com.xzl.bookstore.dao.UserCustomMapper;
import com.xzl.bookstore.dao.UserMapper;
import com.xzl.bookstore.pojo.po.User;
import com.xzl.bookstore.pojo.po.UserExample;
import com.xzl.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userDao;

    @Autowired
    private UserCustomMapper userCustomDao;
    @Override
    public int saveUser(User user){
        int count = 0;
        try{
            count = userDao.insertSelective(user);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean login(User user) {
        User u = null;
        try {
            u = userCustomDao.login(user);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        if(u != null){
            return true;
        }
        return false;
    }
}
