package com.wcf.text;

import com.wcf.mapper.BrandMapper;
import com.wcf.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        int id=3;
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brands = brandMapper.selectByid(id);

        System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }

    /*@Test
    public void testSelectByCondition() throws IOException {
        int status=1;
        String companyName="华为";
        String brandName="华为";
        //处理用户传入的参数
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

//        以下是封装对象过程;
      *//*  Brand brand=new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);*//*
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);

        System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }*/

    @Test
    public void testSelectByCondition3() throws IOException {
        //int status=1;
        //String companyName="米";
        String brandName="鼠";
        //处理用户传入的参数
        //companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

//        以下是封装对象过程;
        Brand brand=new Brand();
        //brand.setBrandName(brandName);
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);

        //以下是传入map集合方法
        /*Map map=new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);

        System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        int status=1;
        String companyName="波导有限公司";
        String brandName="波导手机";
        String description="手机中的战斗机";
        int order=100;
        //处理用户传入的参数
        //companyName="%"+companyName+"%";
        //brandName="%"+brandName+"%";

//        以下是封装对象过程;
        Brand brand=new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setOrdered(order);
        brand.setDescription(description);

        //以下是传入map集合方法
        /*Map map=new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//此处管理是否开启事务,true表示自动提交事务,不开启事务
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        Integer id = brand.getId();//此处注意!无法在此时获取id,因为没有给id赋值,并且此时还没提交事务,数据库数据还未更新.
System.out.println(id);
        //sqlSession.commit();//默认是手动提交事务
        //System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }


    @Test
    public void testupdate() throws IOException {
        int status=1;
        String companyName="波导";
        String brandName="波导手机";
        String description="手机中的战斗机";
        int order=55;
        int id=9;
        //处理用户传入的参数
        //companyName="%"+companyName+"%";
        //brandName="%"+brandName+"%";

//        以下是封装对象过程;
        Brand brand=new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setOrdered(order);
        brand.setDescription(description);
        brand.setId(id);

        //以下是传入map集合方法
        /*Map map=new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//此处管理是否开启事务,true表示自动提交事务,不开启事务
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.update(brand);
        //Integer id = brand.getId();//此处注意!无法在此时获取id,因为没有给id赋值,并且此时还没提交事务,数据库数据还未更新.
//System.out.println(id);
        //sqlSession.commit();//默认是手动提交事务
        //System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }
@Test
    public void testDelete() throws IOException {
        int status=1;
        String companyName="波导";
        String brandName="波导手机";
        String description="手机中的战斗机";
        int order=55;
        int id=7;
        int[] ids={10,11,12,13,14};
        //处理用户传入的参数
        //companyName="%"+companyName+"%";
        //brandName="%"+brandName+"%";

//        以下是封装对象过程;
        Brand brand=new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setOrdered(order);
        brand.setDescription(description);
        //brand.setId(id);

        //以下是传入map集合方法
        /*Map map=new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);*/
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//此处管理是否开启事务,true表示自动提交事务,不开启事务
        //3. 执行sql
        //3.1 获取textmapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        //Integer id = brand.getId();//此处注意!无法在此时获取id,因为没有给id赋值,并且此时还没提交事务,数据库数据还未更新.
//System.out.println(id);
        //sqlSession.commit();//默认是手动提交事务
        //System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }
}
