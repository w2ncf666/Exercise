package com.wcf;

import com.wcf.mapper.textmapper;
import com.wcf.pojo.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class text2 {/**
 * Mybatis 代理开发
 */


    public static void main(String[] args) throws IOException {

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        textmapper textmapper = sqlSession.getMapper(textmapper.class);
        List<user> users = textmapper.selectall();

        System.out.println(users);
        //4. 释放资源
        sqlSession.close();
    }
}

