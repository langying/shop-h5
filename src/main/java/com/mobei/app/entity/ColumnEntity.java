package com.mobei.app.entity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-07-31 下午 17:36
 *
 * 轮播广告和推荐广告实体bean定义
 */
public class ColumnEntity{

    private String name;//标题

    private String imgUrl;//封面地址

    private String amountScope;//金额范围 2000元以下

    private String describe;//描述

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAmountScope() {
        return amountScope;
    }

    public void setAmountScope(String amountScope) {
        this.amountScope = amountScope;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
