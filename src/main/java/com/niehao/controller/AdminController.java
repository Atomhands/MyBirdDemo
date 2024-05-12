package com.niehao.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.niehao.model.Admin;
import com.niehao.service.AdminService;
import com.niehao.service.AudioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ClassName: AdminController
 * Package: com.niehao.controller
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:44
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/views/Admin",method = {RequestMethod.GET,RequestMethod.POST})
public class AdminController {
    @Resource
    private AdminService service;
    private HttpSession session;

    public void init(){
        session = null;
    }
    @RequestMapping(value = "AdminMain",method = RequestMethod.GET)
    public String login(@RequestParam("account") String name,
                        @RequestParam("password") String password,
                        Admin admin) {
        admin = service.queryLog(name);
        if (ObjectUtil.isEmpty(admin.getName())) {
            System.out.println("账号 不存在");
        }
        if (StrUtil.equals(admin.getPassword(), password)) {
            System.out.println("密码 错误");
        } else {
            return "templates/userMain/main";
        }
        return "templates/userMain/main";
    }
}