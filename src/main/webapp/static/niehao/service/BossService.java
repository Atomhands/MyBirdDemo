package com.niehao.service;

import com.niehao.mapper.BossMapper;
import com.niehao.model.Boss;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: BossService
 * Package: com.niehao.service
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/17 18:23
 * @Version 1.0
 */
@Service
public class BossService {
    @Resource
    private BossMapper mapper;
    public Boss queryAccount(String account) {
        return mapper.queryAccount(account);
    }

    public List<Boss> listBoss() {
        return mapper.listBoss();
    }
}
