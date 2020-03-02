package com.mobei.app.dao;

import com.mobei.app.entity.FeedBackEntity;

/**
 * 轮播图的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface FeedBackMapper {


    /**
     * 添加意见反馈
     *
     * @return
     */
    int save(FeedBackEntity entity);
}
