package com.niehao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: Config
 * Package: com.niehao.config
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/16 16:57
 * @Version 1.0
 */
@ComponentScan({"com.niehao.service"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
public class SpringConfig {
}
