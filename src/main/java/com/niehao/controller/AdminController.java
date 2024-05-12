package com.niehao.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.niehao.http.HttpResult;
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
    public HttpResult login(HttpServletRequest req, Admin admin) {
        Admin user = service.queryAccount(admin.getAccount());
        if (ObjectUtil.isEmpty(user.getAccount())){
            throw new RuntimeException("账号不存在");
        }
        if (!StrUtil.equals(user.getPassword(),user.getPassword())){
            throw new RuntimeException("密码错误");
        }
//        String birthDate = "";
//        String birth = user.getBirth();
//        if (birth.contains("T")) {
//            birthDate = birth.replace("T", " ");
//        }
//        user.setDate(sdf.parse(birthDate));
//        //保存登陆的日期
        //session.setAttribute("birthDate",birthDate);
        return HttpResult.SUCCESS("登陆成功","登陆成功");
    }
}