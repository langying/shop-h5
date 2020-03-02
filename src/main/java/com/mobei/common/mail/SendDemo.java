package com.mobei.common.mail;

import org.apache.http.client.fluent.Request;

import java.net.URLEncoder;

/**
 * ��ʾ���뷢�Ͷ��ţ�����������������ʹ�á�����������������ֶ�����
 */
public class SendDemo {

	public static void main(String[] args) throws Exception {
		

		String username = "811449";
		String password = "DEF74BN";
		String url = "http://101.227.68.68:7891/mt";
		

		String mobile = "13168887930";
		String extendCode = "4443";
		String message = "您的登录验证码是：$code,请在2分钟内输入有效";
		

		StringBuilder sb = new StringBuilder(2000);
		sb.append(url);
		sb.append("?dc=15");
		sb.append("&sm=").append( URLEncoder.encode(message, "utf8") );
		sb.append("&da=").append( mobile );
		sb.append("&sa=").append( extendCode );
		sb.append("&un=").append( username );
		sb.append("&pw=").append( password );
		sb.append("&tf=3");
		
		String request = sb.toString();
		System.out.println( request );
		String result = Request.Get( request ).execute().returnContent().asString();
		System.out.println( result );
	}

}
