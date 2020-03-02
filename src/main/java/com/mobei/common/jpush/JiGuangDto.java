package com.mobei.common.jpush;

/**发送请求到极光服务器，返回内容实体bean定义
 * 
 * @author devin
 * @date 2017-08-28
 * */
public class JiGuangDto {
	
	private String schedule_id;
	
	private String name;

	

	public String getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
