package com.mobei.app.entity;

import com.mobei.common.entity.BaseEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-08-04 下午 12:20
 *
 *       申请以及浏览产品实体bean定义
 */
public class ApplyEntity extends BaseEntity {

    private int productId;// 产品id

    private int userId;// 用户id

    private String content;

    /**
     * apply.vue在App的返回页面里面体现
     * 1: 已申请
     * 2: 没有提交
     * 3: 我要申诉
     */
    private int type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
