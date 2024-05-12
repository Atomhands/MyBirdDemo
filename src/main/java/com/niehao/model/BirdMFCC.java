package com.niehao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ClassName: BirdMFCC
 * Package: com.niehao.model
 * Description:
 *
 * @Author NieHao
 * @Create 2024/5/9 16:37
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BirdMFCC {
    private String birdId;
    private String birdName;
    private String mfcc;
}
