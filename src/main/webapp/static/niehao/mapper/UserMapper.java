package com.niehao.mapper;

import com.niehao.model.User;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.niehao.mapper
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/16 11:55
 * @Version 1.0
 */
public interface UserMapper {
    List<User> listUser();

    User queryAccount(String account);
}
