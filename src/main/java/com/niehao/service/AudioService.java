package com.niehao.service;

import com.niehao.mapper.AudioMapper;
import com.niehao.model.BirdMFCC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: AudioService
 * Package: com.niehao.service
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:33
 * @Version 1.0
 */
@Service
public class AudioService {
    @Resource
    private AudioMapper mapper;
    public void queryDB() {
        List<BirdMFCC> birdMFCCS = mapper.queryDB();
    }
}
