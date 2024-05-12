package com.niehao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName: Admin
 * Package: com.niehao.model
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:48
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
    private String adminId;
    private String name;
    private String password;
}
