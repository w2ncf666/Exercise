package com.wcf.service;

import com.wcf.mapper.BrandMapper;
import com.wcf.pojo.Brand;
import com.wcf.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> selectAll(){
        SqlSession sqlsession=sqlSessionFactory.openSession();
        BrandMapper mapper=sqlsession.getMapper(BrandMapper.class);
        List<Brand> brands=mapper.selectAll();
        sqlsession.close();
        return brands;
    }
    public void add(Brand brand){
        SqlSession sqlsession=sqlSessionFactory.openSession();
        BrandMapper mapper=sqlsession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlsession.commit();
        sqlsession.close();
    }

    public Brand selectById(int id){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //Brand brand=mapper.selectByid(id);
        Brand brand=mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //Brand brand=mapper.selectByid(id);
        mapper.update(brand);
        sqlSession.close();
    }


    public void DeleteById(Brand brand){
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //Brand brand=mapper.selectByid(id);
        mapper.DeleteById(brand);
        sqlSession.close();
    }
}
