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
public class AgentEntity extends BaseEntity{

    private String name;//第三方名称

    private String linkUrl;//第三方链接地址

    private String code;//跳转码


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
