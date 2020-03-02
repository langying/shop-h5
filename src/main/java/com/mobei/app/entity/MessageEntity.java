package com.mobei.app.entity;

import com.mobei.common.entity.BaseEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-08-04 上午 11:21
 *
 *       消息通知实体bean定义
 */
public class MessageEntity extends BaseEntity {

    private String title;// 标题

    private Integer type;// 跳转类型

    private String channel;// 渠道 android或者ios

    private String content;// 详情

    private Integer lookFlag = 0;// 0：未读 1：已读

    private String itemUrl;// 其他url地址

    private String linkUrl;// 跳转url地址

    private Integer productId;// 产品id

    private Integer messageId;// 通知id

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLookFlag() {
        return lookFlag;
    }

    public void setLookFlag(Integer lookFlag) {
        this.lookFlag = lookFlag;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
