package com.mobei.common.jpush;

import java.util.List;
import java.util.Map;

/**极光推送接口定义类
 * @author devin
 * @date 2017-08-24
 * */
public interface JiGuangClient {
	
	/**
	 * 给指定的别名用户发送通知信息
	 * @author devin
	 * @date 2017-08-24
	 * @param message  通知信息   
	 * @param aliasList 指定发送的用户
	 * @param extras 额外的信息，用来做指定的处理
	 * */
	 public String pushMsgByAlias(String message, List<String> aliasList, Map<String, String> extras);
	 
	 
	 /**给单个或者多个指定的别名用户，发送定时通知信息
	  * @author devin
	  * @date 2017-08-24
	  * @param message 通知信息
	  * @param name 定时任务名称
	  * @param time 定時時間
	  * @param aliasList 指定发送的用户
	  * @param extras 额外的信息，用来做指定的处理
	  * */
	 public String scheduleMsgByAlias(String message, String name, String time, List<String> aliasList, Map<String, String> extras);
	 
	 
	 /**给单个指定的标签组用户，发送定时通知信息
	  * @author devin
	  * @date 2017-08-24
	  * @param message 通知信息
	  * @param name 定时任务名称
	  * @param time 定時時間
	  * @param tag 标签名称
	  * @param extras 额外的信息，用来做指定的处理
	  * */
	 public String scheduleMsgByTag(String message, String name, String time, String tag, Map<String, String> extras);
	 
	 
	 /**给单个或者多个指定的标签组，发送及时通知信息
	  * @author devin
	  * @date 2017-08-25
	  * @param message 通知信息
	  * @param tagList 标签组
	  * @param extras 额外的信息，用来做指定的处理
	  * */
	 public String pushMsgByTagList(String message, List<String> tagList, Map<String, String> extras);
	 
	 
	 /**
	  * 根据schedule_id查询指定的定时任务
	  * @author devin
	  * @date 2017-08-28
	  * @param scheduleId
	  * 
	  * */
	 public String getScheduleById(String scheduleId);
	 
	 
	 /**
	  * 给所有用户发送广告通知,并带有额外参数
	  * @author devin.li
	  * @date 2017-09-08
	  * */
	 public String pushMsgAll(String message, Map<String, String> extras);
	 
	 
	 /**
	  * 给所有用户发送广告通知,无额外参数
	  * @author devin.li
	  * @date 2017-09-08
	  * */
	 public String pushMsgAll(String message);

}
