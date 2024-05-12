package com.niehao.service;

import com.niehao.dto.DataGrid;
import com.niehao.mapper.EmpMapper;
import com.niehao.model.Emp;
import com.niehao.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: EmpService
 * Package: com.niehao.service
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/18 14:30
 * @Version 1.0
 */
@Service
public class EmpService {
    @Resource
    private EmpMapper mapper;

    public List<Emp> listEmp(Page page) {

        return mapper.listEmp(page);
    }

    public long selectAll() {
        return mapper.selectAll();
    }
}
