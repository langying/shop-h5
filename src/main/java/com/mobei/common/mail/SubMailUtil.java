package com.mobei.common.mail;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mobei.common.jpush.InitJiGuangConfig;

/**
 * (描述用途)
 * 赛邮云通信的短信下发封装类
 *
 * @author lhl
 * @date 2018-08-07 下午 19:55
 *
 */
public class SubMailUtil {

    private static String LOGIN_SMS_MESSAGE = "【{}】您的登录验证码是{},请在2分钟内输入有效";

    private static String REGISTER_SMS_MESSAGE = "【{}】您注册的验证码是{},请在2分钟内输入有效";

    private static String EDITPWD_SMS_MESSAGE = "【{}】您修改密码的验证码是{},请在2分钟内输入有效";

    private static final SimpleDateFormat kFMT = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINESE);

    public static String sendSMS(String code, Integer type, String phone) {
        String content = "";
        if (type == 1) {
            content = LOGIN_SMS_MESSAGE;
        }
        else if (type == 2) {
            content = REGISTER_SMS_MESSAGE;
        }
        else if (type == 3) {
            content = EDITPWD_SMS_MESSAGE;
        }
        content = FF.log(content, InitJiGuangConfig.SMS_SIGN, code);
        if ("1922".equals(InitJiGuangConfig.SMS_ID)) {
            return sendSMS0(content, phone);
        }
        else {
            return sendSMS1(content, phone);
        }
    }

    public static String sendSMS0(String content, String phone) {
        try {
            String sm = URLEncoder.encode(content, "utf8");
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("un", InitJiGuangConfig.SMS_NAME);
            paramMap.put("pw", InitJiGuangConfig.SMS_PASS);
            paramMap.put("da", phone);
            paramMap.put("sm", sm);
            return TianChangClient.SendPOST("mt", paramMap);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sendSMS1(String content, String phone) {
        try {
            Map<String, String> data = makeSignedMap("send", InitJiGuangConfig.SMS_ID, InitJiGuangConfig.SMS_NAME, InitJiGuangConfig.SMS_PASS);
            data.put("extno", "");
            data.put("sendTime", "");
            data.put("mobile", phone);
            data.put("content", content);
            String html = IE.post(InitJiGuangConfig.SMS_SITE, null, data);
            JSONObject json = JSON.parseObject(html);
            if ("Success".equalsIgnoreCase(json.getString("ReturnStatus"))) {
                return "短信已发送";
            }
            else {
                return "短信发送失败";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return "系统繁忙";
        }
    }

    private static Map<String, String> makeSignedMap(String action, String userid, String username, String password) {
        String timestamp = kFMT.format(new Date());
        String sign = DigestUtils.md5Hex(username + password + timestamp);
        Map<String, String> map = new HashMap<>();
        map.put("rt", "json");
        map.put("sign", sign);
        map.put("action", action);
        map.put("userid", userid);
        map.put("timestamp", timestamp);
        return map;
    }

    public static void main(String[] args) throws Exception {
        sendSMS("1900", 1, "18094714299");
    }

}
