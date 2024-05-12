package com.niehao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: Num3
 * Package: com.niehao.model
 * Description:
 *
 * @Author NieHao
 * @Create 2023/9/2 20:26
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Num3 {
    private int num1;
    private int num2;
    private int num3;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }
}
