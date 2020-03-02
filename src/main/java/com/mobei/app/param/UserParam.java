package com.mobei.app.param;

/**
 * 用户模块接收参数的实体bean定义
 *
 * @author lhl
 * @date 2018-08-08 下午 17:06
 */
public class UserParam extends BaseParam {

    /** IP */
    private String ip;

    /** 手机帐号 */
    private String account;

    /** 用户密码 */
    private String passWord;

    /** 验证码 */
    private String validCode;

    private String tags;

    private String cotnent;

    private String inviteCode;

    /**
     * 类型
     * 1: 验证码登陆页面
     * 2: 新用户注册页面
     * 3: 设置/修改密码页面
     */
    private int type;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCotnent() {
        return cotnent;
    }

    public void setCotnent(String cotnent) {
        this.cotnent = cotnent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
}
