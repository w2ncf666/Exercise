package com.wcf.service;

import com.wcf.mapper.BrandMapper;
import com.wcf.pojo.Brand;
import com.wcf.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

   /* @Override
    public List<Brand> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return brands;
    }*/

    @Override
    public void add(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession(true);
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.add(brand);
       // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();

    }

    @Override
    public Brand selectById(int id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        Brand brand = mapper.selectById(id);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
        return brand;
    }

    @Override
    public void update(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession(true);
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.update(brand);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();

    }

    @Override
    public void deleteById(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession(true);
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.deleteById(brand);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession(true);
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

   /* @Override
    public List<Brand> selectByConditions(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectByConditions(brand);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
        return brands;
    }*/

   /* @Override
    public List<Brand> selectAllLimit(int begin, int end) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAllLimit(begin,end);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
        return brands;
    }*/

    @Override
    public Integer selectTotalCount(Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        Integer count = mapper.selectTotalCount(brand);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
        return count;
    }

    @Override
    public List<Brand> selectByPageAndCondition(int begin, int end, Brand brand) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //处理数据

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            companyName = "%" + companyName + "%";
            brand.setCompanyName(companyName);
        }
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brandName = "%" + brandName + "%";
            brand.setBrandName(brandName);
        }

        //4. 调用方法
        List<Brand> brands = mapper.selectByPageAndCondition(begin,end,brand);
        // sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
        return brands;
    }

}
