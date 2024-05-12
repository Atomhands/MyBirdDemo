package com.niehao.controller;

import com.niehao.service.AudioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ClassName: AudioController
 * Package: com.niehao.controller
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 14:37
 * @Version 1.0
 */
@Controller
@RequestMapping("/MyBirdMFCC")
public class AudioController {
    @Resource
    private AudioService service;

    @GetMapping(value = "/Login/bird")
    public String index(){
        service.queryDB();
        System.out.println("my index");
        return "templates/userMain/login";
    }
}
