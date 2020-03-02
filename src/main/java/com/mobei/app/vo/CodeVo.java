package com.mobei.app.vo;

import java.io.Serializable;

public class CodeVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8307227849303766357L;

	public int index;

	public String msg;
	public static CodeVo SUCCESS = new CodeVo(200, "成功");

	public static CodeVo ERROR= new CodeVo(501,"服务异常");
	

	public static CodeVo TOKEN_TEST_ERROR = new CodeVo(304, "用户没有登录!");

	public static CodeVo TOKEN_FLAG_ERROR = new CodeVo(304, "token验证失败!");

	public static CodeVo USER_LOGIN_ERROR=new CodeVo(101,"帐号或者密码有误！");


	public static CodeVo USER_REGISTER_ERROR=new CodeVo(103,"该手机号码已注册!");

	public static CodeVo ACCOUNT_ERROR=new CodeVo(301,"手机号码不为空!");

	public static CodeVo PWD_ERROR=new CodeVo(302,"密码不能为空!");

	public static CodeVo CODE_ERROR=new CodeVo(303,"验证码不能为空!");

	public static CodeVo MSM_EXPIRE_ERROR=new CodeVo(106,"验证码已失效!");

	public static CodeVo SMS_ERROR=new CodeVo(105,"该手机号码暂未注册!");

	public static CodeVo USER_LOGIN_SMS_ERROR=new CodeVo(102,"验证码有误，请重新输入！");
	

	//产品相关
	public static CodeVo PRODUCT_EMPTY_ERROR=new CodeVo(401,"该产品不存在!");

	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CodeVo(int index, String msg) {
		super();
		this.index = index;
		this.msg = msg;
	}

	public CodeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
