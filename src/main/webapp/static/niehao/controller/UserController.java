package com.niehao.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.niehao.dto.Time;
import com.niehao.http.HttpResult;
import com.niehao.model.Boss;
import com.niehao.model.Num3;
import com.niehao.model.User;
import com.niehao.service.UserService;
import com.niehao.utils.HeTu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ClassName: UserController
 * Package: com.niehao.controller
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/16 16:14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "views/user",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
    @Resource
    private UserService service;
    private HttpSession session;
    public void init(){
        session = null;
    }
    @RequestMapping(value = "userMain",method = RequestMethod.GET)
    public HttpResult login(User user,HttpServletRequest req) throws ParseException {
        session = req.getSession();
        User user0 = service.queryAccount(user.getAccount());
        if (ObjectUtil.isEmpty(user0.getAccount())){
            throw new RuntimeException("账号不存在");
        }
        if (!StrUtil.equals(user0.getPassword(),user0.getPassword())){
            throw new RuntimeException("密码错误");
        }

        String birthDate = "";
        String birth = user.getBirth();
        if (birth.contains("T")) {
            birthDate = birth.replace("T", " ");
        }
        user.setDate(sdf.parse(birthDate));
        //保存登陆的日期
        session.setAttribute("birthDate",birthDate);
        return HttpResult.SUCCESS("登陆成功","登陆成功");
    }
    @RequestMapping(value = "getTime",method = RequestMethod.GET)
    public HttpResult SysgetTime(Date date0,User user){
        Date date = new Date();
        String time = sdf.format(date);
        int year = Integer.parseInt(time.substring(0,4));

        int month = Integer.parseInt(time.substring(5,7));

        int day = Integer.parseInt(time.substring(8,10));
        int hour = Integer.parseInt(time.substring(11,13));
        Time dateT = new Time(year,month,day,hour);


        return service.DateTo(dateT);
    }
    @RequestMapping(value = "getLoginTime",method = RequestMethod.GET)
    public HttpResult calculateBaZi(){
        String birth =String.valueOf(session.getAttribute("birthDate"));

        int year = Integer.parseInt(birth.substring(0,4));

        int month = Integer.parseInt(birth.substring(5,7));

        int day = Integer.parseInt(birth.substring(8,10));
        int hour = Integer.parseInt(birth.substring(11,13));
        Time dateT = new Time(year,month,day,hour);
        return service.DateTo(dateT);
    }
    @RequestMapping(value = "saveTime",method = RequestMethod.GET)
    public HttpResult saveTime(User user) throws ParseException {
        String date = user.getBirth();
        String birthDate="";
        if (date.contains("T")) {
            birthDate = date.replace("T", " ");
        }
        user.setDate(sdf.parse(birthDate));
        session.setAttribute("birthDate",birthDate);
        return calculateBaZi();
    }
    @RequestMapping(value = "CustomTag",method = RequestMethod.POST)
    private HttpResult Num3(Num3 num){
        System.out.println("Num3");
        int num1 = num.getNum1(),num2 = num.getNum2(), num3 = num.getNum3();
        if (num1>8) num1=num1%8;
        num1=(num1==0)?8:num1;

        if (num2>8) num2=num2%8;
        num2=(num2==0)?8:num2;

        if (num3>6) num3=num3%6;
        num3=(num3==0)?6:num3;
        HeTu data = new HeTu(num1,num2);
        System.out.println("1-乾 2-兑 3-离 4-震 5-巽 6-坎 7-艮 8-坤");
        System.out.println("上卦是:"+num1+"\t"+"下挂是"+num2+"\t"+"变爻是"+num3);
        System.out.println(data);
        return HttpResult.SUCCESS(data,"上卦是:"+num1+"\t"+"下挂是"+num2+"\t"+"变爻是"+num3+"\t"+"1-乾 2-兑 3-离 4-震 5-巽 6-坎 7-艮 8-坤");
    }
}
