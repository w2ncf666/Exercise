package com.wcf.pojo;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.wcf.Util.BaseContextUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Slf4j
@Component
public class DataHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("在这执行1");
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", BaseContextUtil.getCurrentId());
        metaObject.setValue("updateUser", BaseContextUtil.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

log.info("在这执行2");
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContextUtil.getCurrentId());

    }
}
