package com.mobei.app.entity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-07-31 下午 17:36
 *
 *       推广位的实体bean定义
 */
public class PromoteEntity {

    private String name;// 资讯名称

    private String describe;// 描述

    private String imgUrl;// 封面地址

    private int type;// 1.分类引导 2.产品类别 3.指定产品

    private int columnId;// 栏目id

    private int id;

    private int productId;

    private String itemUrl;

    private String linkUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
