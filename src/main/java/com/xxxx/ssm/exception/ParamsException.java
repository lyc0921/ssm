package com.xxxx.ssm.exception;

import com.xxxx.ssm.po.User;
import com.xxxx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ParamsException extends RuntimeException {
    private Integer code = 300;
    private String msg = "参数异常!";
    public ParamsException() {
        super("参数异常!");
    }
    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
    }
    public ParamsException(Integer code) {
        super("参数异常!");
        this.code = code;
    }
    public ParamsException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
