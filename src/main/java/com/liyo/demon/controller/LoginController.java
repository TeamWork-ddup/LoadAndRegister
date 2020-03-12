package com.liyo.demon.controller;

import com.liyo.demon.entity.User;
import com.liyo.demon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(User user){
        if(user.getId() == null || user.getPassword() == null) {
            return "loginFail";
        }
        if(userService.login(user)){
            return "loginSuccess";
        }
        return "loginFail";

    }

    @PostMapping("/register")
    public String register(User user, ModelMap model){

        if(user.getId() == null || user.getPassword() == null){
            model.addAttribute("result","参数错误！！！");
        } else {
            if(userService.insertUser(user)){
                model.addAttribute("result","注册成功！！！");
            }else {
                model.addAttribute("result","注册失败，账号已经存在！！！");
            }
        }
        return "registerResult";
    }

}
