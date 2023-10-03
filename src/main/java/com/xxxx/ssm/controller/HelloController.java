package com.xxxx.ssm.controller;

import com.xxxx.ssm.BaseController;
import com.xxxx.ssm.exception.BusinessException;
import com.xxxx.ssm.exception.ParamsException;
import com.xxxx.ssm.po.User;
import com.xxxx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController extends BaseController {
    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
    public String hello(Model model){
        //int i=1/0;

        //参数异常
        if(1==1){
            throw new BusinessException();
        }
        User user=userService.queryUserByUserId(1);
        model.addAttribute("user",user);
        return "hello";
    }
}
