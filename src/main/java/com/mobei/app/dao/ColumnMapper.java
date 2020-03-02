package com.mobei.app.dao;

import com.mobei.app.entity.ColumnEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface ColumnMapper {


    /**
     * 分页查询列表
     *
     * @return
     */
    List<ColumnEntity> list(@Param("type") int type);
}
