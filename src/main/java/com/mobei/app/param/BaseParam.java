package com.mobei.app.param;

import java.util.Calendar;

import com.mobei.common.mail.FF;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-08-10 下午 17:55
 */
public class BaseParam {

    private String t;

    private String udid;

    private String token;

    /* 页码 */
    private Integer page = 1;

    /* 每页条数 */
    private Integer pageSize = 10;

    private Integer userId;

    private String sign;

    public boolean isBad(String ua) {
        ua = ua == null ? null : ua.toLowerCase();
        if (t == null || t.length() <= 0 || ua == null || ua.length() <= 8 || udid == null || udid.length() <= 8) {
            return true;
        }
        if (ua.length() <= 0 || ua.contains("window") || ua.contains("mra58n")) {
            return true;
        }
        if (t.startsWith("0.")) {
            return isBadT0(t);
        }
        if (t.startsWith("1.")) {
            return isBadT1(t);
        }
        return false;
    }

    private boolean isBadT0(String key) {
        return false;
    }

    private boolean isBadT1(String key) {
        return true;
    }

    public static void main(String[] args) {
        String t = "1.10867007304617";
        String key = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.1.1 Safari/605.1.15";
        Calendar c = Calendar.getInstance();
        int len = t.length();
        c.set(Calendar.MINUTE, Integer.parseInt(t.substring(len - 4, len - 2)));
        c.set(Calendar.SECOND, Integer.parseInt(t.substring(len - 2, len)));

        String txt = key.toLowerCase() + " " + FF.toText(c.getTime(), FF.yyyyMMddHHmmss0);
        int code = txt.hashCode();
        if (code < 0) {
            code = Integer.MAX_VALUE + code + 1;
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(txt);
        System.out.println(code);
        System.out.println("1." + code + t.substring(len - 4));
    }

    // -------------------------------------------------------------------------
    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
