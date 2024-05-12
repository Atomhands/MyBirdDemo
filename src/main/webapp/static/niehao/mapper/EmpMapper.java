package com.niehao.mapper;

import com.niehao.model.Emp;
import com.niehao.model.Page;

import java.util.List;

/**
 * ClassName: EmpMapper
 * Package: com.niehao.mapper
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/18 14:11
 * @Version 1.0
 */
public interface EmpMapper {
    List<Emp> listEmp(Page page);

    long selectAll();
}
