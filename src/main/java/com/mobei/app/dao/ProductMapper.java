package com.mobei.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mobei.app.entity.ApplyEntity;
import com.mobei.app.entity.ProductEntity;
import com.mobei.app.param.ProductParam;

/**
 * 产品的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface ProductMapper {

    /**
     * 分页查询列表
     *
     * @return
     */
    List<ProductEntity> list(ProductParam param);

    /** 根据产品id查询详情 */
    ProductEntity findById(int productId);

    /** 查询申请记录 */
    List<ProductEntity> findByUserId(int userId);

    /** 添加申请记录 */
    int saveApply(@Param("userId") int userId, @Param("productId") int productId);

    /** 添加申请人数 */
    int updateTotal(int productId);

    /**
     * 根据栏目查询列表
     *
     * @return
     */
    List<ProductEntity> getColumnList(ProductParam param);

    /** 保存用户反馈的申请记录 */
    int saveRecord(ApplyEntity entity);
}
