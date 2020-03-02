package com.mobei.app.entity;

import com.mobei.common.entity.BaseEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-08-04 上午 11:38
 *
 * 第三方链接实体bean定义
 */
public class ThirdEntity extends BaseEntity{

    private String name;//第三方名称

    private int type;//类型   1：第三方链接   2：平台关联

    private String linkUrl;//第三方链接地址

    private int productId;//产品id

    private String code;//跳转码

    private String mirrorUrl;//镜像地址




    public String getMirrorUrl() {
        return mirrorUrl;
    }

    public void setMirrorUrl(String mirrorUrl) {
        this.mirrorUrl = mirrorUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
