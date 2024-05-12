package com.niehao.service;

import com.niehao.dto.Time;
import com.niehao.http.HttpResult;
import com.niehao.mapper.UserMapper;
import com.niehao.model.User;
import com.niehao.utils.Bazi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.niehao.utils.SolarToLunar.solarToLunar;

/**
 * ClassName: UserService
 * Package: com.niehao.service
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/16 11:57
 * @Version 1.0
 */
@Service
public class UserService {
    @Resource
    private UserMapper mapper;
    public List<User> listUser() {
        return mapper.listUser();
    }

    public User queryAccount(String account) {
        return mapper.queryAccount(account);
    }

    public HttpResult DateTo(Time dateT) {
        int[] date = new int[3];
        //转农历
        for (int i = 0; i < 3; i++) {
            date[i] = solarToLunar(dateT.getYear(), dateT.getMonth(), dateT.getDay())[i];
        }
        //计算八字
        return Bazi.calculate(date[0],date[1],dateT.getMonth(),dateT.getDay(),dateT.getHour());
    }
}
