package com.xxxx.ssm.controller;

import com.xxxx.ssm.BaseController;
import com.xxxx.ssm.exception.BusinessException;
import com.xxxx.ssm.po.Account;
import com.xxxx.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * RestFul URL 配置
 *      1. 设置请求类型
 *          GET（查询）     @GetMapping
 *          DELETE（删除）  @DeleteMapping
 *          POST（添加）    @PostMapping
 *          PUT（更新）     @PutMapping
 *      2. URL设置时，不体现动作行为 （没有动词）
 *          例如：/account/1、/account/2、/account
 *      3. 定义参数格式
 *          1. 路径参数 （ @PathVariable ）
 *          2. json格式 （ @RequestBody ）
 *          3. 普通表单参数
 *      4. 设置响应数据
 *          json格式 （ @ResponseBody ）
 */
@Controller
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;
    /**
     * 查询操作
     *      传统的 URL 访问：
     *          http://localhost:8080/ssm/account/queryAccountById?id=1
     *      RestFul URL 访问：
     *          @GetMapping("/account/{id}")
     *          http://localhost:8080/ssm/account/1
     *      @PathVariable 将形参设置为参数路径，声明在形参前面
     * @param id
     * @return
     */
    //@RequestMapping("/account/queryAccountById")
    @GetMapping("/account/{id}")
    @ResponseBody
    public Account queryAccountById(@PathVariable Integer id){
        if(1==1){
            throw new BusinessException();
        }
        Account account=accountService.selectById(id);
        return account;
    }

    @DeleteMapping("/account/{id}")
    @ResponseBody
    public Map deleteAccountById(@PathVariable Integer id){
        Map<String,String> map=new HashMap();
        int result=accountService.delAccount(id);
        if(result>0){
            map.put("code","1");
            map.put("msg","删除成功");
        }else {
            map.put("code","0");
            map.put("msg","删除失败");
        }
        return map;
    }
    /*@PostMapping("/account")
    @ResponseBody
    public Map updateAccount(@RequestBody Account account){
        Map<String,String> map=new HashMap<>();
        int result=accountService.saveAccount(account);
        if(result>0){
            map.put("code","1");
            map.put("msg","添加成功");
        }else {
            map.put("code","0");
            map.put("msg","添加失败");
        }
        return map;
    }*/
    @PutMapping("/account")
    @ResponseBody
    public Map updateAccount(@RequestBody Account account){
        Map<String,String> map=new HashMap<>();
        int result=accountService.updateAccount(account);
        if(result>0){
            map.put("code","1");
            map.put("msg","更新成功");
        }else {
            map.put("code","0");
            map.put("msg","更新失败");
        }
        return map;
    }
}
