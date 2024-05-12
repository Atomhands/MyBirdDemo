package com.niehao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: Boss
 * Package: com.niehao.pojo
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/3 18:57
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boss {
    private String bossId;
    private String account;
    private String password;
    private String name;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd,hh:mm:ss")
    private Date date;

    public String getBossId() {
        return bossId;
    }

    public void setBossId(String bossId) {
        this.bossId = bossId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
