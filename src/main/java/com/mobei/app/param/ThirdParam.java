package com.mobei.app.param;

/**
 * (描述用途)
 *
 * @author Sum
 * @date 2018-08-26 下午 16:33
 */
public class ThirdParam extends BaseParam{

    private int messageId;//通知id

    private String ipAddr;//ip地址


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
