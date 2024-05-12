package com.niehao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * ClassName: MybatisConfig
 * Package: com.niehao.config
 * Description:
 *
 * @Author NieHao
 * @Create 2023/8/16 17:03
 * @Version 1.0
 */
@PropertySource({"classpath:db.properties"})
@Configuration
@MapperScan("com.niehao.mapper")
public class MybatisConfig {
    @Resource
    private Environment env;

    //初始化数据库连接池  托管给spring   DruidDataSource
    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pwd"));
        return dataSource;
    }
    //初始化分页工具
    @Bean("interceptor")
    public PageInterceptor interceptor(){
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "oracle");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params=count", "countSql");
        properties.setProperty("autoRuntimeDialect", "true");
        interceptor.setProperties(properties);
        return interceptor;
    }
    //初始化mybatis 会话工厂 初始化Mybatis  mapper容器  工厂模式 创建  SqlSession  原来是工具类的SqLSessionFactory
    @Bean("sessionFactory")
    public SqlSessionFactoryBean sessionFactory(
            @Qualifier("dataSource") DataSource dataSource,
            @Qualifier("interceptor") PageInterceptor interceptor)throws Exception{
        SqlSessionFactoryBean session = new SqlSessionFactoryBean();
        session.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        session.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml"));
        session.setPlugins(interceptor);
        return session;
    }
    //初始化事务管理端
    @Bean("transactionManager")
    public TransactionManager transactionManager(
            @Qualifier("dataSource") DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }
}
