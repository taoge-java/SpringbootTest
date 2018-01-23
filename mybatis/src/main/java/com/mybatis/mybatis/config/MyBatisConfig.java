package com.mybatis.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


/**
 * 通过配置文件集成mybatis
 */
@Configuration
public class MyBatisConfig {

    @Value("${mybatis.type-aliases-package}")
    private String basePackage;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.config-location}")
    private String configLocation;//mybatis全局配置文件

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(basePackage);
        try {
            System.err.println(mapperLocations);
            Resource[] resources = new PathMatchingResourcePatternResolver()
                    .getResources(mapperLocations);
            sqlSessionFactoryBean.setMapperLocations(resources);
            sqlSessionFactoryBean.setConfigLocation(
                    new DefaultResourceLoader().getResource(configLocation));
            return  sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
