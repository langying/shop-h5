package com.mobei.common.entity;

/**
 * (描述用途)
 *
 * @author Sum
 * @date 2018-07-31 下午 16:38
 */
public class BaseEntity {

    private int id;//唯一标识

    private String createTime;//创建时间

    private String updateTiem;//修改时间

    private int delFlag;//删除   0：正常  1：删除

    private int status;//状态    0：上架  1：下架


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTiem() {
        return updateTiem;
    }

    public void setUpdateTiem(String updateTiem) {
        this.updateTiem = updateTiem;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
