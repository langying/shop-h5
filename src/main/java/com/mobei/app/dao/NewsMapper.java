package com.mobei.app.dao;

import com.mobei.app.entity.NewsEntity;

import java.util.List;

/**
 * 轮播图的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface NewsMapper {


    /**
     * 分页查询列表
     *
     * @return
     */
    List<NewsEntity> list();


    /**查询详情*/
    NewsEntity findById(int id);

    /**修改浏览数*/
    int updateBrowse(int id);


}
