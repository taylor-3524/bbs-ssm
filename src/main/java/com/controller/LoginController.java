package com.controller;

import com.entity.Users;
import com.service.ILoginService;
import com.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/login/index");

        return modelAndView;
    }

    /**
     * 登录(coding)
     * @param c_username
     * @param c_password
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(
            @RequestParam(value = "username",required = true)String c_username,
            @RequestParam(value = "password",required = true)String c_password){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/login/index");
        Users users=new Users();
        users.setUsername(c_username);
        users.setPsw(c_password);
        if(loginService.login(users)){
            //登录成功
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        return modelAndView;
    }
}
