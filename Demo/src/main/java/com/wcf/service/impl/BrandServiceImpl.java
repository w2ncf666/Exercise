package com.wcf.service.impl;

import com.wcf.dao.BrandMapper;
import com.wcf.pojo.Brand;
import com.wcf.pojo.Code;
import com.wcf.pojo.Page;
import com.wcf.pojo.SystemException;
import com.wcf.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    //private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();    没用SpringMvc前


    @Autowired//用了SpringMvc后
    private BrandMapper brandMapper;//代码时期报错  原理是:brandMapper本来是session创建出来的,
                                                // 而session是SqlSessionFactoryBean创建出来的,
                                                // session已经在spring容器里面了,相当于brandMapper也在,
                                                // 他会在需要的时候创建出来并注入
                                                // 因此自动按类型注入该依赖,大大简化开发!!
/*
* 用了SpringMvc后就不用Factory工厂的工具类,也不用手动创建session,和mybatis-config.xml  直接mvc一条龙
* */


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

       /* Integer add = brandMapper.add(brand);
        if (add == null)
            throw new SystemException(Code.SYSTEM_ERR, "新增失败,请联系管理员");
         */

        if (brandMapper.add(brand) == null)
            throw new SystemException(Code.SYSTEM_ERR, "新增失败,请联系管理员");
        /** 以下是没用SpringMvc前
         *
         //2. 获取SqlSession对象
         SqlSession sqlSession = factory.openSession(true);
         //3. 获取BrandMapper
         BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

         //4. 调用方法
         mapper.add(brand);
         // sqlSession.commit();
         //5. 释放资源
         sqlSession.close();
         */


    }

    @Override
    public Brand selectById(int id) {

        Brand brand = brandMapper.selectById(id);
        if (brand == null)
            throw new SystemException(Code.SYSTEM_ERR, "检索单体失败,请联系管理员");
        else return brand;

        /**
         * 以下是没用SpringMvc前
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
         */
    }

    @Override
    public void update(Brand brand) {

        if (brandMapper.update(brand) == null)
            throw new SystemException(Code.SYSTEM_ERR, "编辑失败,请联系管理员");

        /**
         * 以下是没用SpringMvc前
         //2. 获取SqlSession对象
         SqlSession sqlSession = factory.openSession(true);
         //3. 获取BrandMapper
         BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

         //4. 调用方法
         mapper.update(brand);
         // sqlSession.commit();
         //5. 释放资源
         sqlSession.close();
         */
    }

    @Override
    public void deleteById(Brand brand) {
        Integer deleteById = brandMapper.deleteById(brand);
        if (deleteById == null)
            throw new SystemException(Code.SYSTEM_ERR, "删除单体失败,请联系管理员");

        /**
         * 以下是没用SpringMvc前
         //2. 获取SqlSession对象
         SqlSession sqlSession = factory.openSession(true);
         //3. 获取BrandMapper
         BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

         //4. 调用方法
         mapper.deleteById(brand);
         // sqlSession.commit();
         //5. 释放资源
         sqlSession.close();
         */
    }

    @Override
    public void deleteByIds(int[] ids) {

        if (brandMapper.deleteByIds(ids) == null)
            throw new SystemException(Code.SYSTEM_ERR, "批量删除失败,请联系管理员");


        /**
         * 以下是没用SpringMvc前
         //2. 获取SqlSession对象
         SqlSession sqlSession = factory.openSession(true);
         //3. 获取BrandMapper
         BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

         //4. 调用方法
         mapper.deleteByIds(ids);
         // sqlSession.commit();
         //5. 释放资源
         sqlSession.close();
         */
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

        Integer totalCount = brandMapper.selectTotalCount(brand);
        if (totalCount == null)
            throw new SystemException(Code.SYSTEM_ERR, "初始化数量失败,请联系管理员");
        else return totalCount;

        /**
         * 以下是没用SpringMvc前
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
         */
    }

    @Override
    public Page<Brand> selectByPageAndCondition(int currentPage, int size, Brand brand) {

        //处理数据

        int begin = (currentPage - 1) * size;

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
        //(current - 1) * size, size,
        /*Integer totalCount = brandMapper.selectTotalCount(brand);*/
        Integer totalCount = this.selectTotalCount(brand);
        List<Brand> brandList = brandMapper.selectByPageAndCondition(begin, size, brand);
        if (brandList == null)
            throw new SystemException(Code.SYSTEM_ERR, "初始化表单数据失败,请联系管理员");
        return new Page<Brand>(totalCount, brandList);
        /**
         * 以下是没用SpringMvc前
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
         */
    }
}
