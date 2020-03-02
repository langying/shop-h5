package com.mobei.common.mail;


import com.mobei.common.util.PropertiesUtil;

/**
 * 初始化读取配置
 * @author lhl
 */
public class SubMailConfig {
	
	/**
	 * 配置文件地址
	 */
	private static PropertiesUtil props;
	static{    
        props = new PropertiesUtil("properties/submail.properties");
    }
	
	/**
	 * 读取极光配置加载到内存中
	 */
	protected static final String SUBMAIL_APPID=props.getProperty("submail.appId");
	protected static final String SUBMAIL_APPKEY =props.getProperty("submail.appKey");


}
