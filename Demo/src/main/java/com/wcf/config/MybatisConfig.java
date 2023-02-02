package com.wcf.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);//设置数据库连接池,本来是没有设置的,看以前的mybatis配置文件就可以
        factoryBean.setTypeAliasesPackage("com.wcf.pojo");
        return factoryBean;
    }


    @Bean/*代理把dao实现类包含进来了,所以spring不需要扫描dao*/
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
        msc.setBasePackage("com.wcf.dao");
        return msc;
    }
}
