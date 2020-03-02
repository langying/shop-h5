package com.mobei.common.jpush;


import com.mobei.common.util.PropertiesUtil;

/**
 * 初始化读取配置
 * @author luck
 */
public class InitJiGuangConfig {

    /**
     * 配置文件地址
     */
    private static PropertiesUtil props;
    static{
        props = new PropertiesUtil("properties/jpush.properties");
    }

    /**
     * 读取极光配置加载到内存中
     */
    protected static final String JPUSH_MASTERSECRET=props.getProperty("jpush.masterSecret");
    protected static final String JPUSH_APPKEY =props.getProperty("jpush.appKey");
    protected static final String JPUSH__APNS_PRODUCTION=props.getProperty("jpush.options.apns_production");
    public static final String JPUSH__TAG=props.getProperty("jpush.tagName");


    public static final String PRODUCT_DETAIL=props.getProperty("productDetail");


    public static final String PRODUCT_APPLY=props.getProperty("productApply");

    public static final String SMS_ID = props.getProperty("sms.user.id");
    public static final String SMS_NAME = props.getProperty("sms.user.name");
    public static final String SMS_PASS = props.getProperty("sms.user.pass");
    public static final String SMS_SIGN = props.getProperty("sms.sign");
    public static final String SMS_SITE = props.getProperty("sms.site");
}
