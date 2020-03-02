package com.mobei.common.jpush;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.schedule.ScheduleResult;

import com.alibaba.fastjson.JSON;

/**
 * 极光推送封装 类
 * @author devin
 */
public  class JiGuangUtil implements JiGuangClient{
	
	private Logger logger = LoggerFactory.getLogger(JiGuangUtil.class);
	
	private static JPushClient jpushClient=null; 
	
	
	 /** 
     * @MethodName: getInstance 
     * @Description: 获取推送客户端对象实例 
     * @return 
     * @throws 
     */  
    public static synchronized JPushClient getInstance() {  
        if (jpushClient == null) {  
        	jpushClient = new JPushClient(InitJiGuangConfig.JPUSH_MASTERSECRET, InitJiGuangConfig.JPUSH_APPKEY);            
        }  
        return jpushClient;  
    }  
    

    /**
     * 获取环境标识 
     * 
     * @return boolean
     * */
    public static boolean getisProduction(){
    	  String apns_production=InitJiGuangConfig.JPUSH__APNS_PRODUCTION;
    	  if(apns_production.equals("true")){
    		  return true;
    	  }else{
    		  return false;
    	  }    	
    }
	@Override
	public String pushMsgByAlias(String message, List<String> aliasList,
			Map<String, String> extras) {		
		 PushResult result = null;  
         try {  
        	 PushPayload payload=allPlatformAndAlias(message,aliasList,extras);
             result = getInstance().sendPush(payload);  
             logger.info("push result is " + result);
        } catch (APIConnectionException e) {  
            // TODO Auto-generated catch block  
        	logger.error("Connection error. Should retry later. ", e);  
        } catch (APIRequestException e) {  
        	logger.error("Error response from JPush server. Should review and fix it. ", e);
        	logger.info("HTTP Status: " + e.getStatus());
        	logger.info("Error Code: " + e.getErrorCode());
        	logger.info("Error Message: " + e.getErrorMessage());  
        }  
        return JSON.toJSONString(result);  		
	}

	@Override
	public String scheduleMsgByTag(String message,String name,String tag,String time,
			Map<String, String> extras) {
		 ScheduleResult result=null;
		  try {			           
			    PushPayload payload=alertPlatformAndTag(message,tag,extras);	
			    logger.info("payload:"+JSON.toJSONString(payload));
	            result =getInstance().createSingleSchedule(name, time,payload);	           
	            logger.info("schedule result is " + result);
	        } catch (APIConnectionException e) {
	        	logger.error("Connection error. Should retry later. ", e);
	        } catch (APIRequestException e) {
	        	logger.error("Error response from JPush server. Should review and fix it. ", e);
	        	logger.info("HTTP Status: " + e.getStatus());
	        	logger.info("Error Code: " + e.getErrorCode());
	        	logger.info("Error Message: " + e.getErrorMessage());
	        }catch(Exception e){
	        	logger.error("Error jpush"+e);
	        }
		  return JSON.toJSONString(result);
	}
	
	
	@Override
	public String pushMsgByTagList(String message, List<String> tagList,
			Map<String, String> extras) {
		 PushResult result = null;  
         try {  
        	 PushPayload payload=allPlatformAndTagList(message,tagList,extras);
             result = getInstance().sendPush(payload);  
             logger.info("push result is " + result);
        } catch (APIConnectionException e) {  
            // TODO Auto-generated catch block  
        	logger.error("Connection error. Should retry later. ", e);  
        } catch (APIRequestException e) {  
        	logger.error("Error response from JPush server. Should review and fix it. ", e);
        	logger.info("HTTP Status: " + e.getStatus());
        	logger.info("Error Code: " + e.getErrorCode());
        	logger.info("Error Message: " + e.getErrorMessage());  
        }  
        return JSON.toJSONString(result);  		
	}
	
	
	
	@Override
	public String getScheduleById(String scheduleId) {
		 ScheduleResult result=null;
		  try {			  
	            result =getInstance().getSchedule(scheduleId);	           
	            logger.info("schedule result is " + result);
	        } catch (APIConnectionException e) {
	        	logger.error("Connection error. Should retry later. ", e);
	        } catch (APIRequestException e) {
	        	logger.error("Error response from JPush server. Should review and fix it. ", e);
	        	logger.info("HTTP Status: " + e.getStatus());
	        	logger.info("Error Code: " + e.getErrorCode());
	        	logger.info("Error Message: " + e.getErrorMessage());
	        }
		  return JSON.toJSONString(result);
	}
	
	
	 /** 
     * 极光推送：生成向一个或者一组别名用户发送的消息。 
     */  
    private static PushPayload allPlatformAndAlias(String alert,List<String> aliasList,Map<String, String> extras)  
    {  
  
        return PushPayload  
                .newBuilder()  
                .setPlatform(Platform.all())  
                .setAudience(Audience.alias(aliasList))  
                .setNotification(  
                        Notification  
                                .newBuilder()  
                                .setAlert(alert)  
                                .addPlatformNotification(  
                                        AndroidNotification.newBuilder().addExtras(extras).build())  
                                .addPlatformNotification(  
                                        IosNotification.newBuilder().addExtras(extras).build())  
                                .build())  
                .setOptions(Options.newBuilder().setApnsProduction(getisProduction()).build()).build();  
    }  
    
