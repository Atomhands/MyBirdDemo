package com.niehao.service;

import com.niehao.mapper.AdminMapper;
import com.niehao.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: AdminService
 * Package: com.niehao.service
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:47
 * @Version 1.0
 */
@Service
public class AdminService {
    @Resource
    private AdminMapper mapper;
    public Admin queryLog(String admin) {
        return mapper.queryLog(admin);
    }
    public Admin queryAccount(String account){
        return mapper.queryAccount(account);
    }
}
