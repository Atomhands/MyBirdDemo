package com.niehao.mapper;

import com.niehao.model.BirdMFCC;

import java.util.List;

/**
 * ClassName: AudioMapper
 * Package: com.niehao.mapper
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:33
 * @Version 1.0
 */
public interface AudioMapper {
    public List<BirdMFCC> queryDB();
}
