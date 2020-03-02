package com.mobei.app.vo;

import java.util.UUID;

/**
 * 吐出到前端并序列化为json的bean
 * @author lhl
 */
public class ResultVo {

	/**返回码*/
	private int code;
	/**说明*/
	private String desc;
	/**请求随机UUID*/
	private String tid = UUID.randomUUID().toString();
	/**返回数据*/
	private Object data;
	
	public ResultVo() {}
	
	public ResultVo(CodeVo code) {
		this.code = code.getIndex();
		this.desc = code.getMsg();
	}
	
	public ResultVo(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public ResultVo(int code, String desc, Object data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}
	
	public ResultVo(CodeVo code, Object data) {
		this.code = code.getIndex();
		this.desc = code.getMsg();
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public void setCode(CodeVo code){
		this.code = code.getIndex();
		this.desc = code.getMsg();
	}
	
}
