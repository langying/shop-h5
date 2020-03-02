package com.mobei.app.entity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-07-31 下午 17:36
 *
 * 资讯的实体bean定义
 */
public class NewsEntity{

    private String name;//资讯名称

    private String title;//标题

    private String imgUrl;//封面地址

    private int browseNum;//浏览次数

    private String content;//资讯详情

    private int id;//资讯id

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(int browseNum) {
        this.browseNum = browseNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
