package com.xxxx.ssm;

import com.xxxx.ssm.exception.BusinessException;
import com.xxxx.ssm.exception.ParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    @ExceptionHandler
    public String exc(HttpServletRequest request, HttpServletResponse response,Exception e){
        request.setAttribute("ex",e);
        if(e instanceof ParamsException){
            return "params_error";
        }
        if(e instanceof BusinessException){
            return "business_error";
        }
        return null;
    }
}
