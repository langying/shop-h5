package com.mobei.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mobei.app.entity.ProductBrowseEntity;

/**
 * 产品的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface ProductBrowseMapper {

    /**
     * 分页查询列表
     *
     * @return
     */
    List<ProductBrowseEntity> list(int userId);

    /** 添加申请记录 */
    int save(@Param("userId") int userId, //
            @Param("productId") int productId, //
            @Param("days") String days, //
            @Param("udid") String udid, //
            @Param("ipAddr") String ipAddr);

}
