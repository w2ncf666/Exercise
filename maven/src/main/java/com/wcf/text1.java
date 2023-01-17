package com.wcf;

import com.wcf.pojo.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class text1 {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<user> users = sqlSession.selectList("com.wcf.mapper.textmapper.selectall");
        System.out.println(users);
        sqlSession.close();
    }
}