    /** 
     * 极光推送：生成向一个或者一组别名用户发送的消息。 
     */  
    private static PushPayload allPlatformAndTagList(String alert,List<String> aliasList,Map<String, String> extras)  
    {  
    	  return new Builder()
         .setPlatform(Platform.all())
         .setAudience(Audience.tag(aliasList))
         .setNotification(  
                   Notification  
                           .newBuilder()  
                           .setAlert(alert)  
                           .addPlatformNotification(  
                                     AndroidNotification.newBuilder().addExtras(extras).build())  
                           .addPlatformNotification(  
                                     IosNotification.newBuilder().addExtras(extras).build())  
                           .build())  
        .setOptions(Options.newBuilder().setApnsProduction(getisProduction()).build()).build();  
    }  
    
    
    
    /**极光推送：向一个标签组的用户发送信息*/
    public static PushPayload alertPlatformAndTag(String alert,String tag,Map<String, String> extras) {
        return new Builder()
            .setPlatform(Platform.all())
            .setAudience(Audience.tag(tag))
            .setNotification(  
                      Notification  
                              .newBuilder()  
                              .setAlert(alert)  
                              .addPlatformNotification(  
                                        AndroidNotification.newBuilder().addExtras(extras).build())  
                              .addPlatformNotification(  
                                        IosNotification.newBuilder().addExtras(extras).build())  
                              .build())  
           .setMessage(Message.newBuilder()
        		            .setMsgContent(alert)
        		            .addExtras(extras).build()
        		      )                   
           .setOptions(Options.newBuilder().setApnsProduction(getisProduction()).build()).build();  
    }
    
    /**极光推送：向所有的用户发送通知信息*/
    public static PushPayload alertPlatformAll(String alert,Map<String, String> extras){
    	 return new Builder()
         .setPlatform(Platform.all())
         .setAudience(Audience.all())
         .setNotification(  
                   Notification  
                           .newBuilder()  
                           .setAlert(alert)  
                           .addPlatformNotification(  
                                     AndroidNotification.newBuilder().addExtras(extras).build())  
                           .addPlatformNotification(  
                                     IosNotification.newBuilder().addExtras(extras).build())  
                           .build())  
        .setMessage(Message.newBuilder()
     		            .setMsgContent(alert)
     		            .addExtras(extras).build()
     		      )                   
        .setOptions(Options.newBuilder().setApnsProduction(getisProduction()).build()).build();
    	   	
    }
    
    /**极光推送：向所有的用户发送通知信息*/
    public static PushPayload alertPlatformAll(String alert){
    	 return new Builder()
         .setPlatform(Platform.all())
         .setAudience(Audience.all())
         .setNotification(  
                   Notification  
                           .newBuilder()  
                           .setAlert(alert)  
                           .addPlatformNotification(  
                                     AndroidNotification.newBuilder().build())  
                           .addPlatformNotification(  
                                     IosNotification.newBuilder().build())  
                           .build())  
        .setMessage(Message.newBuilder()
     		            .setMsgContent(alert)
     		            .build()
     		      )                   
        .setOptions(Options.newBuilder().setApnsProduction(getisProduction()).build()).build();
    	   	
    }

  
	@Override
	public String scheduleMsgByAlias(String message, String name, String time,List<String> aliasList, Map<String, String> extras) {
		  ScheduleResult result=null;
		  try {
			    PushPayload payload=allPlatformAndTagList(message,aliasList,extras);			   
	            result =getInstance().createSingleSchedule(name,time,payload);	           
	            logger.info("schedule result is " + result);
	        } catch (APIConnectionException e) {
	        	logger.error("Connection error. Should retry later. ", e);
	        } catch (APIRequestException e) {
	        	logger.error("Error response from JPush server. Should review and fix it. ", e);
	        	logger.info("HTTP Status: " + e.getStatus());
	        	logger.info("Error Code: " + e.getErrorCode());
	        	logger.info("Error Message: " + e.getErrorMessage());
	        }
		  return JSON.toJSONString(result);
	}

	@Override
	public String pushMsgAll(String message, Map<String, String> extras) {
		 PushResult result = null;  
         try {  
        	 PushPayload payload=alertPlatformAll(message,extras);
             result = getInstance().sendPush(payload);  
             logger.info("push result is " + result);
        } catch (APIConnectionException e) {  
            // TODO Auto-generated catch block  
        	logger.error("Connection error. Should retry later. ", e);  
        } catch (APIRequestException e) {  
        	logger.error("Error response from JPush server. Should review and fix it. ", e);
        	logger.info("HTTP Status: " + e.getStatus());
        	logger.info("Error Code: " + e.getErrorCode());
        	logger.info("Error Message: " + e.getErrorMessage());  
        }  
        return JSON.toJSONString(result);  	
	}

	@Override
	public String pushMsgAll(String message) {
		 PushResult result = null;  
         try {  
        	 PushPayload payload=alertPlatformAll(message);
             result = getInstance().sendPush(payload);  
             logger.info("push result is " + result);
        } catch (APIConnectionException e) {  
            // TODO Auto-generated catch block  
        	logger.error("Connection error. Should retry later. ", e);  
        } catch (APIRequestException e) {  
        	logger.error("Error response from JPush server. Should review and fix it. ", e);
        	logger.info("HTTP Status: " + e.getStatus());
        	logger.info("Error Code: " + e.getErrorCode());
        	logger.info("Error Message: " + e.getErrorMessage());  
        }  
        return JSON.toJSONString(result);  	
	}

	
}
