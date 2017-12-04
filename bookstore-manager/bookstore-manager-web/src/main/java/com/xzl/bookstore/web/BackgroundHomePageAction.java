package com.xzl.bookstore.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 得到后台首页的action
 */
@Controller
public class BackgroundHomePageAction {

    @RequestMapping("/")
    public String getBackgroundHomePage(){

        return "index";
    }
}
