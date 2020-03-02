package com.mobei.common.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;
 
/**
 * 获取Properties属性
 * @author luck
 */
public class PropertiesUtil {    
    
    private Properties props;
    
    private Logger log = LoggerFactory.getLogger(PropertiesUtil.class);
      
    public PropertiesUtil(String fileName){    
        try {    
            props = new Properties();    
            InputStream fis =  Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);  
            props.load(fis);    
        } catch (Exception e) {    
            log.error("===============>>文件名称:" + fileName + ",异常:" +e);    
        }    
    }    
    /**  
     * 获取某个属性  
     */    
    public String getProperty(String key){    
        return props.getProperty(key);    
    }
} 
