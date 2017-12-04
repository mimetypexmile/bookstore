package com.xzl.bookstore.web;

import com.xzl.bookstore.common.util.CheckUtils;
import com.xzl.bookstore.common.util.IDUtils;
import com.xzl.bookstore.pojo.po.User;
import com.xzl.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public ModelMap register(User user, String repassword, ModelMap map){

        //todo 检验用户
        if(user !=null){
            String username = user.getUsername();
            if(username !=null){
                if(username.length()<6||username.length()>20){
                    //msg1: 用户名长度
                    map.addAttribute("msg1","用户名的长度必须在6到20之间");
                    return map;
                }
            }else{
                map.addAttribute("msg1","用户名不能为空");
            }
            String password = user.getPassword();
            if(password !=null){
                if(password.length()<6||password.length()>20){
                    //msg2: 密码长度
                    map.addAttribute("msg2","密码的长度必须在6到20之间");
                    return map;
                }else {
                    if(!password.equals(repassword)){
                        map.addAttribute("msg2","两次密码不一致");
                        return map;
                    }
                }
            }else{
                map.addAttribute("msg2","密码不能为空");
            }
            String email = user.getEmail();
            if(email != null){
                boolean bool = CheckUtils.isEmail(email);
                if(!bool){
                    map.addAttribute("msg3","邮箱不符合格式");
                    return map;
                }
            }
            String tel = user.getTel();
            if(tel!=null){
                boolean bool = CheckUtils.isMobile(tel);
                if(!bool){
                    map.addAttribute("msg3","联系方式不符合格式");
                    return map;
                }
            }
        }
        user.setId(IDUtils.generateId());
        user.setAccount(1000.0);
        String md5_password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5_password);
        user.setRegisterTime(new Date());

        int i = userService.saveUser(user);
        if(i>0){
            map.addAttribute("success","注册成功");
        }
        return map;
    }

    @RequestMapping("/login")
    public String login(User user, ModelMap map, HttpSession session){
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        boolean bool = userService.login(user);
        if(bool){
            session.setAttribute("loginUser",user);
            return "index";
        }
        map.addAttribute("return_username",user.getUsername());
        return "login";
    }
}
