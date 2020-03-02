package com.mobei.app.entity;

import com.mobei.common.entity.BaseEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-08-04 上午 11:21
 *
 * 意见反馈
 */
public class FeedBackEntity extends BaseEntity{

    private String tags;//标题

    private String  content;//跳转类型

    private String days;

    private int userId;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
