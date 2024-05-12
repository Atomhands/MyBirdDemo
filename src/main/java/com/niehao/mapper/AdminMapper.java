package com.niehao.mapper;

import com.niehao.model.Admin;

import java.util.List;

/**
 * ClassName: AdminMapper
 * Package: com.niehao.mapper
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:47
 * @Version 1.0
 */
public interface AdminMapper {
   Admin queryLog(String name);

    Admin queryAccount(String name);
}
