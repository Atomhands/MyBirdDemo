package com.niehao.mapper;

import com.niehao.model.Boss;

import java.util.List;

/**
 * ClassName: BossMapper
 * Package: com.niehao.mapper
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/17 18:23
 * @Version 1.0
 */
public interface BossMapper {
    Boss queryAccount(String account);

    List<Boss> listBoss();
}
