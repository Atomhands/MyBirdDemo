package com.niehao.controller;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.niehao.dto.DataGrid;
import com.niehao.http.HttpResult;

import com.niehao.model.Boss;
import com.niehao.model.Emp;
import com.niehao.model.Page;
import com.niehao.service.BossService;
import com.niehao.service.EmpService;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import java.util.List;


/**
 * ClassName: Boss
 * Package: com.niehao.controller
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/3 9:15
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "views/boss",method = {RequestMethod.POST,RequestMethod.GET})
public class BossController {
    @Resource
    private BossService service;
    @Resource
    private EmpService empService;

    @RequestMapping(value = "main")
    public HttpResult login(Boss boss){
        Boss boss1 = service.queryAccount(boss.getAccount());
        if (ObjectUtil.isEmpty(boss1.getAccount())){
            throw new RuntimeException("账号不存在");
        }
        if (!StrUtil.equals(boss1.getPassword(),boss.getPassword())){
            throw new RuntimeException("密码错误");
        }
        //List<Boss> data = service.listBoss();
        return HttpResult.SUCCESS("登陆成功","登陆成功");
    }
//    @RequestMapping(value = "listEmp",method = RequestMethod.GET)
//    public HttpResult<List<Emp>> listEmp(){
//        List<Emp> data = empService.listEmp();
//        return HttpResult.SUCCESS(data,"操作成功");
//    }
    @RequestMapping(value="listEmp",method = RequestMethod.POST)
    @ResponseBody
    public DataGrid list(Page page){
        System.out.println("list");
        int current = Convert.toInt(page.getPageIndex());
        int size = Convert.toInt(page.getPageSize());
        String sortField = Convert.toStr(page.getSortField());
        String sortOrder = Convert.toStr(page.getSortOrder());
        Page page0 = new Page(current, size, sortField, sortOrder);

        page0.setPageIndex(page.getPageIndex()+1);
        //long total = empService.selectAll();
        long total = 16L;
        List<Emp> data = empService.listEmp(page0);
        DataGrid dataGrid = new DataGrid();
        dataGrid.setTotal(total);
        dataGrid.setData(data);
        HttpResult.SUCCESS(data,"查询成功");
        return dataGrid;
        //return HttpResult.SUCCESS("登陆成功","登陆成功");
        //return new ModelAndView("boss/listEmp");
    }
}
