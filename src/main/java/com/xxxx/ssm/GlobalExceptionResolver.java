package com.xxxx.ssm;

import com.xxxx.ssm.exception.BusinessException;
import com.xxxx.ssm.exception.ParamsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("error");
        mv.addObject("ex","默认的错误处理");
        if(e instanceof ParamsException){
            mv.setViewName("params_error");
            ParamsException ex=(ParamsException) e;
            mv.addObject("ex",ex.getMsg());
        }
        if(e instanceof BusinessException){
            mv.setViewName("business_error");
            BusinessException ex=(BusinessException) e;
            mv.addObject("ex",ex.getMsg());
        }
        return mv;
    }
}
